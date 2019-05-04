<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>;
<%request.setCharacterEncoding("UTF-8"); %>
<%@ page import="oversea_member.MemberDBBean"%>
<jsp:useBean id="member" class="oversea_member.MemberDataBean"/>
<jsp:setProperty property="*" name="member"/>
<%
	int rst = 0;
	String phone = "";
	String ph1 = request.getParameter("ph1");
	String ph2 = request.getParameter("ph2");
	String ph3 = request.getParameter("ph3");
	String zipcode = request.getParameter("zipcode");
	String addr1 = request.getParameter("addr1");
	String addr2 = request.getParameter("addr2");
	String email = session.getAttribute("loginEmail").toString();
	StringBuffer sb = new StringBuffer(ph1);
	sb.append(ph2);
	sb.append(ph3);
	phone = sb.toString();
	MemberDBBean dao = MemberDBBean.getInstance();
	rst = dao.editMember(phone, zipcode, addr1, addr2, email);
	out.print(addr2);
%>


<%if(rst==1){ %>

<script type="text/javascript">
alert("회원정보 수정을 성공했습니다.");
location.href="../oversea_userform.jsp";
</script>


<%}else{ %>

<script type="text/javascript">
alert("회원정보 수정을 실패했습니다.");
history.go(-1);
</script>

<%} %>

