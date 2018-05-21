<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String s=(String)session.getAttribute("name");
String a=(String)session.getAttribute("name2");
String b=(String)session.getAttribute("name3");
%>
<%if(s==null&&a==null&&b==null){ %>
<jsp:forward page="/application/record.jsp"/>
<%} %>
<%
session.getAttribute("STAR2");
session.getAttribute("STAR3");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${name}さんの前世は</h1>
<h1>${name2}</h1><h1>${name3}</h1><br>
<h1>★${STAR2}${STAR3}</h1>

<a href="/appli/application/gatcha.jsp">トップへ</a>

<a href="/appli/RecordServlet?record=Logout">ログアウト</a>
</body>
</html>