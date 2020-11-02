<%@ page import = "jumin.vo.JuminVO" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이름으로 검색 결과</title>
</head>
<body>
<jsp:include page="/Header.jsp" />
<c:forEach var="name" items="${names }">
	${name.no },
	<a href="update?no=${name.no }">${name.name }</a>,
	${name.id },
	${name.addr },
	${name.phone },
	${name.siblings },
	${name.lastname },
	${name.age }세 <br>
	<a href="list">[메인으로]</a><br>
	
</c:forEach>
<jsp:include page="/Tail.jsp" />
</body>
</html>