<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<%@page import="java.sql.*"%>
<%@page import="net.members.db.MembersBean"%>
<%
 
 String info_userId=request.getParameter("USERID");

MembersBean info = (MembersBean) request.getAttribute("userInfo");

 
 ResultSet rs = null;
 rs.next();

  

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>확인</title>
</head>
<body> 

<table width=750 border="1" align=center>
<tr>
<th colspan="2" bgcolor="red" >회원 기본 정보</th>
</tr>
<tr>
<td>ID</td>
<td><%--<%=rs.getString("USERID") --%></td>
<td>${rs.USERID}</td>
</tr>
<tr>
<td>메일</td>
<td><%--<%=rs.getString("MAIL") --%></td>
<td>${rs.MAIL}
</tr>
<tr>
<th colspan="2" bgcolor="red" >개인 정보</th>
</tr>
<tr>
<td>이름</td>
<td><%--<%=rs.getString("USERNAME") --%></td>
<td>${rs.USERNAME}
</tr>
<tr>
<td>생년월일</td>
<td><%--<%=rs.getString("IDENT") --%></td>
<td>${rs.IDENT}
</tr>
<tr>
<td>자기소개</td>
<td><%--<%=rs.getString("introduceMyself") --%></td>
<td>${rs.INTRODUCEMYSELF}
</tr>
</tr>
<tr aligh=center>
<td colpan=2>
<a href="MemberListAction.do">목록</a>
</td>
</tr>
</table>
</body>
</html>