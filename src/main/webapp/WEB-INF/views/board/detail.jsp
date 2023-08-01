
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

			<h1 class="mb-3">${board}상세 페이지</h1>
			
			<h1>${dto.subject}</h1>
		
			<h1>${dto.name}</h1>
			<h1>${dto.createDate}</h1>
			<h1>${dto.hit}</h1>
			<h1>${dto.contents}</h1>
			
			<form>
			
	<%-- 		<div>
			<c:forEach items="${dto.dtos}" var="f">
			<img src="../resources/upload/${board}/${f.fileName}">
			</c:forEach>
			</div>
		 --%>
			
			<c:if test="${board ne 'notice'}">
			<a href="./reply?num=${dto.num}">답변</a>
			</c:if>
			<a href="./update?num=${dto.num}">수정</a>
			<a href="./delete?num=${dto.num}">삭제</a>
			
			</form>
	</section>

</body>
</html>