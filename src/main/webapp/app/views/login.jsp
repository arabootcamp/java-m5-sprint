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
<link rel="stylesheet" type="text/css" href="../assets/css/style.css">
<title>Empresa Prevención de Riesgos</title>
</head>
<body class="min-vh-100 d-flex flex-column justify-content-between">

	<div>
		<div class="bg-dark">
			<div class="container">
				<%@ include file="../components/navbar.jsp"%>
			</div>
		</div>

		<main role="main" class="my-5">
			<div id="login">
				<div class="container">
					<div class="row justify-content-center align-items-center">
						<form id="login-form" class="form" action="Login" method="post">
							<h3 class="text-center text-info mb-5">Login</h3>
							<div class="form-group">
								<label for="nick" class="text-info">Nombre de usuario
									(nick):</label><br> <input type="text" name="nick" id="nick"
									class="form-control" maxlength="20" pattern="[A-Za-z]{2}.*"
									title="Debe contener al menos 2 letras al inicio" required>
							</div>
							<div class="form-group">
								<label for="password1" class="text-info">Contraseña:</label><br>
								<input type="password" name="password1" id="password1"
									class="form-control" minlength="3" maxlength="20" required>
							</div>
							<div class="form-group">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="perfil_id"
										id="perfil_1" value="1" checked> <label
										class="form-check-label" for="perfil_1">Administrativo</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="perfil_id"
										id="perfil_2" value="2"> <label
										class="form-check-label" for="perfil_2">Cliente</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="perfil_id"
										id="perfil_3" value="3"> <label
										class="form-check-label" for="perfil_3">Profesional</label>
								</div>

							</div>
							<input type="submit" name="submit" class="btn btn-info btn-md"
								value="enviar">

							<div id="register-link" class="text-right">
								<a href="#" class="text-info">Register here</a>
							</div>
						</form>
					</div>
					<!-- Alert no logeado -->
					<div class="text-center my-3">
						<c:if test='${postResponse}'>
							<div class="alert alert-danger alert-dismissible fade show"
								role="alert">
								Error en nick o password, intente nuevamente.
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</main>
	</div>

	<%@ include file="../components/footer.jsp"%>
	<!--CDN jQuery-->
	<!-- <script src="https://code.jquery.com/jquery-3.4.1.js"
		integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
		crossorigin="anonymous"></script>-->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
	<!--CDN Fancybox-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.5.7/jquery.fancybox.min.js"></script>
	<!--Popper Bootstrap-->
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<!-- JS Bootstrap-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
		crossorigin="anonymous"></script>
	<!--Archivo JS fuente-->
	<script src="assets/js/main.js"></script>

</body>
</html>