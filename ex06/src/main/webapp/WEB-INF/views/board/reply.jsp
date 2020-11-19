<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓글 목록</title>
<style>
	a {text-decoration:pink; color:red;}
	.active{color:pink;}
</style>
</head>
<body>
	<h1>[댓글 목록]</h1>
	<div id="divInsert">
		<input type="text" id="txtReply" size=50>
		<input type="button" id="btnReply" value="등록">
		전체 댓ㄱㄹ 수<span id = "total"></span>
	</div>
	<div id="divReply"></div>
	
	<script id="temp" type="text/x-handlebars-template">
			{{#each list}}
				<div>
					[{{rno}}] {{reply}}
					<span>{{replyer}}</span>
					<span>{{replyDate}}</span>
					<button rno="{{rno}}">삭제</button>
				</div>
			{{/each}}
	</script>
	<div id="pagination">
	
	</div>
</body>
<script>
	var page=1;
	var bno=${vo.bno};
	
	getList();
	
	$("#divReply").on("click", "button", function(){
		var rno = $(this).attr("rno");
		if(!confirm(rno + "을(를) 삭제??")) return;
		$.ajax({
			type:"post",
			url:"/reply/delete",
			data:{"rno":rno},
			success:function(){
				getList();
			}
		});
	});
	
	$("#txtReply").keydown(function(key){
			if(key.keyCode==13){
				var reply=$("#txtReply").val();
				if(reply==""){
					alert("내용입력");
					return;
				}
			if(!confirm("등록하시겠습니까?")) return;
			$.ajax({
				type:"post",
				url:"/reply/insert",
				data:{"bno":bno, "replyer":"user01", "reply":reply},
				success:function(data){
					$("#txtReply").val("");
					getList();
				}
			});
		}
	});
	
	function getList(){
		$.ajax({
			type:"get",
			url:"/reply/list",
			data:{"page":page, "bno":bno},
			dataType:"json",
			success:function(data){
				var temp = Handlebars.compile($("#temp").html());
				$("#divReply").html(temp(data));
				
				$("#total").html(data.pm.totalCount);
				
				//페이지목록
				var str="";
				if(data.pm.prev){
					str += "<a href='" + (data.pm.startPage-1) + "'> ← </a>";
				}
				for(var i=data.pm.startPage; i<data.pm.endPage; i++){
					if(page==i){
						str += "[<a href='" + i + "' class='active'>" + i + "</a>]";
					}else{
						str += "[<a href='" + i + "'>" + i + "</a>]";
					}
					
				}
				if(data.pm.next){
					str += "<a href='" + (data.pm.endPage+1) + "'> → </a>";
				}
				$("#pagination").html(str);
			}
		});
	}
	
	$("#pagination").on("click", "a" , function(e){
		e.preventDefault();
		page=$(this).attr("href");
		getList();
	});
</script>
</html>



