<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/appli/application/a.css" type="text/css"/>
</head>
<body>
<h1 style=color:green class="b">ガチャガチャ</h1>
<h2 style=color:yellow class="c">あなたの来世は????</h2>
<img src="/appli/imge/gachagacha_hazure_man.png" width="240" height="240"/>
<form action="/appli/gatchaServlet"method="post">
<input type ="submit"value ="ガチャを引く" class="a"/>
</form>
<br>

<a href="/appli/application/premium.jsp">プレミアムガチャはこちら</a>
<br>
<a href="/appli/application/record.jsp">記録を見る</a>
<br><br>
<a href="/appli/application/Master.jsp">管理者はこちら</a>

</body>
</html>