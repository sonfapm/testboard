<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%
	int num=Integer.parseInt(request.getParameter("num"));
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>MVC �Խ���</title>
</head>
<body>
<form name="deleteForm" action="./BoardDeleteAction.bo?num=${num }" 
	method="post">
<table border=1>
<tr>
	<td>
		<font size=2>�� ��й�ȣ : </font>
	</td>
	<td>
		<input name="BOARD_PASS" type="password">
	</td>
</tr>
<tr>
	<td colspan=2 align=center>
		<a href="javascript:deleteForm.submit()">����</a>
		&nbsp;&nbsp;
		<a href="ProductList.product">���ư���</a>
	</td>
</tr>
</table>
</form>
</body>
</html>