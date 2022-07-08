<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">G-01</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">

			<!-- Todos los usuarios -->
			<li class="nav-item"><a class="nav-link" href="Inicio">Inicio</a>
			</li>

			<!--Menu administrativo-->
			<c:if test='${usuario.getPerfilId()==1}'>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-expanded="false">Usuarios
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="ListadoDeUsuarios">Listado de
							Usuarios</a> <a class="dropdown-item" href="CrearUsuario">Crear
							Usuario</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-expanded="false">Pagos
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="EnConstruccion">Listado Pago</a> <a
							class="dropdown-item" href="EnConstruccion">Crear Pago</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="EnConstruccion">Administrar
						chequeos</a></li>
			</c:if>

			<!-- Menu cliente -->
			<c:if test='${usuario.getPerfilId()==2}'>
				<li class="nav-item"><a class="nav-link" href="Contacto">Contacto</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-expanded="false">
						Capacitación </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="CrearCapacitacion">Crear
							Capacitación</a> <a class="dropdown-item" href="ListarCapacitaciones">Listar
							Capacitaciones</a> <a class="dropdown-item" href="EnConstruccion">Administrar
							Asistentes</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="EnConstruccion">Gestionar
						accidentes</a></li>
			</c:if>

			<!-- Menu profesional -->
			<c:if test='${usuario.getPerfilId()==3}'>
				<li class="nav-item"><a class="nav-link" href="EnConstruccion">Listado
						Visitas</a></li>
				<li class="nav-item"><a class="nav-link" href="EnConstruccion">Responder
						checklist</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-expanded="false">
						Asesorías </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="EnConstruccion">Listado
							Asesorías</a> <a class="dropdown-item" href="EnConstruccion">Crear
							Asesorías</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="EnConstruccion">Reportes</a>
				</li>
			</c:if>

		</ul>

		<!-- Todos los usuarios -->
		<ul class="navbar-nav ml-auto">
			<c:if test='${usuario==null}'>
				<li class="nav-item"><a class="nav-link" href="Login">SignIn
						<i class="fa-solid fa-right-to-bracket"></i>
				</a></li>
			</c:if>

			<c:if test='${usuario!=null}'>
				<li class="nav-item"><a class="nav-link text-white" href="#">
						Bienvenido <c:out value="${usuario.getNick()} - "></c:out> <c:out
							value="${usuario.getPerfilId()==1 ? 'administrativo' : usuario.getPerfilId()==2 ? 'cliente' : 'profesional' }"></c:out>
						<i class="fa-solid fa-user-check"></i>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="CerrarSesion">
						SignOut <i class="fa-solid fa-right-from-bracket"></i>
				</a></li>
			</c:if>
		</ul>

	</div>
</nav>