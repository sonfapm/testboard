<%@page import="net.members.db.MembersBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%
	List memberList=(List)request.getAttribute("memberList");
%>

<h2>회원목록</h2>
<%--<%
		for(int i=0;i<memberList.size();i++){
			MembersBean mb=(MembersBean)memberList.get(i);
--%>
<c:forEach var="mb" items="memberList" varStatus="status">

<h3>
	<a href="MembersViewAction.do?id=${ mb.USERID()}">"${ =mb.USERID()}"</a> <a
		href="MembersDeleteAction.do?id=${mb.USERID()}">삭제</a>
</h3>
</c:forEach>
<%--<%
		}
--%>
<br>
<a href="./BoardList.bo">[돌아가기]</a>
