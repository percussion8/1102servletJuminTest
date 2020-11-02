<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주민 등록</title>
</head>
<body>
<jsp:include page="/Header.jsp" />
<h1>주민 등록</h1>
<form action="add" method="post">
이름 : <input type="text" name="name"><br>
주민번호 : <input type="text" name="id"><br>
주소 : <input type="text" name="addr"><br>
전화번호 : <input type="text" name="phone"><br>
형제 수 : <input type="number" name="siblings"><br>
부 이름 : <input type="text" name="family"><br>
<input type="submit" value="추가">
<input type="reset" value="취소">
</form>


<jsp:include page="/Tail.jsp"/>
</body>
</html>