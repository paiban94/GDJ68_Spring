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
			      <a class="page-link move" href="#" data-num="${pager.startNum-1}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <c:forEach begin ="${pager.startNum}" end="${pager.lastNum}" var="i">
			    <li class="page-item move"><a class="page-link" href="#" data-num="${i}">${i}</a></li>
			    </c:forEach>
			    <li class="${pager.next}">
			      <a class="page-link move" href="#" data-num="${pager.lastNum-1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
			
			<div class="input-group mb-3">
	 	<form action="./list" method="get" id="frm">
	 		<input type="hidden" value="${pager.page}" name="page">
		
		<select name="kind" id="k" class="form-select" data-kind="${pager.kind}" aria-label="Default select example">
		  	<option class="kind" value="name">Name</option> <!-- 파라미터이름 kind로 선언 -->
		  	<option class="kind" value="contents">Contents</option>
			<option class="kind" value="subject">Subject</option>
		</select>	
		 	 <input type="text" name="search" value="${pager.page}" class="form-control" aria-label="Amount (to the nearest dollar)">
		  		<div class="col-auto">
		    		<button type="submit" class="btn btn-danger ">검색</button>
			  </div>
		</form>
	</div>
		<c:if test="${not empty member}">	
		<a class="btn btn-outline-warning" for="btn-check-outlined" href="./add">글쓰기</a>
		</c:if>
		<%-- 
		<c:forEach begin="1" end="10" step="2" var="num">
			<h1>${num}</h1>
		</c:forEach>
		 --%>
	</section>
		<script src="/resources/js/list.js"></script>

		<script>
			//setData('${pager.kind}');
		</script>
		
	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>