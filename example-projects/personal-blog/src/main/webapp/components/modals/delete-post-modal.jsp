<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal" id="delete-post-modal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-body">
				<div class="alert alert-danger"> <i class="bi bi-trash me-2"></i> Delete the post ?</div>
				<form action="${root}/posts/delete" method="post" class="text-end">
					<input id="postId" type="hidden" name="id">
					<button type="submit" class="btn btn-danger">Yes</button>
				</form>
			</div>
		</div>
	</div>
</div>