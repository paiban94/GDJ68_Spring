<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
	<h1>Detail Page</h1>
	
	<%-- ${} --%>
	<!-- Getter 이름 : 메서드에서 get을 제외하고 첫번째글자를 소문자로 바꾼것 -->
	<h1>${requestScope.dto.bookName}</h1>
	
	<div>
		${dto.bookContents}
	</div>
	
	<h1>${dto.bookRate} </h1>
	
	<c:choose>
		<c:when test="${dto.bookSale eq 1}">
			<h1>판매중</h1>
		</c:when>
		<c:otherwise>
			<h1>판매종료</h1>
		</c:otherwise>
	</c:choose>
	
	<c:forEach items="${dto.fileDTOs}" var="f">
		<img alt="" src="/resources/upload/bankbook/${f.fileName}">
	</c:forEach>
	
	<a href="./update?bookNum=${dto.bookNum}">수정</a>
	<a href="./delete?bookNum=${dto.bookNum}">삭제</a>
	<button id="update">수정</button>
	<button id="del" data-delete-name="bookNum" data-delete-num="${dto.bookNum}">삭제</button>
	<a class="btn btn-primary" href="../bookAccount/add?bookNum=${dto.bookNum}">상품가입</a>
	<button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#accountModal">상품가입</button>

	<!-- 댓글 -->
	<div>
		<div class="mb-3">
			<textarea name="accountPassword" class="form-control" id="comment"></textarea>
			<button id="commentAdd">댓글등록</button>
		</div>

		<div>
			<table id="commentList">
				
			</table>

			<div id="more">
				
			</div>

		</div>


	</div>



	<!-- Modal -->
	<div class="modal fade" id="accountModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h1 class="modal-title fs-5" id="exampleModalLabel">비밀번호 입력</h1>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div class="mb-3">
					<input type="password" name="accountPassword" class="form-control" id="pw" placeholder="PW를 입력하세요">
				  </div>
			</div>
			<div class="modal-footer">
			<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="close">Close</button>
			<button type="button" class="btn btn-primary" id="add"; data-add-num="${dto.bookNum}">상품가입</button>
			</div>
		</div>
		</div>
  </div>


<%-- 	
	<c:if test="${dto.bookSale eq 1}">
		<h1>판매중</h1>
	</c:if>
	<c:if test="${dto.bookSale eq 0}">
		<h1>판매종료</h1>
	</c:if>
--%>

	<script src="../resources/js/delete.js"></script>
	<!-- <script>
		setBookNum(${dto.bookNum});
	</script> -->
	
	<script type="text/javascript">
		let bn=$("#add").attr("data-add-num");
		let pageNum=1;
		let tp=0;


		$("#commentAdd").click(function(){
			let contents =$("#comment").val();
			$.ajax({
				type:'POST',
				url:'commentAdd',
				data:{
					bookNum:bn,
					commentContents:contents
				},
				success:function(result){
					if(result.trim()>0){
						alert('댓글등록 OK');
						$("#commentList").empty();
						$("#comment").val("");
						pageNum=1;
						getCommentList(bn, 1);
					}

				}
			});



		});

		$("#more").on("click","#moreButton" ,function(){
			
			if(pageNum>=tp){
				alert('마지막 페이지');
				return;
			}

			pageNum++;
			getCommentList(bn, pageNum);
		})

		getCommentList(bn, pageNum);

		function getCommentList(bookNum, page){
			$.ajax({
				type:"get",
				url: "./commentList",
				data:{
					bookNum:bookNum,
					page:page
				},
				success:function(result){
					$("#commentList").append(result);
					tp=$("#totalPage").attr("data-totalPage");
					let button = '<button id="moreButton">더보기('+pageNum+'/'+tp+')</button>'
					console.log(result)
					$("#more").html(button);
				},
				error:function(){
					alert("관리자에게 문의")
				}
			});
		}



		// const add = document.getElementById("add");

		// add.addEventListener("click", function(){
		// 	let bookNum=add.getAttribute("data-add-num");
		// 	let pw = document.getElementById("pw").value;
		// 	//ajax1(bookNum, pw);
		// 	ajax2(bookNum,pw);

		// });
		
		$("#add").click(function(){
			let bookNum=$("#add").attr("data-add-num");
			let pw=$("#pw").val();
			ajax3(bookNum, pw);
		});

		function ajax3(bookNum, pw){
			$.ajax({
				type:"get",
				url:"../bookAccount/add",
				data:{
					bookNum:bookNum,
					accountPassword:pw
				},
				success:function(response){
					if(response.trim()>0){
						alert("가입 성공");
					}else {
						alert("가입 실패");
					}
				},
				error:function(){
					alert("관리자에게 문의")
				}
			})

		}

/*
		function ajax2(bookNum, pw){
			fetch("../bookAccount/add", {
				method:"post",
				body:"bookNum="+bookNum+"&accountPassword="+pw,
				headers:{
					"content-type":"application/x-www-form-urlencoded"
				}
			})
			.then((response)=>{
				return response.text();
			})
			.then((r)=>{
				if(r>0){
					alert("가입 완료");
				}else {
					alert("가입 실패");
				}

				location.href="../"
			})
			;
		}

		function ajax1(bookNum, pw){
			
			//1. 
			let xhttp = new XMLHttpRequest();

			//2. 요청 정보
			xhttp.open("post", "../bookAccount/add");

			//요청 header 정보
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

			//요청 발생(post일 경우 파라미터 작성 key=값&key2=값2)
			xhttp.send("bookNum="+bookNum+"&accountPassword="+pw);

			//응답 처리
			xhttp.onreadystatechange=function(){
				if(this.readyState==4&&this.status==200){
					let r = this.responseText.trim();
					document.getElementById("close").click();
					console.log(r);
					if(r>0){
						alert("가입 성공");
					}else {
						alert("가입 실패");
					}


					location.href="../";
				}
			}
		}
	*/
	</script>

</body>
</html>