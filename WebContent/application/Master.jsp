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
<form action="/appli/MasterServlet" method="post">
お名前<input type ="text" name="name"/><br>
パスワード<input type="password" name="pass"/><br>
<input type ="submit" value="ログイン"/><br>
<input type="hidden" name="log" value="login"/>
<br><br>
${message}<br><br>

<a href="/appli/application/gatcha.jsp">ガチャに戻る</a>
<br><br>


</form>
</body>
</html>