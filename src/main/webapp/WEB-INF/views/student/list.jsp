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
		<h1 class="mb-4 text-center">학생 목록</h1>
		<table class="table table-dark table-hover">
		<thead>
			<th>번호</th>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>

					
		<tbody>
			<c:forEach items="${list}" var="d" varStatus="i">
						<tr>
								<td>${d.studentNum} </td>
								<td>${d.studentName} </td>
								<td>${d.studentKor} </td>
								<td>${d.studentEng} </td>
								<td>${d.studentMath} </td>													
						</tr>
			</c:forEach>
			</tbody>
		
			</table>
		
			<a class="btn btn-danger" href="./add">학생등록</a>
		<!-- <a  class="btn btn-danger" "./add.do">상품등록</a> -->
	
	</section>
		
		
		<table class="table table-dark table-hover">