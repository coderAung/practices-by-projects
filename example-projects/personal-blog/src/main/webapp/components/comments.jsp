<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<h5>Comments</h5>

<c:choose>
	<c:when test="${empty post.comments}">
		<div class="border container p-3 mb-2 alert alert-primary text-center">
			There is no comments yet!
		</div>
	</c:when>
	<c:otherwise>
		<c:forEach var="comment" items="${post.comments}">
			<app:comment postId="${post.id}" id="${comment.id}" text="${comment.text}"></app:comment>
		</c:forEach>
	</c:otherwise>
</c:choose>


