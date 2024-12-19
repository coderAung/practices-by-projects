<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<app:layout title="Post">
<script type="text/javascript" src="${root}/statics/js/delete-post.js"></script>
	<c:choose>
		<c:when test="${empty post}">
			<c:if test="${not empty alert}">
				<div class="alert alert-danger alert-dismissible" role="alert">
					Post is deleted
					<span class="text-danger fs-5 float-end pointer" data-bs-dismiss="alert"><i class="bi bi-x-square"></i> </span>
				</div>
				<c:remove var="alert" scope="session"/>
			</c:if>
			<div class="container alert alert-primary text-center">
				Post is not available!
			</div>
		</c:when>
		<c:otherwise>
			<app:post className="mb-3" postId="${post.id}"
				userId="${post.user.id}" postAt="${post.postAt}"
				user="${post.user.name}" categoryId="${post.category.id}"
				category="${post.category.name}" title="${post.title}"
				detail="true"
				profile="${empty post.user.profileImage ? 'profile-photo.png' : post.user.profileImage}">
				<p>${post.content}</p>
			</app:post>
			<div class="container">
				<jsp:include page="/components/comments.jsp"></jsp:include>
			</div>
		</c:otherwise>
	</c:choose>
</app:layout>
