<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>NoticeList</title>
<script type="text/javascript">
	var m = '${message}';	//redirect로 받아온 메세지
	if(m != ""){
		alert(m);
	}
</script>

</head>
<body>
<h2>Notice List</h2>
<div class="container">
	  <table class="table table-striped">
		<tr><td>num</td><td>writer</td><td>title</td><td>reg_date</td><td>hit</td></tr>
		<c:forEach items="${list}" var="dto" >
			<tr><td>${dto.num}</td><td>${dto.writer}</td><td><a href="noticeView?${dto.num}"> ${dto.title}</a> </td><td>${dto.reg_date}</td><td>${dto.hit}</td></tr>
		</c:forEach>
	</table>
<a href="noticeWrite" class="btn btn-default" style="margin: 0 auto;">NoticeWrite</a>
</div>




</body>
</html>