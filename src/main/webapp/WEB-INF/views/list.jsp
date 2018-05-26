<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" />
<html>
<head>
<meta charset="utf-8">
<title><c:out value="${user}"/>목록</title>
</head>
<body>
	<a href="add">추가하기</a>
	<table>
		<tr>
			<th>제목</th>
			<th>아티스트</th>
			<th>업로드일자</th>
			<th>조회수</th>
			<th>좋아요</th>
			<th>싫어요</th>
			<th>미리보기</th>
			<th>썸네일</th>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.title}</td>
				<td>${item.artist}</td>
				<td>${item.uploadDttm}</td>
				<td>${item.views}</td>
				<td>${item.likes}</td>
				<td>${item.unlikes}</td>
				<td>${item.url}</td>
				<td><img src="${item.thumbnailPath}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
