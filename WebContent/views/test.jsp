<%@page import="com.osf.test.vo.PhotoBoardVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
pageContext.setAttribute("str", "난 페이지");
request.setAttribute("str", "난 리퀘스트");
session.setAttribute("str", "난 세션");
application.setAttribute("str", "난 어플리케이션");
Map<String,String> tMap = new HashMap<>();
tMap.put("t_num","1");
tMap.put("t_name","시리");
request.setAttribute("tMap",tMap);
//pageContext.setAttribute("tMap",tMap);
PhotoBoardVO pb = new PhotoBoardVO();
pb.setPbTitle("제목");
pageContext.setAttribute("pb",pb);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${applicationScope.str}<br>
${sessionScope.str}<br>
${requestScope.str}<br>
${pageScope.str}<br>
${tMap.t_name}<br>
${tMap}<br>
<%=tMap.get("t_name") %><br>
${pb.pbTitle}<br>
</body>
</html>