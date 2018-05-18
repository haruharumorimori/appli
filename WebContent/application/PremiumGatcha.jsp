<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 session.getAttribute("name");
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" href="/appli/application/b.css" type="text/css"/>
</head>
<body>
<h1>💰${name }様！ようこそ！💰</h1>
<form action="/appli/PremiumGatchaServlet" method="post">
<input type="submit" value="★３確定！プレミアムガチャを引く" class="a"/>

<br>

</form>

</body>
</html>