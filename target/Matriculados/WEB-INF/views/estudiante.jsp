<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Estudiantes</title>
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
					<li class="nav-item"><a href="<c:url value='/estudiantes/all' />"
						class="nav-link">Estudiantes</a></li>
					<li class="nav-item"><a href="<c:url value='/cursos/all' />"
						class="nav-link">Cursos</a></li>
					<li class="nav-item"><a href="<c:url value='/matriculas/all' />"
						class="nav-link">Matriculas</a></li>
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
					<h1>Información y Matriculas del Estudiante</h1>
				</div>
			</div>
		</div>

		<div class="jumbotron">
			<c:if test="${ estudiante.getMatriculas().size() > 0}">
				<h3>Matriculas del Estudiante</h3>
				<table class="table table-hover">
					<thead>
						<tr class="table-active">
							<th scope="col">Id Matricula</th>
							<th scope="col">Curso Matriculado</th>
							<th scope="col">Nota</th>
							<th scope="col">Comentario</th>
							<th scope="col">Editar Nota</th>
							<th scope="col">Eliminar Matricula</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${estudiante.getMatriculas()}" var="matricula">
							<tr>
								<td>${matricula.id}</td>
								<td>${matricula.curso}</td>
								<td>${matricula.nota}</td>
								<td>${matricula.comentario}</td>
								<td><a
									href="<c:url value='/matricula/edit/${matricula.id}' />">Editar</a></td>
								<td><a
									href="<c:url value='/matricula/remove/${matricula.id}' />">Eliminar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${!empty estudiante.nombre}">
				<c:url var="addAction_m" value="/matricula/new"></c:url>

				<form:form action="${addAction_m}" commandName="matricula">
					<input type="hidden" name="id_estudiante" value="${estudiante.id}" />
					<input type="submit" class="btn btn-info"
						value="<spring:message text="Adicionar Matricula"/>" />
				</form:form>
			</c:if>
		</div>

		<div class="jumbotron">
			<c:url var="addAction" value="/estudiante/add"></c:url>
			<form:form action="${addAction}" id="frm_estudiante"
				commandName="estudiante">
				<legend>Información del Estudiante</legend>
				<fieldset>
					<div class="form-group">
						<label class="col-form-label" for="id">ID</label>
						<form:input path="id" readonly="true" size="8" disabled="true"
							class="form-control" />
						<form:hidden path="id" />
					</div>
					<div class="form-group">
						<label class="col-form-label" for="nombre">Nombre</label>
						<form:input path="nombre" class="form-control" />
					</div>
					<div class="form-group">
						<label class="col-form-label" for="edad">Edad</label>
						<form:input path="edad" type="number" class="form-control" />
					</div>
					<div class="form-group">
						<label for="correo">Email</label>
						<form:input path="correo" class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary">Actaulizar
						Infrormacion</button>
				</fieldset>
			</form:form>
		</div>
		<br>



	</div>
	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/popper.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
