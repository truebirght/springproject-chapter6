<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>list</title>
</head>
<body>
	<form method="POST" action="loginProcess">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="username" name="username" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="password" name="password" /></td>
			</tr>
		</table>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn btn-primary">로그인</button>
			</div>
		</div>
	</form>
</body>
</html>
