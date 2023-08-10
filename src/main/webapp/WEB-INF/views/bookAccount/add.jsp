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
	<h1 class="my-4">상품가입 Page</h1>
	
	<form action="./add" method="post" id="frm">
	
	<input type="hidden" name="bookNum" value="${dto.bookNum}">
		
	<div class="mb-3">
	  <label for="pw" class="form-label">PASSWORD</label>
	  <input type="password" name="accountPassword" class="form-control" id="pw" placeholder="PW를 입력하세요">
	</div>
	
	<div class="mb-3">
		<button type="button" id="btn" class="btn btn-primary">가입</button>
	</div>
	
	</form>
	

	
	
</section>
<script type="text/javascript">
	const btn = document.getElementById("btn");
	const pw = document.getElementById("pw");
	const frm = document.getElementById("frm");
	btn.addEventListener("click", function () {
		if(pw.value.length==4 && Number.isInteger(pw.value*1)){
			frm.submit();
		}else {
			alert("비번 4글자 또는 숫자로만 작성");
		}
	})
</script>

</body>
</html>