<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ attribute name="alert" required="true" type="org.core.ywa.friends.dto.output.Alert"%>
<%@ attribute name="className" required="false" type="java.lang.String"%>
<%@ attribute name="btnColor" required="true" type="java.lang.String"%>

<c:if test="${not empty alert}">
	<div class="alert alert-dismissible d-flex justify-content-between align-items-center ${className} ${alert.type}" role="alert">
		<div class="flex-fill">${alert.message}</div>
		<button type="button" class="btn btn-sm ${btnColor}" data-bs-dismiss="alert">
			<i class="bi bi-x"></i>
		</button>
	</div>
	<c:remove var="alert" scope="session"/>
</c:if>
