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
				<h2>Contáctate con nosotros</h2>
				<p class="lead">Tienes alguna duda, comunícate con nosotros.</p>
			</div>

			<div class="text-center my-3">
				<c:if test='${postResponse==true && isOk==true}'>
					<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<strong><c:out value="${cliente.getNombres()} "></c:out></strong>
						el mensaje fue registrado exitosamente.
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
						el mensaje no se pudo registrar.
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
			</div>

			<div class="row justify-content-center align-items-center">
				<div class="col-md-8 order-md-1">
					<form class="needs-validation" action="Contacto" method="post">
						<div class="mb-3">
							<label for="nombre_apellido">Nombre completo </label> <input
								type="text" class="form-control" id="nombre_apellido"
								name="nombre_apellido" disabled
								value="<c:out value="${cliente.getNombres()} ${cliente.getApellidos()}"></c:out>"
								required>
							<div class="invalid-feedback">Valid first name is required.</div>
						</div>
						<div class="mb-3">
							<label for="email">Email </label> <input type="email"
								class="form-control" id="email" name="email" disabled
								value="<c:out value="${cliente.getEmail()}"></c:out>" required>
							<div class="invalid-feedback">Please enter a valid email
								address for shipping updates.</div>
						</div>

						<div class="mb-3">
							<label for="organizacion">Compañía/Organización</label> <input
								type="text" class="form-control" id="organizacion"
								name="organizacion" disabled
								value="<c:out value="${cliente.getOrganizacion()}"></c:out>"
								required>
							<div class="invalid-feedback">Please enter your shipping
								address.</div>
						</div>

						<div class="form-group">
							<label for="mensaje">Mensaje *</label>
							<textarea class="form-control" id="mensaje" name="mensaje"
								pattern="[A-Za-z]{2}.*"
								title="Debe contener al menos 2 letras al inicio" rows="10"
								required>
							</textarea>
						</div>
						<hr class="mb-4">

						<button
							class="d-flex justify-content-center btn btn-primary btn-lg mx-auto"
							type="submit">Enviar</button>

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
</body>
</html>