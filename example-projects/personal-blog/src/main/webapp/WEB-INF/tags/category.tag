<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ attribute name="value" required="true" type="java.lang.String"%>
<%@ attribute name="id" type="java.lang.String"%>
<%@ attribute name="active" type="java.lang.Boolean"%>

<div class="col-auto category-item py-1 px-2 text-center rounded ${active ? 'bg-primary' : 'border'}">
	<a class="d-block text-decoration-none w-100 ${active ? 'text-white' : ''}" href="${root}/posts?category=${value}">${value}</a>
</div>