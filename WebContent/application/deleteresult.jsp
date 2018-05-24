<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String a=(String)request.getAttribute("message"); %>
<%
if (a==null){
%>
<jsp:forward page="/application/delete.jsp"/>
<%} %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${message }</h1>
SNOOPY<br>
　　 ●<br>
　　/⌒ヽ<br>
　 ｜ 　|/⌒ヽ(ヽ<br>
　 (｀　∥ー⌒) |<br>
　|￣||￣￣￣￣￣|<br>
　|―||―――――|<br>
　|　Ｕ　　　　　|<br>
　|￣￣￣￣￣￣￣|<br>
　|＿＿＿＿＿＿＿|<br>
　　|―――――|<br>
　　|―――――|<br>
ｗｗＷｗｗＷｗＷＷｗ<br>
<a href="/appli/application/gatcha.jsp">トップへ</a>
</body>
</html>