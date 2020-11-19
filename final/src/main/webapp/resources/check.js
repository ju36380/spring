$(frm).submit(function(e) {
		e.preventDefault();
		if ($(frm.name).val().trim().length == 0) {
			alert("이름 입력");
			$(frm.name).focus();
		} else if ($(frm.tel).val().trim().length == 0) {
			alert("전화번호 입력");
			$(frm.tel).focus();
		} else if ($(frm.address).val().trim().length == 0) {
			alert("주소 입력");
			$(frm.address).focus();
		} else {
			if (!confirm("등록?")) {
				return;
			} else {
				alert("등록 완료");
				frm.submit();
			}
		}
});
