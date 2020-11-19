$(frm).submit(function(e){
			e.preventDefault();
			if ($(frm.name).val() == "") {
				alert("이름 입력");
				$(frm.name).focus();
			}else if ($(frm.tel).val() == "") {
				alert("전화번호 입력");
				$(frm.tel).focus();
			}else if ($(frm.addr).val() == "") {
				alert("주소 입력");
				$(frm.addr).focus();
			}else {
				if(!confirm("저장?")) return;
				frm.submit();
			}
		});