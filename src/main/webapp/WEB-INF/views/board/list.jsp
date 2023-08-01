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
		<h1 class="mb-3 text-center" >${board} List</h1>
		
		<table class="table table-warning table-sm">
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">	
			<thead>
				<th>NO</th><th>SUBJECT</th><th>NAME</th><th>DATE</th><th>HIT</th>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="d" varStatus="i"> 
					<tr>
						<td><a href="./detail?num=${d.num}">${d.num}</a></td>
						<td><c:catch>
						<c:forEach begin="1" end="${d.depth}">--</c:forEach>
						</c:catch>
						${d.subject}</td>
						<td>${d.name}</td>
						<td>${d.createDate}</td>
						<td>${d.hit}</td>  
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			      <a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <c:forEach begin ="${pager.startNum}" end="${pager.lastNum}" var="i">
			    <li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
			    </c:forEach>
			    <li class="page-item">
			      <a class="page-link" href="./list?page=${pager.lastNum+1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
			
			<div class="input-group mb-3">
	 	<form action="./list" method="get">
		 	<select name="kind"  class="form-select" aria-label="Default select example">
		  	<option value="name">Name</option> <!-- 파라미터이름 kind로 선언 -->
		  	<option value="contents">Contents</option>
			<option value="subject">Subject</option>
			</select>
		 	 <input type="text" name="search" class="form-control" aria-label="Amount (to the nearest dollar)">
		  		<div class="col-auto">
		    		<button type="submit" class="btn btn-danger ">검색</button>
			  </div>
		</form>
	</div>
			
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