<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
String s=(String)session.getAttribute("name");
 %>
 <%if(s==null){ %>
 <jsp:forward page="/application/premium.jsp"/>
 <%} %>
 <%
 request.getAttribute("stone");
 request.getAttribute("message");
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
<h2>あなたの残り石数は${stone}です。</h2>
<br><h3 class="z">${message}</h3><br>
<form action="/appli/PremiumGatchaServlet" method="post">
<input type="submit" value="★３確定！プレミアムガチャを引く" class="a"/>
</form>
<br><br>
<form action="/appli/gatchaServlet"method="post">
<input type ="submit"value ="ガチャを引く" class="a"/>
</form>
<br>
<br>
<a href="/appli/PremiumServlet?record=Logout">ログアウト</a>

</body>
</html>