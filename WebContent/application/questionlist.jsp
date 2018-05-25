<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>確認済みのお問い合わせ</h1>

<table border="1"cellspacing="0">
<tr><td>お問い合わせ内容</td><td>ニックネーム</td></tr>
<c:forEach items="${questionlist2}" var="q2">
<tr><td>${q2.question}</td><td>${q2.name}</td></tr>
</c:forEach>
</table>
<a href="/appli/ReloginServlet">戻る</a>
</body>
</html>