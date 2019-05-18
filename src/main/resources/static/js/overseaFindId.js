function maxLengthCheck(object){
   if (object.value.length > object.maxLength){
    object.value = object.value.slice(0, object.maxLength);
   }   
}
function findid(){
	var name = document.form.name.value;
	 if(name.length==0 || name==null){
	  return false;
	 }	 
	 var num_regx = /^[0-9]*$/;
	 var ph2 = document.form.ph2.value;
	 if(ph2.length==0 || ph2==null){
	  return false;
	 }
	 var ph3 = document.form.ph3.value;
	 if(ph3.length==0 || ph3==null){
	  return false;
	 }
	 if (!num_regx.test(ph2) || !num_regx.test(ph3)){
	  alert("핸드폰번호는 숫자만 입력가능합니다");
	  return false;
	 }
	 document.form.submit();
	}