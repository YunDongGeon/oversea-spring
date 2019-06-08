function maxLengthCheck(object){
	if (object.value.length > object.maxLength){
		object.value = object.value.slice(0, object.maxLength);
	}   
}
function regChk(form){
	 var emailRegx =  /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	 var phoneRegx = /^[0-9]*$/;
	 if(form.name.value==""){
	  alert("이름을 입력하십시오");
	  return false;
	 }

	 if(form.email.value==""){
	  alert("이메일을 입력하십시오");
	  return false;
	 }
	 if (!emailRegx.test(form.email.value)){
	  alert("이메일은 형식으로 입력해주세요.");
	  form.email.focus();
	  return false;
	 }

	 var password = form.passwd;
	 var re_password = form.re_passwd;
	 if(password.value=="" || password.length<6){
	  alert("비밀번호를 입력하십시오(6글자이상)");
	  return false;
	 }

	 if(!password.value==re_password.value){
		alert("비밀번호가 다릅니다.");
		return false;
	 }
	 
	 if(form.phone.value==""){
		 alert("핸드폰번호를 입력하십시오");
		 return false;
		 
	 }
	 if(!phoneRegx.test(form.phone.value)){
		 alert("형식에 맞게 입력하십시오");
		 return false;		 
	 }
	 
	 if(form.birth.value==""){
		 alert("생년월일을 입력하십시오.")
		 return false;
	 }
	 
	 if(form.zipcode.value==""){
		 alert("주소를 입력하십시오");
		 return false; 
	 }
	 if(form.addr2.value==""){
		 alert("상세주소를 입력하십시오.");
		 return false;
	 }
	 
	form.action = "overseaJoin";
	form.submit();
}

function emailCheck(form){
	 if(form.email.value==""){
		 alert("중복체크할 이메일을 입력하십시오");
		 return false;
	 }
	 var url = "user/oversea_emailCheck.jsp?email=" + form.email.value;
	 window.open(url, "get", "height = 300, width = 500");
}