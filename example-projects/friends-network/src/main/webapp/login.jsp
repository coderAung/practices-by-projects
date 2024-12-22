<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>

<app:master title="Login">
	<div class="bg-white rounded p-3 align-self-center w-50">
		<h4 class="text-center mb-4">Login</h4>
		<div class="container w-75">
		
			<app:alert alert="${alert}" className="alert-info"/>
		
			<form method="post">
				<div class="input-group mb-3">
					<span class="input-group-text text-primary"><i class="bi bi-person-circle"></i></span>
					<input type="text" class="form-control" name="email" placeholder="Enter Email"/>
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text text-primary"><i class="bi bi-key-fill"></i></span>
					<input type="text" class="form-control" name="password" placeholder="Enter Password"/>
				</div>

				<div class="text-end">
					<button class="btn btn-outline-secondary w-auto me-3"><i class="bi bi-person-add me-3"></i>Register</button>
					<button class="btn btn-outline-primary w-auto"><i class="bi bi-box-arrow-in-right me-3"></i> Login</button>
				</div>
			</form>
		</div>
	</div>
</app:master>