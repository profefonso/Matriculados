<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Matriculados</title>
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
						class="nav-link">matriculas</a></li>
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
					<h1>Matriculas en Linea</h1>
				</div>
			</div>
		</div>

		<div class="jumbotron">
			<h3>Seleccione Estudiante</h3>
			<hr>
			<c:url var="addAction" value="/estudiante/sel"></c:url>

			<form:form action="${addAction}" id="frm_inicio"
				commandName="estudiante" class="form-horizontal">
				<fieldset>
					<div class="form-group">
						<div class="loadselect"></div>
						<div class="col-lg-10">
							<div class="selectentidad">
								<form:select path="nombre" class="form-control"
									name="estudiante" id="sel_estudiante">
									<form:option value=""></form:option>
									<form:options items="${listEstudiantes}"></form:options>
								</form:select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-10">
							<button type="button" class="btn btn-primary" id="btnConsulta">Consultar</button>
						</div>
					</div>
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
