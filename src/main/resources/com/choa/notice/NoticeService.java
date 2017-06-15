package com.choa.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.util.PageMaker;

//NoticeService noticeService = new NoticeService(); 와 같은뜻의 @Service
//xml에 넣는 bean과 같은 코드
@Service
public class NoticeService {

	@Inject
	private NoticeDAO noticeDAO;
	
	//inject를 사용해서 주입하기 때문에, Constructor방법이나 setter가 필요없다
	//Constructor방법
/*	public NoticeService(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO; 
	}
*/	
	//setter방법
	/*	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	*/
	
	//List
	public List<NoticeDTO> noticeList(int curPage)throws Exception{
		int result = noticeDAO.noticeCount();
		
		PageMaker pageMaker = new PageMaker(curPage);
		pageMaker.getMakePage(result);
		return noticeDAO.noticeList(pageMaker.getRowMaker("",""));
		
	}
	
	

	//View
	public NoticeDTO noticeView(int num)throws Exception{
		NoticeDTO noticeDTO = noticeDAO.noticeView(num);
		return noticeDTO;
	}
	
	//Write
	public int noticeWrite(NoticeDTO noticeDTO)throws Exception{
		int result = noticeDAO.noticeWrite(noticeDTO);
		return result;
	}
	
	//Update
	public int noticeUpdate(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.noticeUpdate(noticeDTO);
	}
	
	//Delete
	public int noticeDelete(int num)throws Exception{
		return noticeDAO.noticeDelete(num);
	}
}
