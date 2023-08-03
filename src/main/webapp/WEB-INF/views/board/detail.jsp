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
	
	<section class="container mt-5">
		<h1 class="mb-3 text-center">Detail Page</h1>
		
		<h1>Subject : ${requestScope.dto.subject}</h1>
		<table class="table table-success table-sm">
				
			<thead>
				<tr>
					<td>번호</td><td>제목</td><td>이름</td><td>날짜</td><td>조회수</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${dto.num}</td>
					<td>${dto.subject}</td>
					<td>${dto.name}</td>
					<td>${dto.createDate}</td>
					<td>${dto.hit}</td>
				</tr>
			</tbody>
		</table>
		<table class="table table-success table-sm">
			<tr>
				<td>내용</td>
			</tr>
			<tr>
				<td>${dto.contents}</td>
			</tr>
		</table>
		
		<div>
			<c:forEach items="${dto.dtos}" var="f">
				<img src="../resources/upload/${board}/${f.fileName}">
			</c:forEach>
		</div>
		
		<form id="frm" action="">
			<input type="hidden" name="num" value="${dto.num}">
		</form>
		<c:if test="${board ne 'notice'}">
		<!-- <a class="btn btn-outline-primary" for="btn-check-outlined" href="./reply?num=${dto.num}">답글</a> -->
		<button id="reply" class="c1" data-url="reply"></button>
		</c:if>
		<!-- <a class="btn btn-outline-primary" for="btn-check-outlined" href="./update?num=${dto.num}">수정</a> -->
		<button id="update" data-url="update" class="c1">수정</button>
		<button id="del" data-url="delete" class="btn btn-outline-primary c1"  for="btn-check-outlined" data-delete-name="num" data-delete-num="${dto.num}">삭제</button>
			
		<script src="../resources/js/delete.js"></script>
	</section>
</body>