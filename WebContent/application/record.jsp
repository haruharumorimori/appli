<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%

 request.getAttribute("message");
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${message}
<form action="/appli/RecordServlet" method="post">
ニックネーム:<input type="text" name="name"/><br>
パスワード:<input type="password" name="pass"/><br>
<input type="submit" value="login"/>
<input type="hidden" name="record" value="login"/>
</form>
</body>
</html>