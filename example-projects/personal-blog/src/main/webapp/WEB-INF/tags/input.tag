<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="label" required="true" type="java.lang.String"%>
<%@ attribute name="className" required="false" type="java.lang.String"%>

<div class="${className}">
	<label class="form-label">${label}</label>
	<jsp:doBody></jsp:doBody>
</div>
