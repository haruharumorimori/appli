<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
session.getAttribute("NAME");
request.getAttribute("message");
request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>${NAME}様!ようこそ！</h1><br>
<h2>いかがいたしますか</h2>
<br>
${message}
<form action="/appli/ContorollServlet" method="post">
名前<input type="text" name="name"/>、レアリティ<input type="text" name="star" maxlength="1"/>を増やす
<input type="submit" value="増加"/>
<input type="hidden" name="action" value="add"/>
</form>
<br>
<form action="/appli/ContorollServlet" method="post">
ID:<input type="number" name="id" /> 名前:<input type="text" name="name"/> レアリティ:<input type="text" name="star" maxlength="1"/>を更新する
<input type="submit" value ="更新"/>
<input type="hidden" name="action" value="update"/>
</form>
<br>
<form action="/appli/ContorollServlet" method="post">
id<input type="number" name="id" />を削除する
<input type="submit" value="削除"/>
<input type="hidden" name="action" value="delete"/>
</form>
<br><br>
<table border="1" cellspacing="0">
<tr><td>ID</td><td>名前</td><td>レアリティ</td></tr>

<c:forEach items="${list}" var="l">
<tr><td>${l.id}</td><td>${l.name}</td><td>${l.star}</td></tr>
</c:forEach>
</table><br><br>
<a href="/appli/application/gatcha.jsp">ガチャに戻る</a>
</body>
</html>