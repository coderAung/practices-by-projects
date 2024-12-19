<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:choose>
	<c:when test="${empty post}">
		<app:category value="All" active="${empty param.category or param.category eq 'All'}"/>
		<c:forEach var="item" items="${categories}">
			<app:category id="${item.id}" value="${item.name}" active="${item.name eq param.category}"/>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<app:category value="All" active="${empty post.category.name or post.category.name eq 'All'}"/>
		<c:forEach var="item" items="${categories}">
			<app:category id="${item.id}" value="${item.name}" active="${item.name eq post.category.name}"/>
		</c:forEach>
	</c:otherwise>
</c:choose>
