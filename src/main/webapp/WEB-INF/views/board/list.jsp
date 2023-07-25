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
		<h1 class="mb-3 text-center" >Notice List</h1>
		
		<table class="table table-warning table-sm">
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
			<thead>
				<th>NO</th><th>SUBJECT</th><th>NAME</th><th>DATE</th><th>HIT</th>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="d" varStatus="i"> 
					<tr>
						<td><a href="./detail?noticeNo=${d.noticeNo}">${d.noticeNo}</a></td>
						<td><a href="./detail?noticeNo=${d.noticeNo}">${d.noticeSubject}</a></td>
						<td>${d.noticeName}</td>
						<td>${d.noticeDate}</td>
						<td>${d.noticeHit}</td>  
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a class="btn btn-outline-warning" for="btn-check-outlined" href="./add">글쓰기</a>
		
		<%-- 
		<c:forEach begin="1" end="10" step="2" var="num">
			<h1>${num}</h1>
		</c:forEach>
		 --%>
	</section>
		
		
	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>