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
	<section class="container mt-5">
	<h1 class="mb-3 text-center">${board}Reply Page</h1>
	
	<form action="./reply" method="post" enctype="multipartfile">
	<input type="hidden" name="num" value="${num}">
		<div class="mb-3">
		<input type="hidden" name="noticeNo" value="${dto.noticeNo}">
		  <label for="noticeSubject" class="form-label">제목</label>
		  <input type="text" name="subject" class="form-control" id="subject" placeholder="제목">
		</div>
		<div class="mb-3">
		  <label for="noticeName" class="form-label">작성자</label>
		  <input type="text" name="name" class="form-control" id="name" placeholder="작성자">
		</div>
		
		<div class="mb-3">
  			<label for="noticeContents" class="form-label">내용</label>
  			<textarea class="form-control" name="contents" id="contents" rows="3">${dto.noticeContents}</textarea>
		</div>

			<div class="mb-3">
	  		<label for="birth" class="form-label">사진첨부</label>
	  		<input type="file" name="photos" class="form-control" id="pic">
		</div>
			<div class="mb-3">
	  		<label for="birth" class="form-label">사진첨부</label>
	  		<input type="file" name="photos" class="form-control" id="pic">
		</div>
			<div class="mb-3">
	  		<label for="birth" class="form-label">사진첨부</label>
	  		<input type="file" name="photos" class="form-control" id="pic">
		</div>
			<div class="mb-3">
	  		<label for="birth" class="form-label">사진첨부</label>
	  		<input type="file" name="photos" class="form-control" id="pic">
		</div>
			<div class="mb-3">
	  		<label for="birth" class="form-label">사진첨부</label>
	  		<input type="file" name="photos" class="form-control" id="pic">
		
	
		
		<button class="btn btn-primary" type="submit">등록</button>
			</form>
	
		</section>
		
	
	
</body>
</html>