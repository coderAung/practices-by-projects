<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="${pageContext.request.contextPath}/users/search" class="d-flex mb-4 container">
	<div class="input-group">
		<span class="input-group-text bg-primary text-white"><i
			class="bi bi-search"></i></span>
			<input name="keyword" type="text" class="form-control"
			value="${param.keyword}"
			placeholder="Find ${empty param.placeholder ? 'Users' : param.placeholder}"/>
	</div>
	<button class="btn btn-outline-primary w-25 ms-3">Find</button>
</form>