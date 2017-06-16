package com.choa.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choa.util.DBConnector;
import com.choa.util.RowMaker;

//Repository : NoticeDAO noticeDAO = new NoticeDAO();

@Repository("notice")		//("notice")는 id가 된다
public class NoticeDAO {

	@Inject
	private DataSource dataSource;
	//dataSource는 우리가 만든 코드가 아니기 때문에 열어볼 수 없으므로 xml에서 해결해야한다
	
	//inject를 이용하기때문에, 생성자가 필요가 없다
	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/

	
	
	//totalCount
	public int noticeCount()throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql = "select nvl(count(num), 0) from notice";
		//count(num)이 null이면 0이라고 하자는 nvl(,)
		
		st = con.prepareStatement(sql);
		rs = st.executeQuery();
		rs.next();
		result = rs.getInt(1);
		
		DBConnector.disConnect(rs, st, con);
		return result;
	}
	
	//NoticeList
	public List<NoticeDTO> noticeList(RowMaker rowMaker)throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		List<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		NoticeDTO noticeDTO = null;
		
		String sql = "select * from "
				+ "(select rownum R, N.* from "
				+ "(select * from notice order by num desc) N) "
				+ "where R between ? and ?";
		
		st = con.prepareStatement(sql);
		st.setInt(1, rowMaker.getStartRow());
		st.setInt(2, rowMaker.getLastRow());
		
		rs = st.executeQuery();
	
		while(rs.next()){
			noticeDTO = new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setReg_date(rs.getDate("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
			ar.add(noticeDTO);
		}
		DBConnector.disConnect(rs, st, con);
		
	
		return ar;
	}
	
	//NoticeView
	public NoticeDTO noticeView(int num)throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		NoticeDTO noticeDTO =new NoticeDTO();;
		
		String sql="select * from notice where num=?";
		st = con.prepareStatement(sql);
		st.setInt(1, num);
		rs = st.executeQuery();
		
		if(rs.next()){
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setReg_date(rs.getDate("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
		}
		DBConnector.disConnect(rs, st, con);
		return noticeDTO;
	}
	
	//NoticeWrite
	public int noticeWrite(NoticeDTO noticeDTO)throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;
		
		String sql="insert into notice values(notice_seq.nextval,?,?,?,sysdate,0)";
		st = con.prepareStatement(sql);		
		
		st.setString(1, noticeDTO.getWriter());
		st.setString(2, noticeDTO.getTitle());
		st.setString(3, noticeDTO.getContents());
		
		
		result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	
	//NoticeUpdate
	public int noticeUpdate(NoticeDTO noticeDTO)throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;
		
		String sql="update notice set title=?, contents=? where num=?";
		st = con.prepareStatement(sql);		
		
		
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getContents());
		st.setInt(3, noticeDTO.getNum());
		
		result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	
	
	//NoticeDelete
	public int noticeDelete(int num)throws Exception{
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		String sql="delete notice where num=?";
		st = con.prepareStatement(sql);		
		st.setInt(1, num);
		
		result = st.executeUpdate();
		
		return result;
	}
}
