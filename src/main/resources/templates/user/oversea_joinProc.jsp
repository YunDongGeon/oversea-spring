<%@page import="oversea_member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="member" class="oversea_member.MemberDataBean"/>
<jsp:setProperty property="*" name="member"/>

<%
	int rst = 0;
	MemberDBBean dbpro = MemberDBBean.getInstance();
	rst = dbpro.insertoversea_member(member);
	if(rst>0){
%>
<script type="text/javascript">
alert("환영합니다.");
location.href="../oversea_loginform.jsp";
</script>
<%}else{ %>
<script type="text/javascript">
alert("회원가입에 실패하였습니다.");
history.go(-1);
</script>
<%} %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>