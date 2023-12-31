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
		<h1 class="mb-4 text-center">상품 목록</h1>
	
		
		<table class="table table-warning table-hover">
		<thead>
			<th>상품명</th><th>이자율</th>
		</thead>		
			<tbody>
			<c:forEach items="${list}" var="d" varStatus="i">
				<tr>
					<td><a href="./detail?bookNum=${d.bookNum}">${d.bookName}</a></td>
					<td>${d.bookRate} ${i.index}</td>
				</tr>
			</c:forEach>
			</tbody>
		
		</table>
		
		<a class="btn btn-danger" href="./add">상품등록</a>
		<!-- <a  class="btn btn-danger" "./add.do">상품등록</a> -->
	
	</section>
		
	
	
<!-- 
	<c:forEach begin="1" end="10" step="2" var="num">
	<h1>${num}</h1>
	</c:forEach>
 -->
 
</body>
</html>