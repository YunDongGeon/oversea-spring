<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oversea 회원정보 수정</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link	href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean"	rel="stylesheet">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans:400,300'>
<link rel="stylesheet" href="../assets/css/oversea_check_user.css">
<script>
	function pwChk(form){
		if(form.passwd.value=="Password"){
			  alert("비밀번호를 입력해주세요.");
			  return false;
		}
		form.action = "oversea_check_userPro.jsp";
		form.submit();
	}
</script>
</head>
<body>
<jsp:include page="../user/oversea_after_login_nav.jsp" flush="false" />	
	<div id="login">
		<h2>비밀번호를 입력해주세요.</h2>
         <br>
         <form method="post" action="oversea_check_userPro.jsp">
            <fieldset>
               <p><input type="password" value="Password" name="passwd"
                     onBlur="if(this.value=='')this.value='Password'"
                        onFocus="if(this.value=='Password')this.value='' " required></p>
               <p><input type="button" value="Login" onclick="pwChk(this.form)"></p>           
            </fieldset>         
         </form>
	</div>
</body>
</html>
