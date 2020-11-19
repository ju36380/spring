<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>주소등록</title>
		
	</head>
	<body>
		<h1>[주소등록]</h1>
		<form action="update" method="post">
		<input type = "hidden" name = "ano" value = "${vo.ano }">
			<table border = 1>
				<tr>
					<td width = 80>이름: </td>
					<td width = 120><input type = "text" name = "name" value="${vo.name }"></td>
				</tr>
				<tr>
					<td width = 80>번호: </td>
					<td width = 120><input type = "text" name = "tel" value="${vo.tel }"></td>
				</tr>
				<tr>
					<td width = 80>주소: </td>
					<td width = 120><input type = "text" name = "addr" value="${vo.addr }"></td>
				</tr>
			</table>
			<input type = "submit" value = "수정">
			<input type = "button" value = "삭제" id = "btnDelete">
			<input type = "reset" value = "취소">
			<input type = "button" value = "목록" onClick="location.href='list'">
		</form>
	</body>
	<script src="../resources/home.js"></script>
	<script>
		$("#btnDelete").on("click", function(){
			if(!confirm("삭제?")) return;
				location.href="delete?ano=${vo.ano}";
			
		});
	</script>
</html>