<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String message;
String s=(String)request.getAttribute("name1");
%>
<%
if(s==null){
%>
<jsp:forward page="/application/gatcha.jsp"/>
<%} %>
<%int a=(Integer) request.getAttribute("STAR1"); %>
<% switch(a){
case 1:
	message="ざーんねん";
	break;
case 2:
	message="微妙";
	break;
case 3:
	message="まあまあ";
	break;
case 4:
	message="やったね";
	break;
case 5:
	message="おめでとう";
	break;
default:
	message="開発者もびっくり";
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
<h1>あなたの来世評価：<font color="red"><%=message %></font></h1><br>
<%if(a==1){ %>
<img src="/appli/imge/note_kurorekishi.png"width="240" height="240" />
<body bgcolor="#FF66FF"/>
<%}else if(a==2){ %>
<img src="/appli/imge/sns_nakamahazure_man.png" width="240" height="240" />
<body bgcolor="#FFFF66"/>
<%}else if(a==3){ %>
<img src="/appli/imge/teinen_slowlife.png" width="240" height="240"/>
<body bgcolor="orange"/>
<%}else if(a==4){ %>
<img src="/appli/imge/happy_family.png" width="240" height="240"/>
<body bgcolor="skyblue"/>
<%}else if(a==5){ %>
<img src="/appli/imge/wedding_syukufuku.png" width="240" height="240"/>
<body bgcolor="lightgreen"/>
<%} else{%>
<img src="/appli/imge/hqdefault.jpg"width="380"height="380">
<%} %>
<h1><font color="green">${name1}</font></h1>
<h1><font color="gold">★${STAR1}</font></h1><br>

<h3><font color="black">これが今回の結果です</font></h3>

<br>
<br>
<a href="/appli/application/record.jsp">記録する方はこちら</a>
<br>
<br>
<a href="/appli/gatchaServlet">もう一度引く</a>
<br><br>
<a href="/appli/application/gatcha.jsp">もう一度ガチャボタン押したい！</a>
<br><br>
<a href="/appli/application/Master.jsp">管理者用アクセス</a>
</body>
</html>