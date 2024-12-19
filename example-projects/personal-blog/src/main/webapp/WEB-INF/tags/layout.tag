<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@ attribute name="title" required="true" type="java.lang.String"%>
<%@ attribute name="add" required="false" type="java.lang.Boolean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blog | ${title}</title>

<c:set var="root" value="${pageContext.request.contextPath}" scope="request"></c:set>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link href="${root}/statics/css/style.css" rel="stylesheet">

</head>
<body>
	<div class="container-fluid px-3 py-2">
		<div class="bg-white mb-3 py-3 px-3 d-flex">
			<h1 class="h3">Aung's Blog</h1>
			<div class="d-flex flex-fill ms-5 align-items-center">
				<form class="w-50 d-flex">
					<input type="text" class="form-control" placeholder="Search Posts"/>
					<button type="submit" class="ms-3 btn btn-primary w-25"><i class="bi bi-search me-2"></i> Search</button>
				</form>
				<div class="d-flex justify-content-between flex-fill">
					<c:if test="${not add}">
						<a href="${root}/posts/add" class="btn btn-outline-danger ms-3"><i class="bi bi-plus me-2"></i> Add Post</a>
					</c:if>
					<a href="${root}/profile" class="btn btn-outline-primary ms-3"><i class="bi bi-person-circle me-2"></i> Profile</a>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-2 px-0">
				<!-- Categories -->
				<div class="container py-2">
					<div class="row gap-2 px-2 justify-content-center">
						<jsp:include page="/components/categories.jsp"></jsp:include>
					</div>
				</div>
			</div>
			<div class="col-5 px-0 flex-fill">
				<jsp:doBody></jsp:doBody>
				<jsp:include page="/components/modals/delete-post-modal.jsp"></jsp:include>
			</div>
			<div class="col-3">
				<!-- Last added posts -->
				<jsp:include page="/components/links.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>