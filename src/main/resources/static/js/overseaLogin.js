function loginchk(form){
	 if (form.email.value == "Email") {
	  alert("이메일을 입력해 주세요.");
	  form.email.focus();
	  return false;
	 }
	 if (form.passwd.value == "Password") {
	  alert("비밀번호를 입력해 주세요.");
	  form.passwd.focus();
	  return false;
	 }
	 form.action = "user/oversea_loginProc.jsp";
	 form.submit();
}
