<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h2>Write Form</h2>
<div class="container">
<form action="notice${path}" method="post">

	  <table class="table table-striped">

				<tr>
					<td>title</td><td>WRITER</td>					
				</tr>
				<tr >
					<td><input type="hidden" name="num" placeholder="title" value="${dto.num}"></td>
					<td><input type="text" name="title" placeholder="title" value="${dto.title }"></td>
					<td><input type="text" name="writer" placeholder="writer" value="${dto.writer }"></td>
							
				</tr>
						
				<tr>
					<td colspan="2">contents</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="contents" value="${dto.contents }"> </td>			
				</tr>
				<tr class="contents">
					<td colspan="3" ></td>
				</tr>
			</tbody>
		</table>
		<button type="submit" class="btn btn-default">Write</button>
</form>

</div>
</body>
</html>