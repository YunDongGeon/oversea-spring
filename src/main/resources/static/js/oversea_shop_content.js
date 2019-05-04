$(document).ready(function(){
	$('#check_btn').click(function(){
	    $('#content').toggle('show');
  	});
});
function openDatepicker() {
	$("#datepicker").datepicker("show");
}
function priceChk(form){
	var count = parseInt(form.prod_count.value);
	var amount = parseInt(form.prod_amount.value);
	var price = parseInt(form.price.value);
	var total = price * amount;
	if(form.subs_date.value==""){
		alert("날짜를 선택하세요.");
		return false;
	}
	if(form.prod_amount.value==""){
		alert("인원 수를 입력해주세요.");
		return false;
	}
	if(amount>count){
		$("#content").empty();
		$("#content").append("상품 재고가 부족합니다.");
	}else{
		$("#content").empty();
		$("#content").append(
			"<hr>" + 
			"<input class='content_left_input' type='text' value='총액' readonly>" +
			"<input class='content_right_input' type='text' value='"+total+"' readonly>" +
			"<input style='width: 150px; margin-top: 45px; margin-left: 15px;' class='reservation_btn' type='submit' value='예약하기'>"
		);
	}
}

function chk_wish_session(loginEmail){
	if(loginEmail==null){
		alert("로그인이 필요한 기능입니다.");
		location.href="../oversea_loginform.jsp";
		return false;
	}
	return true;	
}

$(function() {
    $( "#datepicker" ).datepicker({
    	showMonthAfterYear: true,
    	dateFormat: "yy-mm-dd",
    	dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
        dayNamesMin: [ '일', '월', '화', '수', '목', '금', '토'], 
        monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        minDate: 0
    });
});