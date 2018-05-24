<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/appli/QuestionServlet" method="post">
ニックネーム<br>
<input type="text" name="name"/><br>
お問い合わせ内容<br>
<textarea name="question" cols="50" rows="10"></textarea><br>
<input type="submit" value="送信"/>


</form>
</body>
</html>