<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>

	<c:if test="${empty member}">
		<script type="text/javascript">
		alert("로그인 하세요');
		location.href="../member/login";
		</script>
	
	</c:if>
	

	<c:import url="../temp/bootStrap.jsp"></c:import>
	
	  <!-- include summernote css/js-->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
	


</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<div class="container-fluid">
	
		<div class="row justify-content-center my-4">
			<h1 class="col-md-7 text-center">${board} Add Page</h1>
		</div>
		
		<div class="row justify-content-center my-4">
			<form class="col-md-7" action="./add" method="post" id="frm" enctype="multipart/form-data">
				<div class="mb-3">
				  <label for="writer" class="form-label">작성자</label>
				  <input type="text" name="name" readonly value="${member.id}" class="form-control" id="name">
				</div>
				
				<div class="mb-3">
				  <label for="title" class="form-label">제목</label>
				  <input type="text" name="subject" class="form-control" id="subject" placeholder="제목 입력">
				</div>
		
				<div class="mb-3">
				  <label for="contents" class="form-label">내용</label>
				  <textarea name="contents" class="form-control" id="contents" placeholder="내용 입력" rows="7"></textarea>
				</div>
				
				<div id="fileList" class="my-5">
					<div class="input-group mb-3">
						<input type="file" class="form-control" id="photos" name="photos">
					</div>
					<div class="input-group mb-3">
						<input type="file" class="form-control" id="photos" name="photos">
					</div>					
					<div class="input-group mb-3">
						<input type="file" class="form-control" id="photos" name="photos">
					</div>
					<div class="input-group mb-3">
						<input type="file" class="form-control" id="photos" name="photos">
					</div>
					<div class="input-group mb-3">
						<input type="file" class="form-control" id="photos" name="photos">
					</div>					
	
				</div>
							
				<div class="mb-3">
					<button class="my btn btn-danger" type="button" id="btn">글쓰기</button>
				</div>
			
			</form>
		</div>
	</div>
	 	
		<script>
			const btn = document.getElementById("btn")
			const subject = document.getElementById("subject")
			const frm = document.getElementById("frm")
			
			$("#contents").summernote({  
				height: 300,
				callbacks:{
					  onImageUpload: function(files) {
					   	  alert('이미지업로드');
						  //이미지를 SERVER로 전송하고
						  //응답으로 이미지경로와 파일명을 받아서
						  //IMG 태그를 만들어서 SRC속성에 이미지경로를 넣는것
							let formData = new FormData();//<form></form>
							formData.append("files", files[0]);// <input type="file" name="files">
						
						  $.ajax({
							type:'post',
							url:'setContentsImg',
							data:formData,
							enctype:'multipart/form-data',
							cache:false,
							contentType:false,
							processData:false,
							success:function(result){
								$("#contents").summernote('insertImage', result.trim());
							},
							error:function(){
								console.log('error')
							}

						});
						},
						onMediaDelete:function(files){
						let path = $(files[0]).attr("src");// /resources/upload/notice/파일명

							$.ajax({
								type:'post',
								url:'./setContentsImgDelete',
								data:{
									path:path
								},
								success:function(result){
									console.log(result)
								}, error:function(){
									console.log('error')
								}

							})
						}
					}
				});
		

			btn.addEventListener("click", function(){
				console.log(subject.value=="");
				console.log(subject.value.length==0)
				if(subject.value==""){
					alert('제목을 입력 해 주세요.')
					subject.focus();
				}else {
					frm.submit();
				}			
			})

		</script>

	 
</body>
</html>