<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.getAttribute("name");
session.getAttribute("name2");
session.getAttribute("STAR2");
session.getAttribute("name3");
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
</body>
</html>