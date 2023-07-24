
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
	<h1>Student Detail Page</h1>
	
	
	<%-- ${} --%>
	<!-- Getter 이름 : 메서드에서 get을 제외하고 첫번째글자를 소문자로 바꾼것 -->
	
	
	<div>
		${dto.studentNum}
	</div>
	
	<div>
		${dto.studentName}
	</div>
	
	<h1>${dto.studentKor} </h1>
	<h1>${dto.studentEng} </h1>
	<h1>${dto.studentMath} </h1>
	

</body>
</html>