<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/pboard/insert" method="post"
	enctype="multipart/form-data">
	<table border="1">
	<tr>
		<th>제목</th>
		<td><input type="text" name="pb_title"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="pb_content"></textarea></td>
	</tr>
	<tr>
		<th>사진</th>
		<td><input type="file" name="pb_file_path"></td>
	</tr>
	<tr>
		<td colspan="2"><button>업로드</button></td>
	</tr>
	</table>
</form>
</body>
</html>