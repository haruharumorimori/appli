<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String message;
request.getAttribute("name1");
int a=(Integer) request.getAttribute("STAR1");
%>
<% switch(a){
case 1:
	message="はい";
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
<h1><font color="red"><%=message %></font></h1><br>
<%if(a==1){ %>
<body background="/appli/imge/tatyannka.jpg" />
<%}else if(a==2){ %>
<img src="/appli/imge/bakudan_hatsugen_man.png" width="240" height="240" />
<%}else if(a==3){ %>
<img src="/appli/imge/internet_f5_attack.png" width="240" height="240"/>
<%}else if(a==4){ %>
<img src="/appli/imge/character_cthulhu_nyarlathotep.png" width="240" height="240"/>
<%}else if(a==5){ %>
<img src="/appli/imge/business_man_macho.png" width="240" height="240"/>
<%} %>
<h1><font color="green">${name1}</font></h1>
<h1><font color="gold">★${STAR1}</font></h1><br>

<font color="green">これが今回の結果です</font>

<br>

<a href="/appli/application/gatcha.jsp">もう一度引く</a>
</body>
</html>