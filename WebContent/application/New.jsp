<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/appli/NewServlet" method="get">
ニックネーム：<input type="text" name="name"/><br><br>
パスワード：<input type="password" name="pass"/><br>
で登録します。
<input type="submit" value="登録"/>
</form>
</body>
</html>