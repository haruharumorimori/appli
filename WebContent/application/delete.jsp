<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/appli/DeleteFormServlet" method="post">
お名前：<input type="text" name="name"/>
パスワード：<input type="password" name="pass"/>
<input type="submit" value="削除する"/>
<br><br>
<input type="radio" name="reason" value="a"/>不快だから<br>
<input type="radio" name="reason" value="b"/>時間の無駄だから<br>
<input type="radio" name="reason" value="c"/>意味が分からないから<br>
<input type="radio" name="reason" value="d"/>面白くねえ<br>
</form><br><br>
<a href="/appli/application/gatcha.jsp">戻る</a>
</body>
</html>