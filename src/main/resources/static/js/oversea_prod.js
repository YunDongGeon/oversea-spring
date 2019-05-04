function checkForm(writeform){

	if(!writeform.prod_kind.value){
	  alert("상품의 분류를 선택하십시오");
	  writeform.prod_kind.focus();
	  return false;
	}
	if(!writeform.prod_title.value){
	  alert("상품명을 입력하십시오");
	  writeform.prod_title.focus();
	  return false;
	}
	
	if(!writeform.prod_price.value){
	  alert("상품의 가격을 입력하십시오");
	  writeform.prod_price.focus();
	  return false;
	}
        
	if(!writeform.prod_count.value){
	  alert("상품의 수량을 입력하십시오");
	  writeform.prod_count.focus();
	  return false;
	}
	
	if(!writeform.prod_com.value){
	  alert("업체명을 입력하십시오");
	  writeform.prod_com.focus();
	  return false;
	}
	
	if(!writeform.prod_content.value){
	  alert("상품의 설명을 입력하십시오");
	  writeform.prod_content.focus();
	  return false;
	}
		
	writeform.action = "oversea_prodRegisterPro.jsp";
    writeform.submit();
	
 } 
 
 function updateCheckForm(writeform){

	if(!writeform.prod_kind.value){
	  alert("상품의 분류를 선택하십시오");
	  writeform.prod_kind.focus();
	  return false;
	}
	if(!writeform.prod_title.value){
	  alert("상품의 제목을 입력하십시오");
	  writeform.prod_title.focus();
	  return false;
	}
	
	if(!writeform.prod_price.value){
	  alert("상품의 가격을 입력하십시오");
	  writeform.prod_price.focus();
	  return false;
	}
        
	if(!writeform.prod_count.value){
	  alert("책의 수량을 입력하십시오");
	  writeform.prod_count.focus();
	  return false;
	}

	if(!writeform.prod_com.value){
	  alert("업체명을 입력하십시오");
	  writeform.prod_com.focus();
	  return false;
	}
	
	if(!writeform.prod_content.value){
	  alert("상품의 설명을 입력하십시오");
	  writeform.prod_content.focus();
	  return false;
	}
		
	writeform.action = "oversea_prodUpdatePro.jsp";
    writeform.submit();
	
 } 
 