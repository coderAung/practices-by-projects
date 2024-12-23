<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:choose>
	<c:when test="${empty loginUser}">
		<c:redirect url="/login"></c:redirect>
	</c:when>
	<c:otherwise>
		<app:master title="Home">
			<div class="bg-white rounded p-3 align-self-center w-50">

				<app:alert alert="${alert}" className="alert-info" />

				<h5 class="container mb-3"><i class="bi bi-person me-3"></i>Profile Info</h5>
				<div class="container mb-3 border-bottom pb-3">
					<div class="row">
						<div class="col-auto d-flex justify-content-center">
							<div class="profile-img-container align-self-center">
								<img class="" alt="" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3no4gIMkbEbYNEinyj4G04gY1TGaQIGwatg&s">
							</div>
						</div>
						<div class="col d-flex">
							<div class="border py-2 px-3 w-auto align-self-center fw-bold">${loginUser.name}</div>
							<div class="border py-2 px-3 flex-fill mx-2 align-self-center fw-bold">${loginUser.email}</div>
							<a href="" class="btn btn-outline-secondary w-auto align-self-center"> <i class="bi bi-pencil me-3"></i> Edit</a>
						</div>
					</div>
				</div>
				
				<h5 class="container mb-3">
					<i class="bi bi-search me-3"></i>Search
				</h5>
				<jsp:include page="/components/search-bar.jsp"/>
				
				<h5 class="container mb-3 border-top pt-2"><i class="bi bi-sliders2 me-3"></i>Functions</h5>
				<div class="container mb-3">
					<div class="row">
						<div class="col-4 text-center">
							<div class="btn btn-outline-primary w-100">
								<i class="bi bi-people me-3"></i> Friends
							</div>
						</div>
						<div class="col-4 text-center">
							<div class="btn btn-outline-secondary w-100">
								<i class="bi bi-box-arrow-in-down-left me-3"></i> Inboxes
							</div>
						</div>
						<div class="col-4 text-center">
							<div class="btn btn-outline-danger w-100">
								<i class="bi bi-box-arrow-up-right me-3"></i> Requests
							</div>
						</div>
					</div>
				</div>
		
				<h5 class="container mb-3 border-top pt-2"><i class="bi bi-gear me-3"></i>Settings</h5>
				<div class="container">
					<div class="row justify-content-end">
						<div class="col-4 text-center">
							<div class="btn btn-outline-primary w-100">
								<i class="bi bi-file-earmark-pdf me-3"></i> Logs
							</div>
						</div>
						<div class="col-4 text-center">
							<div class="btn btn-outline-secondary w-100">
								<i class="bi bi-gear me-3"></i> Password
							</div>
						</div>
						<div class="col-4 text-center">
							<div class="btn btn-outline-danger w-100" data-bs-toggle="modal" data-bs-target="#logout-form">
								<i class="bi bi-box-arrow-right me-3"></i> Logout
							</div>
							<jsp:include page="/components/modals/logout-form.jsp"/>
						</div>
					</div>
				</div>
			</div>
		</app:master>
	</c:otherwise>
</c:choose>
