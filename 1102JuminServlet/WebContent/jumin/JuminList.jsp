<%@ page import = "jumin.vo.JuminVO" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주민 목록</title>
</head>
<body>
<jsp:include page ="/Header.jsp" />
<p><a href="add">신규 주민</a></p>
<p><a href="search">주민 검색</a></p>
<c:forEach var="jumin" items="${jumins }">
	${jumin.no },
	<a href="update?no=${jumin.no }">${jumin.name }</a>,
	${jumin.id },
	${jumin.addr },
	${jumin.phone },
	${jumin.siblings },
	${jumin.lastname }
	<a href="delete?no=${jumin.no }">[삭제]</a><br>
</c:forEach>
<jsp:include page="/Tail.jsp" />
</body>
</html>