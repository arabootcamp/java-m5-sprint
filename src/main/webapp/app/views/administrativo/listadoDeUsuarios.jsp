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
<!--CSS pluggin data table-->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
<!--extension responsive data table ... basicamente me genera elk boton azul -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/responsive/2.2.9/css/responsive.bootstrap4.min.css">
<!--Link que referencia al archivo "style.css" que indica algunos estilos css-->
<link rel="stylesheet" type="text/css"
	href="../../../assets/css/style.css">
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
				<h2>Listado de todos los usuarios</h2>
			</div>
			
				<!-- Alert en para ingreso de usuario -->
				<div class="text-center my-3">
					<c:if test='${postResponse==true && respuestaEliminacion==true}'>
						<div class="alert alert-success alert-dismissible fade show"
							role="alert">
							El usuario rut <c:out value="${rut}"></c:out> fue eliminado exitosamente.
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>
					<c:if test='${postResponse==true && respuestaEliminacion==false}'>
						<div class="alert alert-danger alert-dismissible fade show"
							role="alert">
							El usuario rut <c:out value="${rut}"></c:out> no se pudo eliminar.
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>
				</div>
		
			<table id="tabla-usuarios"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th scope="col">Nombre de usuario (nick)</th>
						<th scope="col">Password</th>
						<th scope="col">Rut</th>
						<th scope="col">Perfil</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="user" items="${listaUsuarios}">
						<tr>
							<td><c:out value="${user.getNick()}"></c:out></td>
							<td><c:out value="${user.getPassword1()}"></c:out></td>
							<td><c:out value="${user.getRut()}"></c:out></td>
							<td><c:out value="${user.getPerfilNombre()}"></c:out></td>
							<td class="text-center">
							<div class="d-inline-block">
							<a href="<c:out value="${user.urlEditarUsuario()}"></c:out>" class="btn btn-outline-success"><i class="fa-solid fa-pen"></i></a>
							<c:if test="${!user.getRut().equals(usuario.getRut())}"><a href="<c:out value="${user.urlEliminarUsuario()}"></c:out>" class="btn btn-outline-danger ml-3"><i class="fa-solid fa-trash"></i></a></c:if>
							<c:if test="${user.getRut().equals(usuario.getRut())}"><a href="#" class="btn btn-outline-secondary ml-3"><i class="fa-solid fa-trash"></i></a></c:if>
							</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
		
	<!--llamado a plugin data table-->
	<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
	
	<!--llamando al plugin data table extensión responsiva-->
	<script src="https://cdn.datatables.net/responsive/2.2.9/js/dataTables.responsive.min.js"></script>
	
	<!--llamdo al codigo que vamos a crear para usar plugin data table-->
	<script src="app/assets/js/dataTableFn.js"></script>
</body>
</html>
