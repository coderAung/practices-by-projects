<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@ attribute name="className" required="false" type="java.lang.String"%>

<%@ attribute name="postId" required="true" type="java.lang.String"%>
<%@ attribute name="userId" required="true" type="java.lang.String"%>

<%@ attribute name="user" required="true" type="java.lang.String"%>
<%@ attribute name="profile" required="false" type="java.lang.String"%>
<%@ attribute name="postAt" required="true" type="java.lang.String"%>
<%@ attribute name="title" required="true" type="java.lang.String"%>
<%@ attribute name="categoryId" required="true" type="java.lang.String"%>
<%@ attribute name="category" required="true" type="java.lang.String"%>
<%@ attribute name="detail" required="false" type="java.lang.Boolean"%>


<!-- Posts -->
<div class="container ${className}">
	<div class="mb-2 d-flex">
		<div class="profile-img-container">
			<img
			src="${root}/statics/images/profiles/${profile}" 
			alt="profile image"/>
		</div>
		<div class="ms-2">
			<span class="fw-bold fs-5">${user}</span>
			<small class="d-block text-muted">${postAt}</small>
		</div>
	</div>
	<div class="border py-2 px-3">
		<div class="border-bottom py-2 mb-2 d-flex justify-content-between">
			<div class="w-50">
				<h4 class="d-inline me-2 h5">${title}</h4>
				<small class="text-white bg-primary rounded px-2 py-1">${category}</small>
			</div>
			<div class="align-self-start">
				<c:if test="${not detail}">
					<c:url var="postDetail" value="/posts/detail">
						<c:param name="id" value="${postId}"></c:param>
					</c:url>
					<a href="${postDetail}" class="btn btn-outline-primary">
						<i class="bi bi-eye me-2"></i> View
					</a>
				</c:if>
				
				<c:url var="edit" value="/posts/edit">
					<c:param name="id" value="${postId}"></c:param>
				</c:url>
				<a href="${edit}"
					class="btn btn-outline-secondary">
					<i class="bi bi-pencil me-2"></i> Edit
				</a>
				<button type="button" postId="${postId}"
					class="btn btn-outline-danger delete-post-btn">
					<i class="bi bi-trash me-2"></i> Delete
				</button>
			</div>
		</div>
		
		<!-- main content -->
		<jsp:doBody></jsp:doBody>
		
		<div class="border-top pt-2">
			<form class="d-flex" action="${root}/comments" method="post">
				<input type="hidden" name="postId" value="${postId}"/>
				<div class="input-group">
					<span class="input-group-text"><i class="bi bi-chat-right-dots"></i></span>
					<input type="text" class="form-control me-3" name="comment" placeholder="Give Your Opinion" required="required"/>
				</div>
				<button type="submit" class="btn btn-sm btn-outline-primary w-25">
					<i class="bi bi-send me-3"></i> Send
				</button>
			</form>
		</div>
	</div>
</div>
