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
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
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
		
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
				<c:if test="${pager.pre}">
			    <li class="page-item">
			      <a class="page-link" href="./list?page=${pager.startNum-1}&kind=${param.search}&search=${param.search}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    </c:if>
			    <c:forEach begin ="${pager.startNum}" end="${pager.lastNum}" var="i">
			    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${param.search}&search=${param.search}">${i}</a></li>
			    </c:forEach>
			    <c:if test="${pager.next}">
			    <li class="page-item">
			      <a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${param.search}&search=${param.search}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			    </c:if>
			  </ul>
			</nav>
			
		<div class="input-group mb-3">
		 	<form action="./list" method="get">
			 	<select name="kind"  class="form-select" aria-label="Default select example">
			  	<option value="name">Name</option> <!-- 파라미터이름 kind로 선언 -->
			  	<option value="contents">Contents</option>
				</select>
			 	 <input type="text" name="search" class="form-control" aria-label="Amount (to the nearest dollar)">
			  		<div class="col-auto">
			    		<button type="submit" class="btn btn-primary ">검색</button>
				  </div>
			</form>
		</div>
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