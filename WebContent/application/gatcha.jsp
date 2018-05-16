<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ガチャガチャ</h1>
<h2>なにがでるかな～？</h2>
<img src="/appli/imge/gachagacha_hazure_man.png" width="240" height="240"/>
<form action="/appli/gatchaServlet"method="post">
<input type ="submit"value ="ガチャを引く"/>
</form>
<br>

<br><br>
<a href="/appli/application/Master.jsp">管理者はこちら</a>

</body>
</html>