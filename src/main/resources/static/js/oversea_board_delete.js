function del_ok(url) {
		var result = confirm("게시글을 삭제하시겠습니까?");
		
		if (result) {
			document.contForm.action=url;
			document.contForm.method="get";
			document.contForm.submit();
		} else {
			return;
		}
	}