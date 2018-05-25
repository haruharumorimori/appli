<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String message=(String)request.getAttribute("message");
%>
<%if(message==null){ %>
<jsp:forward page="/application/question.jsp"/>
<%} %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${message}</h1>
<br><br><br>
<a href="/appli/application/gatcha.jsp">トップへ</a>
</body>
</html>