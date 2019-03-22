<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 조회</title>
</head>
<body>
<table border="1">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성일</th>
	<th>작성시간</th>
</tr>
<c:forEach var="pBoard" items="${pBoardList}">
<tr>
	<td>${pBoard.pbNum}</td>
	<td><img title="${pBoard.pbRealPath}"
	width="30" src="${pBoard.pbFilePath}"
	alt="${pBoard.pbRealPath}">
	${pBoard.pbTitle}</td>
	<td>${pBoard.pbCredat}</td>
	<td>${pBoard.pbCretim}</td>
</tr>
</c:forEach>
</table>
</body>
</html>