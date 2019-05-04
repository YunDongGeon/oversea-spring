<%@page import="oversea_member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int rst = 0;
	
	MemberDBBean dao = MemberDBBean.getInstance();
	request.setCharacterEncoding("UTF-8");
	String email = session.getAttribute("loginEmail").toString();
	String passwd = (String)request.getParameter("passwd");
	rst = dao.loginCheck(email, passwd);

 	if(rst == 2){
 		response.sendRedirect("oversea_member_edit.jsp");
	}else if(rst == 1){ %>
<script type="text/javascript">
alert("비밀번호가 틀렸습니다");
history.go(-1);
</script>
<%  }else{ %>
<script type="text/javascript">
alert("비밀번호가 틀렸습니다");
history.go(-1); 
</script>
<%  } %>    
