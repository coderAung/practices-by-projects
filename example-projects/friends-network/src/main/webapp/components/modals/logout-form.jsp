<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="modal" id="logout-form">
	<div class="modal-dialog modal-dialog-centered modal-sm">
		<div class="modal-content p-3">
			<h5 class="mb-4"><i class="bi bi-exclamation-square me-3 text-danger"></i> Are you suer to logout?</h5>
			<form action="${pageContext.request.contextPath}/logout" method="post">
				<div>
					<button type="submit" class="btn btn-outline-danger w-50">Yes</button>
				</div>
			</form>
		</div>
	</div>
</div>