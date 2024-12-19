<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<script type="text/javascript" src="${root}/statics/js/delete-post.js"></script>
<c:choose>
	<c:when test="${empty list}">
		<div class="container alert alert-primary text-center">There is no posts</div>
	</c:when>
	<c:otherwise>
		<c:forEach var="post" items="${list}">
			<app:post className="mb-3"
				postId="${post.id}"
				userId="${post.user.id}"
				postAt="${post.postAt}" 
				user="${post.user.name}" 
				categoryId="${post.category.id}"
				category="${post.category.name}" 
				title="${post.title}"
				
				profile="${empty post.user.profileImage ? 'profile-photo.png' : post.user.profileImage}">
				
				<c:choose>
					<c:when test="${post.content.length() gt 300}">
						<p>${post.content.substring(0, 300)} ... <span class="text-muted ms-3">see more</span> </p>
					</c:when>
					<c:otherwise>
						<p>${post.content}</p>
					</c:otherwise>
				</c:choose>
			</app:post>
		</c:forEach>
	</c:otherwise>
</c:choose>

