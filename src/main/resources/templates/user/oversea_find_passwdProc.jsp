<%@page import="oversea_member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="member" class="oversea_member.MemberDataBean"/>
<jsp:setProperty property="*" name="member"/>
<%
	String pw = null;
	MemberDBBean dbpro = MemberDBBean.getInstance();
 	pw = dbpro.findpw(member);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!-- 회원정보가 없거나 일치 하지 않는 경우 -->
	<center><br><br><br><br><br>
	<%if(pw==null){ %>
	존재하지 않은 계정입니다.
	<br><br><br>
	<script type="text/javascript">
	alert("존재하지 않은 회원입니다.");
	history.go(-1);
	</script>
	<button onclick="window.close()">확인</button>
	</center>
	<!-- 회원정보가 일치하는 경우 -->
	<%}else{ %>
	<center><br><br><br><br><br>
	<script type="text/javascript">
	alert("회원님의 비밀번호는 <%=pw%>입니다.");
	location.href="../oversea_loginform.jsp";
	</script>
	<br><br><br>
	<button onClick="window.close()">확인</button>
	</center>
	<%} %>
</body>
</html>