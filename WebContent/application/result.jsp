<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String message;
request.getAttribute("name1");
int a=(Integer) request.getAttribute("STAR1");
%>
<% switch(a){
case 1:
	message="くそったれ";
	break;
case 2:
	message="爆死";
	break;
case 3:
	message="ノーマル";
	break;
case 4:
	message="激レア";
	break;
case 5:
	message="超激レア";
	break;
default:
	message="???";
	break;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=message %>
${name1}
${STAR1}<br>
これが今回の結果です
</body>
</html>