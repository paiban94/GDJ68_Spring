<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>

<c:import url="./temp/bootStrap.jsp"></c:import>

</head>
<body>
 	<c:import url="./temp/header.jsp"></c:import>

	<div id="carouselExample" class="carousel slide">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/resources/images/img02.jpg" class="d-block w-70" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/resources/images/img03.jpg" class="d-block w-70" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/resources/images/img01.jpg" class="d-block w-70" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>


	<c:if test="${sessionScope.member ne null}">
		<h1>로그인 상태</h1>
	</c:if>
	<c:if test="${empty member}">
		<h1>비로그인 상태</h1>
	</c:if>
	
	<img alt="" src="/resources/upload/member/img01.jpg">
</body>
</html>