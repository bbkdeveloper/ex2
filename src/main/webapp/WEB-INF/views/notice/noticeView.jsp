<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>NOTICE VIEW</h2>

<table >
			<thead>
				<tr >
					<th>TITLE</th><th width="100px">WRITER</th><th width="100px">DATE</th><th width="15px">HIT</th>					
				</tr>
			</thead>
			<tbody>				
				<tr >
					<td>TITLE :${dto.title }</td>
					<td>WRITER : ${dto.writer }</td>			
					<td>${dto.reg_date }</td>			
					<td>${dto.hit }</td>			
				</tr>
				<tr class="contents">
					<td colspan="3" >CONTENTS</td>
				</tr>
				
				<a href="noticeDelete?num=${noticeDTO.num}">NoticeDelete</a>
			</tbody>
		</table>
		
		<a href="noticeUpdate" class="btn btn-default" style="margin: 0 auto;">NoticeUpdate</a>
</body>
</html>