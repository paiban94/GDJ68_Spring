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
	
	<h1 >Add Page</h1>
	
	<form action="./add" method="post">
		상품명<input type="text" name="bookName"><br>
		이자율<input type="text" name="bookRate"><br>
		내용 <textarea rows="" cols="" name="bookContents">${dto.bookContents}</textarea>
		<!-- <textarea rows="" cols="" name="bookContents"></textarea> -->
		
		<p>
			판매가능 <input type="radio" value="1" checked name="bookSale"><br>
			판매중지 <input type="radio" value="0" name="bookSale"><br>
		</p>
		
		<p>
<!-- 			<select name="bookSale">
				<option value="1">판매가능</option>
				<option value="0" selected>판매중지</option>
			</select> -->	
		</p>
		
		<button class="btn btn-primary" type="submit">등록</button>

	</form>
	
</body>
</html>