<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" type="java.lang.String"%>
<%@ attribute name="postId" required="true" type="java.lang.String"%>

<div class="container">
	<div class="mb-2 border-bottom px-3 py-2">
		<a href="${postId}" class="d-block text-decoration-none">${title}</a>
	</div>
</div>
