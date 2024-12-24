<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/password.js"></script>
<div class="modal" id="change-password">
	<div class="modal-dialog modal-dialog-centered modal-sm">
		<div class="modal-content p-3">

			<div class="alert alert-info text-center d-none">
				Password updated successfully!
			</div>

			<form action="${pageContext.request.contextPath}/settings/password" method="post">
				<div class="mb-3">
					<input id="oldPassword" type="text" name="oldPassword" placeholder="Enter Old Password" class="form-control" required="required"/>
					<small id="oldPasswordError" class="text-danger ps-1 d-block text-start d-none">Old Password is incorrect</small>
				</div>
				<div class="mb-3">
					<input id="newPassword" type="text" name="newPassword" placeholder="Enter New Password" class="form-control password" required="required"/>
				</div>
				<div class="mb-3">
					<input id="confirmPassword" type="text" name="confirmPassword" placeholder="Confirm New Password" class="form-control password" required="required"/>
					<small id="confirmPasswordError" class="text-danger ps-1 d-block text-start d-none">Passwords are not same</small>
				</div>
				<div class="text-end">
					<button id="passwordBtn" class="btn w-50 btn-outline-primary" disabled="disabled">Change</button>
				</div>
			</form>
		</div>
	</div>
</div>