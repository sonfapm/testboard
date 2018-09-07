<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name=loginForm method="post"action="MembersLoginAction.do">
<table width=750  align=center>
        <tr>
          <th colspan="2" align=center >로그인</th>
        </tr>
        <tr>
          <td>아이디</td>
          <td><input type="text" name="USERID"> </td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" name="PA"> </td>
        </tr>
        
        </table>
        <p align=center>
        <a href="javascript:loginForm.submit()">로그인</a>
        <a href="MembersJoin.do" >회원가입</a>
      </p>
        

</body>
</html>