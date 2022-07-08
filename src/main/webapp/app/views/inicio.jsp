<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
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
				<%@ include file="../components/navbar.jsp"%>
			</div>
		</div>

		<header>
			<!-- Main jumbotron for a primary marketing message or call to action -->
			<div class="jumbotron">
				<div class="container">
					<h1 class="display-3">RiskPrevention</h1>
					<h4>Estamos para protegerlo.</h4>
					<br>
					<p>Somos una empresa dedicada a ofrecer la mejor asesoría en
						prevención de riesgos para nuestros clientes.</p>
					<p>
						<a class="btn btn-primary btn-lg" href="#" role="button">Conocer
							más &raquo;</a>
					</p>
				</div>
			</div>
		</header>

		<main class="container my-5" role="main">
			<div class="row row-cols-1 row-cols-md-2 row-cols-xl-3">
				<div class="col py-3">
					<div class="card h-100 mx-auto" style="width: 22rem;">
						<img
							src="https://cdn0.knowledgecity.com/opencontent/courses/previews/CMP1285/800--v112234.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">Servicios de Ciberseguridad</h5>
							<p class="card-text">
								<strong>Expertos en ciberseguridad</strong><br /> Soluciones
								innovadoras diseñadas para proteger sus datos e infraestructura
								IT contra amenazas internas y externas. Ofrecemos soluciones de
								ciberseguridad confiables y comprometidas en potenciar y
								proteger su negocio, acompañamos los proyectos con líderes del
								mercado y servicios profesionales brindados por expertos.
							</p>
							<a href="#" class="btn btn-primary">Más información</a>
						</div>
					</div>
				</div>
				<div class="col py-3">
					<div class="card h-100 mx-auto" style="width: 22rem;">
						<img
							src="https://cdn0.knowledgecity.com/opencontent/courses/previews/CMP1285/800--v112234.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">Consulting</h5>
							<p class="card-text">
								<strong>Asesoramiento eficaz e innovador</strong><br />
								Soluciones diseñadas para brindar servicios de asesoramiento y
								acompañamiento a través de calificados equipos de expertos en
								los diversos aspectos de prevención de riesgos.
							</p>
							<a href="#" class="btn btn-primary">Más información</a>
						</div>
					</div>
				</div>
				<div class="col py-3">
					<div class="card h-100 mx-auto" style="width: 22rem;">
						<img
							src="https://cdn0.knowledgecity.com/opencontent/courses/previews/CMP1285/800--v112234.jpg"
							class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">Entrenamiento y concentización</h5>
							<p class="card-text">
								<strong>Mejores capacitaciones</strong><br /> Procedimiento de
								trabajo seguro,Sistema de gestión en seguridad y salud
								ocupacional,Reglamento interno de orden higiene y
								seguridad,Calificación industrial,Estudios de extintores,entre
								otros
							</p>
							<a href="#" class="btn btn-primary">Más información</a>
						</div>
					</div>
				</div>
			</div>

		</main>
	</div>

	<%@ include file="../components/footer.jsp"%>

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