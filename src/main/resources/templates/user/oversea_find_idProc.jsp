<%@page import="oversea_member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="member" class="oversea_member.MemberDataBean"/>
<jsp:setProperty property="*" name="member"/>
<%
	String id = null;
	MemberDBBean dbpro = MemberDBBean.getInstance();
 	id = dbpro.findid(member);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<center><br><br><br><br><br>
	<%if(id==null){ %>
	존재하지 않은 계정입니다.
	<br><br><br>
	<script type="text/javascript">
	alert("존재하지 않은 회원입니다.");
	history.go(-1);
	</script>
	<button onclick="window.close()">확인</button>
	</center>
	<!-- 아이디가 이미 존재할때 이미지 -->
	<%}else{ %>
	<center><br><br><br><br><br>
	<script type="text/javascript">
	alert("찾으시는 계정은 <%=id%>입니다.");
	location.href="../oversea_loginform.jsp";
	</script>
	<br><br><br>
	<button onClick="window.close()">확인</button>
	</center>
	<!-- 아이디가 존재하지 않을 때 이미지 -->
	<%} %>
</body>
</html>
