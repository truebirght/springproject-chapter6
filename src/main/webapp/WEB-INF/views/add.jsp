<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<style type="text/css">
.error{
	color: red;
}
</style>
<meta charset="utf-8">
<title>추가</title>
</head>
<body>
	<form:form method="POST" action="add" modelAttribute="music">
	<table>
		<tr>
			<td><form:label path="title" cssErrorClass="error">제목</form:label></td>
			<td><form:input path="title" cssErrorClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="artist" cssErrorClass="error">아티스트</form:label></td>
			<td>
				<form:input path="artist" cssErrorClass="error"/>
				<form:errors path="artist" cssClass="error" />
			</td>
		</tr>
		<tr>
			<td><form:label path="url" cssErrorClass="error" >미리보기 URL</form:label></td>
			<td><form:input path="url" cssErrorClass="error"/></td>
		</tr>
		<tr>
			<td><form:label path="title">썸네일</form:label></td>
			<td><form:input path="thumbnail"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="저장"></td>
		</tr>
	</table>
	</form:form>
</body>
</html>