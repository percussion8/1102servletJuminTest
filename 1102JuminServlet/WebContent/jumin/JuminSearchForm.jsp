<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주민 조회</title>
</head>
<body>
<jsp:include page="/Header.jsp" />

<form action="search" method="post">
이름으로 검색하기 : <input type="text" name="name"><br>

<input type="submit" value="저장">
<input type="button" value="취소" onclick="location.href='list'">
</form>

<jsp:include page="/Tail.jsp" />
</body>
</html>