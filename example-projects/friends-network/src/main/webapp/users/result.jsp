<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<app:master title="Result">
	<div class="container rounded align-self-center bg-white p-3 w-50">
		
		<app:alert alert="${alert}" className="px-3 py-3" btnColor="btn-outline-warning"/>
		
		<div class="sticky-top d-flex">
			<a href="${pageContext.request.contextPath}/" class="btn align-self-start btn-outline-secondary"><i class="bi bi-arrow-left"></i> </a>
			<jsp:include page="/components/search-bar.jsp"/>
		</div>
		
		<div class="result-container container">
			<jsp:include page="/components/search-result.jsp"></jsp:include>
		</div>
	</div>
</app:master>