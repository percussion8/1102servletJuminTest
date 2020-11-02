<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주민 수정</title>
</head>
<body>
<jsp:include page="/Header.jsp" />
<h1>회원 정보</h1>
<form action="update" method="post">
<input type="hidden" name="no" value="${jumin.no }" readonly>
이름 : <input type="text" name="name" value="${jumin.name }"><br>
주민번호 : <input type="text" name="id" value="${jumin.id }"><br>
주소 : <input type="text" name="addr" value="${jumin.addr }"><br>
전화번호 : <input type="text" name="phone" value="${jumin.phone }"><br>
형제 수 : <input type="number" name="siblings" value="${jumin.siblings }"><br>
부 이름 : <input type="text" name="family" value="${jumin.lastname }"><br>
<input type="submit" value="저장">
<input type="button" value="취소" onclick="location.href='list'">

</form>


<jsp:include page="/Tail.jsp" />
</body>
</html>