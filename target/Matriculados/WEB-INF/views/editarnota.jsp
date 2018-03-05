<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Notas</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/custom.min.css" />"
	rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
		<div class="container">
			<a href="<c:url value='/' />" class="navbar-brand">Matriculados</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav">
					<li class="nav-item"><a
						href="<c:url value='/estudiantes/all' />" class="nav-link">Estudiantes</a></li>
					<li class="nav-item"><a href="<c:url value='/cursos/all' />"
						class="nav-link">Cursos</a></li>
					<li class="nav-item"><a
						href="<c:url value='/matriculas/all' />" class="nav-link">Matriculas</a></li>
				</ul>

				<ul class="nav navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link"
						href="http://www.alfonsocarop.com/" target="_blank">Alfonso
							Caro Portillo</a></li>
				</ul>

			</div>
		</div>
	</div>
	<div class="container">
		<div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<h1>Editar Nota de ${curso.nombre} para  ${estudiante.nombre}</h1>
				</div>
			</div>
		</div>
		<div class="jumbotron">
			<c:url var="addAction" value="/matricula/add"></c:url>
			<form:form action="${addAction}" id="frm_edit_nota"
				commandName="matricula">
				<fieldset>
					<div class="form-group">
						<label class="col-form-label" for="id">ID</label>
						<form:input path="id" readonly="true" size="8" disabled="true"
							class="form-control" />
						<form:hidden path="id" />
						<input type="hidden" name="id_matricula" value="${matricula.id}">
						<input type="hidden" name="estudiante_id" value="${estudiante.id}">
						<input type="hidden" name="curso" value="${curso.nombre}">
					</div>
					<div class="form-group">
						<label class="col-form-label" for="edad">Nota</label>
						<form:input path="nota" id="nota_numerica_edit" type="number" step=".01" class="form-control" />
					</div>
					<div class="form-group">
						<label for="correo">comentario</label>
						<form:textarea path="comentario" class="form-control" />
					</div>
					<button type="button" class="btn btn-primary" id="update_nota">Actualizar</button>
				</fieldset>
			</form:form>
		</div>

	</div>
	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/popper.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/matriculados.js" />"></script>
</body>
</html>
