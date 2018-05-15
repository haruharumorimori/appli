<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.getAttribute("NAME");
request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>${NAME}様。ようこそ！</h1><br>
<h2>いかがいたしますか</h2>
<br>
${message}
<form action="/appli/ContorollServlet" method="post">
名前<input type="text" name="name"/>、レアリティ<input type="text" name="star"/>を増やす
<input type="submit" value="増加"/>
<input type="hidden" name="action" value="add"/>
</form>
<br>
<form action="/appli/ContorollServlet" method="post">
ID:<input type="text" name="id"/> 名前:<input type="text" name="name"/> レアリティ:<input type="text" name="star"/>を更新する
<input type="submit" value ="更新"/>
<input type="hidden" name="action" value="update"/>
</form>
<br>
<form action="/appli/ContorollServlet" method="post">
名前<input type="text" name="name"/>、レアリティ<input type="text" name="star"/>を削除する
<input type="submit" value="削除"/>
<input type="hidden" name="action" value="delete"/>
</form>
</body>
</html>