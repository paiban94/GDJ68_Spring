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
	<h1 class="mb-3 text-center">Update Page</h1>
	
	<form action="./update" method="post">
		<div class="mb-3">
		<input type="hidden" name="noticeNo" value="${dto.noticeNo}">
		  <label for="noticeSubject" class="form-label">제목</label>
		  <input type="text" name="noticeSubject" " id="noticeSubject" value="${dto.noticeSubject}">
		</div>
		<div class="mb-3">
		  <label for="noticeName" class="form-label">작성자</label>
		  <input type="text" name="noticeName" id="noticeName" value="${dto.noticeName}">
		</div>
	
		
		<div class="mb-3">
  			<label for="noticeContents" class="form-label">내용</label>
  			<textarea class="form-control" name="noticeContents" id="noticeContents" rows="3">${dto.noticeContents}</textarea>
		</div>

		
		
	<!-- 	<p>
			판매가능 <input type="radio" value="1" checked name="bookSale"><br>
			판매중지 <input type="radio" value="0" name="bookSale"><br>
		</p>  -->
		

		
		<button type="submit">수정</button>
			</form>
	
		</section>
		
	
	
</body>
</html>