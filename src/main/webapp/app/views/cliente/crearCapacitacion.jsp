<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- FontAwesome -->
<script src="https://kit.fontawesome.com/27de0eefa2.js"
	crossorigin="anonymous"></script>
<!--CDN Bootstrap-->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<!--Link que referencia al archivo "style.css" que indica algunos estilos css-->
<link rel="stylesheet" type="text/css" href="app/assets/css/style.css">
<title>Empresa Prevención de Riesgos</title>
</head>
<body class="min-vh-100 d-flex flex-column justify-content-between">

	<div>
		<div class="bg-dark">
			<div class="container">
				<%@ include file="../../components/navbar.jsp"%>
			</div>
		</div>

		<main role="main" class="container my-5">

			<div class="my-5 text-center">
				<h2>Registrar Capacitación</h2>
				<h4>Exclusivo para clientes</h4>
				<p class="lead">Registra tu capacitación siguiendo el formulario
					que se encuentra a continuación.</p>
			</div>

			<!-- Alert en para ingreso de capacitación -->
			<div class="text-center my-3">
				<c:if test='${postResponse==true && isOk==true}'>
					<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<strong><c:out value="${cliente.getNombres()} "></c:out></strong>
						la capacitacion fue ingresada existosamente.
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
				<c:if test='${postResponse==true && isOk==false}'>
					<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<strong><c:out value="${cliente.getNombres()} "></c:out></strong>
						la capacitación no se pudo registrar.
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
			</div>

			<div class="row h-100 justify-content-center align-items-center">
				<div class="col-md-8 order-md-1">
					<h4 class="mb-3">Identificación de la capacitación</h4>
					<hr class="mb-4">
					<form action="CrearCapacitacion" class="needs-validation"
						method="post">
						<div class="row">
							<div class="col-xl-6 mb-3">
								<label for="identificador">Identificador de la
									Capacitación</label> <input type="number" class="form-control"
									id="identificador" name="identificador" min=1
									placeholder="valor será asignado por el sistema" disabled
									required />
								<div class="invalid-feedback">Valid last name is required.</div>
							</div>
							<div class="col-xl-6 mb-3">
								<label for="rutCliente">RUT Cliente </label> <input type="text"
									class="form-control" id="rutCliente" name="rutCliente"
									disabled
									value="<c:out value='${usuario.getRut()}'></c:out>" 
									required />
								<div class="invalid-feedback">Please enter a valid email
									address for shipping updates.</div>
							</div>
						</div>

						<div class="row">
							<div class="col-xl-4 mb-3">
								<label for="dia_id">Día</label>
								<div class="input-group mb-3">
									<select class="custom-select" id="dia_id" name="dia_id">
										<option selected value="1">lunes</option>
										<option value="2">martes</option>
										<option value="3">miércoles</option>
										<option value="4">jueves</option>
										<option value="5">viernes</option>
										<option value="6">sábado</option>
										<option value="7">domingo</option>
									</select>
								</div>
							</div>
							<div class="col-xl-4 mb-3">
								<label for="hora">Hora</label> <input type="time"
									class="form-control" id="hora" name="hora" required />
							</div>
							<div class="col-xl-4 mb-3">
								<label for="duracion">Duración (minutos)</label> <input
									type="number" id="duracion" name="duracion"
									value="60" min=1 max=600 class="form-control" />
							</div>
						</div>
						<div class="row">
							<div class="col-xl-6 mb-3">
								<label for="lugar">Lugar</label> <input type="text"
									class="form-control" id="lugar" name="lugar"
									pattern="[A-Za-z]{2}.*"
									title="Debe contener al menos 2 letras al inicio" required />
							</div>
							<div class="col-xl-6 mb-3">
								<label for="cantidadDeAsistentes">Cantidad de Asistentes</label> <input
									type="number" class="form-control"
									id="cantidadDeAsistentes"
									name="cantidadDeAsistentes" value="1" min=1 max=50
									required />
							</div>
						</div>

						<hr class="mb-4">
						<div class="row justify-content-center">
							<button
								class="d-flex justify-content-center btn btn-primary btn-lg "
								type="submit">Enviar</button>
						</div>
					</form>
				</div>
			</div>
		</main>
	</div>

	<%@ include file="../../components/footer.jsp"%>

	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
		integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
		crossorigin="anonymous"></script>

	<!-- Otros -->
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
	<!--CDN Fancybox-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.5.7/jquery.fancybox.min.js"></script>
	<!--Archivo JS fuente-->
	<script src="app/assets/js/main.js"></script>

</body>
</html>