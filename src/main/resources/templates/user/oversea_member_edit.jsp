<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="oversea_member.MemberDBBean"%>
<%@ page import="oversea_member.MemberDataBean"%>

<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<title>Oversea 회원정보 수정</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link href="../assets/css/oversea_member_edit.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean"
	rel="stylesheet">
<script>
	function formChk(form) {
		if (form.ph1.value == "") {
			alert('휴대폰번호를 확인해주세요.');
			return false;
		}
		if (form.ph2.value == "") {
			alert('휴대폰번호를 확인해주세요.');
			return false;
		}
		if (form.ph3.value == "") {
			alert('휴대폰번호를 확인해주세요.');
			return false;
		}
		if (form.addr2.value = "") {
			alert('상세주소를 입력해주세요.');
			return false;
		}
		form.action = "oversea_member_editPro.jsp";
		form.submit();
	}
</script>
</head>
<body>
	<jsp:include page="../user/oversea_after_login_nav.jsp" flush="false" />
	<br>
	<%
		request.setCharacterEncoding("UTF-8");
		String loginEmail = (String) session.getAttribute("loginEmail");

		MemberDBBean dao = MemberDBBean.getInstance();
		MemberDataBean member = dao.getMember(loginEmail);
	%>
	<div class="edit_form">
		<h1>회원 정보 수정</h1>
		<br>
		<form action="oversea_member_editPro.jsp" method="post" name="form">
			<div class="namebox">
				<label for="name">Name : </label><br> <input type="text"
					name="user_name" value="<%=member.getName()%>" disabled="disabled">
			</div>
			<br>
			<div class="phonebox">
				<label for="Phone_Number">Phone_Number : </label><br> <input
					type="number" name="ph1" maxlength="3"
					oninput="maxLengthCheck(this)" value="<%=member.getPh1()%>"
					class="ph1" required> <input type="number" name="ph2"
					maxlength="4" oninput="maxLengthCheck(this)"
					value="<%=member.getPh2()%>" class="ph2" required /> <input
					type="number" name="ph3" maxlength="4"
					oninput="maxLengthCheck(this)" value="<%=member.getPh3()%>"
					class="ph3" required />
			</div>
			<br>
			<div class="birthbox">
				<label for="birth">생년월일 : </label><br> <input type="number"
					value="<%=member.getBirth()%>" disabled="disabled">
			</div>
			<br>
			<div class="zipbox">
				<laber for="zipcode">우편번호 : </laber>
				<br> <input value="<%=member.getZipcode()%>" type="text"
					class="zipcode" name="zipcode" size="10" id="sample6_postcode"
					readonly> &nbsp;
				<button type="button" class="btn"
					onclick="sample6_execDaumPostcode()">우편번호 찾기</button>
			</div>
			<br>
			<div class="addressbox">
				<laber for="주소">주소 : </laber>
				<br> 
				<input value="<%=member.getAddr1()%>" type="text"
					name="addr1" size="60" id="sample6_address" readonly /> 
				<br> 
				<input value="<%=member.getAddr2()%>" type="text" name="addr2" size="60"
					id="sample6_address2">
				<div id="wrap"
					style="display: none; border: 1px solid; width: 500px; height: 300px; margin: 5px 0; position: relative">
					<img
						src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png"
						id="btnFoldWrap"
						style="cursor: pointer; position: absolute; right: 0px; top: -1px; z-index: 1"
						onclick="foldDaumPostcode()" alt="접기 버튼">
				</div>
			</div>
			<br> <input type="hidden" name="email"
				value="<%=session.getAttribute("loginEmail")%>">
			<div class="btngroup">
				<button type="button" class="btn btn-success" onclick="formChk(this.form)">완료</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-danger" onclick="location.href='../oversea_userform.jsp'">취소</button>
			</div>
		</form>
		<br>
		<br>
	</div>
</body>
</html>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('sample6_address').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('sample6_address2').focus();
					}
				}).open();
	}
</script>



