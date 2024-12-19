<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<app:layout title="${empty dto ? 'Add' : 'Edit'}" add="true">
	<div class="container">
		<form method="post">
			<div class="row mb-3">
				<c:if test="${not empty dto}">
					<input type="hidden" name="id" value="${dto.id}"/>
				</c:if>
				<app:input className="col-auto" label="Title">
					<input type="text" name="title" class="form-control" placeholder="Enter Title" value="${not empty dto ? dto.title : ''}"/>
				</app:input>
				<app:input className="col-auto" label="Category">
					<input type="text" name="category" class="form-control" placeholder="Enter Category" value="${not empty dto ? dto.category : ''}"/>
				</app:input>
				<button class="col-auto btn btn-primary align-self-end">
					<i class="bi bi-upload me-4"></i> Post
				</button>
			</div>
			<app:input label="Content">
				<textarea class="form-control" name="content" rows="5" cols="">${not empty dto ? dto.content : ''}</textarea>
			</app:input>
		</form>

	</div>
</app:layout>