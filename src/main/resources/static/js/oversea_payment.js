function maxLengthCheck(object){
   if (object.value.length > object.maxLength){
    object.value = object.value.slice(0, object.maxLength);
   }   
}

function check(form){
	if(form.card_com.value=="100"){
		  alert("카드사를 선택하세요.");
		  return false;
	}
	if(form.cardnum1.value.length<4){
		  alert("카드 번호를 확인하세요.");
		  form.cardnum1.focus();
		  return false;
	}
	if(form.cardnum2.value.length<4){
		  alert("카드 번호를 확인하세요.");
		  form.cardnum2.focus();
		  return false;
	}
	if(form.cardnum3.value.length<4){
		  alert("카드 번호를 확인하세요.");
		  form.cardnum3.focus();
		  return false;
	}
	if(form.cardnum4.value.length<4){
		  alert("카드 번호를 확인하세요.");
		  form.cardnum4.focus();
		  return false;
	}
	if(form.cardyear.value<2018){
		  alert("카드 유효기간을 확인하세요.");
		  form.cardyear.focus();
		  return false;
	}
	if(form.cardmonth.value<1 || form.cardmonth.value>12){
		  alert("카드 유효기간을 확인하세요.");
		  form.cardmonth.focus();
		  return false;
	}
	if(!form.cardpass.value || form.cardpass.value<10){
		  alert("카드 비밀번호를 확인하세요.");
		  form.cardmonth.focus();
		  return false;
	}
	
	setTimeout(function(){
		alert("결제가 완료되었습니다.");
		form.action = "oversea_buyPro.jsp";
		form.submit();
	    window.close();
	}, 2000);
	
}
function checkAccount(form){
	if(form.payment.value=="100"){
		  alert("입금계좌를 선택하세요.");
		  return false;
	}
	
	alert("결제가 완료되었습니다.");
	form.action = "oversea_buyPro.jsp";
	form.submit();
    window.close();
}
function checkPhone(form){
	var pop_title = "Payment";
	var pop_option= "width=500, height=470, scrollbars=no, status=no";
	if(form.phone_name.value==""){
		  alert("이름을 입력하세요.");
		  return false;
	}
	if(form.phonenum2.value<999){
		  alert("휴대폰번호를 확인하세요.");
		  return false;
	}
	if(form.phonenum3.value<999){
		  alert("휴대폰번호를 확인하세요");
		  return false;
	}
	alert("인증번호가 발송되었습니다.");
	window.name = "oversea_pay_phone.jsp"
	window.open("", pop_title, pop_option);
	form.target = pop_title;
	form.action = "oversea_pay_phonecert.jsp";
	form.submit();
	window.close();
}
function checkCert(form){
	if(form.cert.value==""){
		  alert("인증번호를 입력하세요.");
		  return false;
	}
	setTimeout(function(){
		alert("결제가 완료되었습니다.");
		form.action = "oversea_buyPro.jsp";
		form.submit();
		window.close();
	}, 2000);
	
}