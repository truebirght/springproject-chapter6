<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>list</title>
	</head> 
	<body>
	<c:forEach var="item" items="${list}" >
	    아이디 : ${item.MId}
	    비번 : ${item.MPw}
	    이메일 : ${item.MEmail}
	    <br />
	</c:forEach>
	</body>
</html>
