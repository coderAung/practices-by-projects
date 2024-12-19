<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="id" required="true" type="java.lang.String"%>
<%@ attribute name="postId" required="true" type="java.lang.String"%>
<%@ attribute name="text" required="true" type="java.lang.String"%>

<div class="border container p-3 mb-2">
	<div class="row justify-content-between">
		<div class="col-9 flex-fill">${text}</div>
		<form class="col-auto" action="${root}/comments/delete" method="post">
			<input type="hidden" name="postId" value="${postId}">
			<input type="hidden" name="id" value="${id}">
			<button type="submit" class="align-self-start btn btn-sm btn-outline-danger w-auto">
				<i class="bi bi-trash me-2"></i> Delete
			</button>
		</form>
	</div>
</div>
