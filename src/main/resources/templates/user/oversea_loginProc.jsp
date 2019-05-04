<%@page import="oversea_member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
	int rst = 0;
	
	MemberDBBean dao = MemberDBBean.getInstance();
	request.setCharacterEncoding("UTF-8");
	String email = (String)request.getParameter("email");
	String passwd = (String)request.getParameter("passwd");
	rst = dao.loginCheck(email, passwd);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oversea 로그인Pro</title>
</head>
<body>
<%
 	if(rst == 2){
 		String getName = dao.getName(email, passwd);
  		session.setAttribute("loginEmail", email);
  		session.setAttribute("loginName", getName);
		session.setMaxInactiveInterval(60*60);
%>
<script type="text/javascript">
location.href="../index.jsp";
</script>

<%  }else if(rst == 1){ %>
<script type="text/javascript">
alert("비밀번호가 틀렸습니다");
history.go(-1);
</script>

<%  }else{ %>
<script type="text/javascript">
alert("존재하지 않는 계정입니다.");
history.go(-1); 
</script>

<%  } %>
</body>
</html>