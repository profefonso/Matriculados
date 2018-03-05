<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Cursos All</title>
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
					<h1>Cursos</h1>
				</div>
			</div>
		</div>
		<div class="jumbotron">
		<a href="#cursoFrm" title="curso_frm" class="btn btn-primary">Nuevo Curso</a>
		<hr>
			<c:if test="${ !empty listCursos}">
				<h3>Listado de cursos</h3>
				<table class="table table-hover">
					<thead>
						<tr class="table-active">
							<th scope="col">Id</th>
							<th scope="col">Nombre</th>
							<th scope="col">Descripcion</th>
							<th scope="col">Editar</th>
							<th scope="col">Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listCursos}" var="curso">
							<tr>
								<td>${curso.id}</td>
								<td>${curso.nombre}</td>
								<td>${curso.descripcion}</td>
								<td><a
									href="<c:url value='/curso/edit/${curso.id}#cursoFrm' />">Editar</a></td>
								<td><a
									href="<c:url value='/curso/remove/${curso.id}' />">Eliminar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		<br>
		<a name="cursoFrm"></a>
		<div class="jumbotron">
			<c:url var="addAction" value="/curso/add"></c:url>
			<form:form action="${addAction}" id="frm_curso"
				commandName="curso">
				<legend>Información del curso</legend>
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
						<label class="col-form-label" for="descripcion">Descripcion</label>
						<form:input path="descripcion" class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary">Enviar</button>
				</fieldset>
			</form:form>
		</div>
		
	</div>
	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/popper.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
