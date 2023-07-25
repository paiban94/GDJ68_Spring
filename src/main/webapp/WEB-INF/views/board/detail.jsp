
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

			<h1 class="mb-3">상세 페이지</h1>
			
			<h1>${dto.noticeSubject}</h1>
		
			<h1>${dto.noticeName}</h1>
			<h1>${dto.noticeDate}</h1>
			<h1>${dto.noticeHit}</h1>
			<h1>${dto.noticeContents}</h1>
			
	
		
			<a href="./update?noticeNo=${dto.noticeNo}">수정</a>
			<a href="./delete?noticeNo=${dto.noticeNo}">삭제</a>

	</section>

</body>
</html>