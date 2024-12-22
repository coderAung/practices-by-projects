<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ attribute name="alert" required="true" type="java.lang.String"%>
<%@ attribute name="className" required="false" type="java.lang.String"%>

<c:if test="${not empty alert}">
	<div class="alert ${className}">${alert}</div>
	<c:remove var="alert" scope="session"/>
</c:if>
