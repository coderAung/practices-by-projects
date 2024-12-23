<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="className" required="false" type="java.lang.String"%>
<%@ attribute name="src" required="false" type="java.lang.String"%>
<%@ attribute name="alt" required="false" type="java.lang.String"%>

<img src="${pageContext.request.contextPath}/statics/images/${src}" alt="${alt}" class="${className}"/>