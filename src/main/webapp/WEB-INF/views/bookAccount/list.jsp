<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    



	<section class="container mt-5">
		<h1 class="mb-3 text-center">상품 가입 목록</h1>
		
		<table class="table table-success table-sm">
		<!-- Latest compiled and minified CSS -->
			<thead>
				<th>계좌번호</th><th>잔액</th><th>DATE</th>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="d" varStatus="i"> 
					<tr>
						<td>${d.account}</td>
						<td>${d.accountBalance}</td>
						<td>${d.accountDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			  	<c:if test="${pager.pre}">
				    <li class="page-item">
				      <a class="page-link move" href="#" data-num="${pager.startNum-1}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
			    </c:if>
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    	<li class="page-item"><a class="page-link move" href="#" data-num="${i}">${i}</a></li>
			    </c:forEach>
			    <c:if test="${pager.next}">
				    <li class="page-item">
				      <a class="page-link move" href="#" data-num="${pager.lastNum+1}" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
			    </c:if>
			  </ul>
			</nav>
	</section>