<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
	<td>${pBoard.pbNum}</td>
	<td><img title="${pBoard.pbRealPath}"
	width="30" src="${pBoard.pbFilePath}"
	alt="${pBoard.pbRealPath}">
	${pBoard.pbTitle}</td>
	<td>${pBoard.pbCredat}</td>
	<td>${pBoard.pbCretim}</td>
</tr>
</table>
</body>
</html>