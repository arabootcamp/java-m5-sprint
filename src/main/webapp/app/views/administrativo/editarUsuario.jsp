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

			<div class="container h-100">
				<div class="my-5 text-center">
					<h2>Editar Usuario</h2>
					<h4>Exclusivo para administrativo</h4>
				</div>

				<!-- Alert en para edicion de usuario -->
				<div class="text-center my-3">
					<c:if test='${postResponse==true && respuestaEdicion==true}'>
						<div class="alert alert-success alert-dismissible fade show"
							role="alert">
							El usuario rut <c:out value="${rut}"></c:out> fue editado exitosamente.
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>
					<c:if test='${postResponse==true && respuestaEdicion==false}'>
						<div class="alert alert-danger alert-dismissible fade show"
							role="alert">
							El usuario rut <c:out value="${rut}"></c:out> no se pudo editar, recuerde que rut y nick deben ser distintos a alguno existente.
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>
				</div>

				<div class="row h-100 justify-content-center align-items-center">
					<div class="col-md-8 order-md-1">
						<h4 class="mb-3">
							Editando a un usuario con perfil <i class="text-primary"><c:out
									value="${usuarioEditar.getPerfilNombre()}"></c:out></i>
						</h4>
						<hr class="mb-4">
						<form id="form__crear-usuario" action="EditarUsuario"
							class="needs-validation" method="post">

							<!-- Datos en Comun perfiles -->
							<div class="row">
								<div class="col-lg-4 mb-3">
									<label for="nick">Nombre usuario <span
										class="text-muted">*</span></label> <input type="text"
										class="form-control" id="nick" placeholder="nick" name="nick"
										minlength="3" maxlength="20"
										value="<c:out value='${usuarioEditar.getNick()}'></c:out>"
										required>
									<div class="invalid-feedback">Please enter a valid email
										address for shipping updates.</div>
								</div>
								<div class="col-lg-4 mb-3">
									<label for="password1">Password <span
										class="text-muted">*</span></label> <input type="text"
										class="form-control" id="password1" placeholder=""
										name="password1" minlength="3" maxlength="20"
										value="<c:out value='${usuarioEditar.getPassword1()}'></c:out>"
										required>
									<div class="invalid-feedback">Please enter a valid email
										address for shipping updates.</div>
								</div>
								<div class="col-lg-4 mb-3">
									<label for="rut">Rut <span class="text-muted">*</span></label>
									<input type="text" class="form-control" id="rut"
										placeholder="11.111.111-1" name="rut"
										pattern="([1-9]|[1-9][0-9])\.[0-9]{3}?.[0-9]{3}-[0-9k]"
										title="ejemplo: 11.111.111-1"
										value="<c:out value='${usuarioEditar.getRut()}'></c:out>"
										required>
									<div class="invalid-feedback">Please enter a valid email
										address for shipping updates.</div>
								</div>

								<div class="col-lg-4 mb-3">
									<label for="nombres">Nombres <span class="text-muted">*</span></label>
									<input type="text" class="form-control" id="nombres"
										placeholder="" name="nombres" minlength="2" maxlength="49"
										value="<c:out value='${usuarioEditar.getNombres()}'></c:out>"
										required>
									<div class="invalid-feedback">Please enter a valid email
										address for shipping updates.</div>
								</div>
								<div class="col-lg-4 mb-3">
									<label for="apellidos">Apellidos <span
										class="text-muted">*</span></label> <input type="text"
										class="form-control" id="apellidos" placeholder=""
										name="apellidos" minlength="2" maxlength="49"
										value="<c:out value='${usuarioEditar.getApellidos()}'></c:out>"
										required>
									<div class="invalid-feedback">Please enter a valid email
										address for shipping updates.</div>
								</div>
								<div class="col-lg-4 mb-3">
									<label for="fecha_de_nacimiento">Fecha de Nacimiento <span
										class="text-muted">*</span></label> <input type="text"
										class="form-control input-" id="fecha_de_nacimiento"
										name="birthday"
										value="<c:out value='${usuarioEditar.fechaFormatoFormulario()}'></c:out>"
										required>
									<div class="invalid-feedback">Please enter a valid email
										address for shipping updates.</div>
								</div>
							</div>

							<hr class="mb-4">

							<!-- Formulario Dinamicos -->
							<div id="form-perfiles">
								<!-- ADMIMNISTRATIVO -->
								<c:if test="${usuarioEditar.getPerfilId()==1}">
									<div id="form__administrativo">
										<div class="row">
											<div class="col-12 mt-2 d-flex justify-content-center">
												<div class="form-group">
													<div class="form-check form-check-inline">
														<input class="form-check-input" type="radio"
															name="perfil_id" id="perfil_1" value="1" checked>
														<label class="form-check-label" for="perfil_1">Administrativo</label>
													</div>
												</div>
											</div>
											<div class="col-12">
												<hr class="mb-4">
											</div>
											<div class="col-lg-6 mb-3">
												<label for="area">Area </label> <input type="text"
													class="form-control" id="area" placeholder="" name="area"
													minlength="2" maxlength="99"
													value="<c:out value='${usuarioEditar.getArea()}'></c:out>">
												<div class="invalid-feedback">Please enter a valid
													email address for shipping updates.</div>
											</div>
											<div class="col-lg-6 mb-3">
												<label for="experiencia_previa">Experiencia Previa</label> <input
													type="text" class="form-control" id="experiencia_previa"
													placeholder="" name="experiencia_previa" minlength="2"
													maxlength="99"
													value="<c:out value='${usuarioEditar.getExperienciaPrevia()}'></c:out>">
												<div class="invalid-feedback">Please enter a valid
													email address for shipping updates.</div>
											</div>
										</div>
									</div>
								</c:if>

								<!-- CLIENTE -->
								<c:if test="${usuarioEditar.getPerfilId()==2}">
									<div id="form__cliente">
										<div class="row">
											<div class="col-12 mt-2 d-flex justify-content-center">
												<div class="form-group">
													<div class="form-check form-check-inline">
														<input class="form-check-input" type="radio"
															name="perfil_id" id="perfil_2" value="2" checked>
														<label class="form-check-label" for="perfil_2">Cliente</label>
													</div>
												</div>
											</div>
											<div class="col-12">
												<hr class="mb-4">
											</div>
											<div class="col-lg-6 mb-3">
												<label for="telefono">Teléfono </label> <input type="text"
													class="form-control" id="telefono" placeholder=""
													name="telefono" pattern="[0-9]{8,14}"
													title="Debe ingresar al menos 8 digitos"
													value="<c:out value='${usuarioEditar.getTelefono()}'></c:out>">
												<div class="invalid-feedback">Please enter a valid
													email address for shipping updates.</div>
											</div>
											<div class="col-lg-6 mb-3">
												<label for="email">Email <span
										class="text-muted">*</span></label> <input type="email"
													class="form-control" id="email" placeholder="" name="email"
													value="<c:out value='${usuarioEditar.getEmail()}'></c:out>">
												<div class="invalid-feedback">Please enter a valid
													email address for shipping updates.</div>
											</div>
											<div class="col-lg-6 mb-3">
												<label for="afp_id">AFP <span
										class="text-muted">*</span></label> <select
													class="custom-select" id="afp_id" name="afp_id">
													<option value="1" 
													<c:if test="${usuarioEditar.getAfpId()==1}">
														<c:out value='selected'></c:out>
													</c:if>
													>afp capital</option>
													<option value="2" 
													<c:if test="${usuarioEditar.getAfpId()==2}">
														<c:out value='selected'></c:out>
													</c:if>
													>afp provida</option>
													<option value="3" 
													<c:if test="${usuarioEditar.getAfpId()==3}">
														<c:out value='selected'></c:out>
													</c:if>
													>afp cuprum</option>
													<option value="4" 
													<c:if test="${usuarioEditar.getAfpId()==4}">
														<c:out value='selected'></c:out>
													</c:if>
													>afp habitad</option>
													<option value="5" 
													<c:if test="${usuarioEditar.getAfpId()==5}">
														<c:out value='selected'></c:out>
													</c:if>
													>afp plan vital</option>
													<option value="6" 
													<c:if test="${usuarioEditar.getAfpId()==6}">
														<c:out value='selected'></c:out>
													</c:if>
													>afp modelo</option>
													<option value="7">afp uno</option>
												</select>
											</div>
											<div class="col-lg-6 mb-3">
												<label for="sistema_salud_id">Sistema de salud <span
										class="text-muted">*</span></label> <select
													class="custom-select" id="sistema_salud_id"
													name="sistema_salud_id">
													<option value="1"
													<c:if test="${usuarioEditar.getSistemaSaludId()==1}">
														<c:out value='selected'></c:out>
													</c:if>
													>Fonasa</option>
													<option value="2"
													<c:if test="${usuarioEditar.getSistemaSaludId()==2}">
														<c:out value='selected'></c:out>
													</c:if>
													>Isapre</option>
												</select>
											</div>
											<div class="col-8 mb-3">
												<label for="direccion">Dirección</label> <input type="text"
													class="form-control" id="direccion" placeholder=""
													name="direccion" minlength="2" maxlength="99"
													value="<c:out value='${usuarioEditar.getDireccion()}'></c:out>">
												<div class="invalid-feedback">Please enter a valid
													email address for shipping updates.</div>
											</div>
											<div class="col-lg-4 mb-3">
												<label for="comuna">Comuna</label>
												<div class="input-group mb-3">
													<select class="custom-select" id="comuna" name="comuna">
														<option value=""
														<c:if test="${usuarioEditar.getComuna().equals('')}">
															<c:out value='selected'></c:out>
														</c:if>
														>Seleccionar...</option>
														<option value="Casablanca"
														<c:if test="${usuarioEditar.getComuna().equals('Casablanca')}">
															<c:out value='selected'></c:out>
														</c:if>
														>Casablanca</option>
														<option value="Quilpué"
														<c:if test="${usuarioEditar.getComuna().equals('Quilpué')}">
															<c:out value='selected'></c:out>
														</c:if>
														>Quilpué</option>
														<option value="Quintero"
														<c:if test="${usuarioEditar.getComuna().equals('Quintero')}">
															<c:out value='selected'></c:out>
														</c:if>
														>Quintero</option>
														<option value="San Antonio"
														<c:if test="${usuarioEditar.getComuna().equals('San Antonio')}">
															<c:out value='selected'></c:out>
														</c:if>
														>San Antonio</option>
														<option value="Santiago"
														<c:if test="${usuarioEditar.getComuna().equals('Santiago')}">
															<c:out value='selected'></c:out>
														</c:if>
														>Santiago</option>
														<option value="Valparaíso"
														<c:if test="${usuarioEditar.getComuna().equals('Valparaíso')}">
															<c:out value='selected'></c:out>
														</c:if>
														>Valparaíso</option>
														<option value="Viña del Mar"
														<c:if test="${usuarioEditar.getComuna().equals('Viña del Mar')}">
															<c:out value='selected'></c:out>
														</c:if>
														>Viña del Mar</option>
													</select>
												</div>
											</div>
											<div class="col-12 mb-3">
												<label for="organizacion">Organización <span
										class="text-muted">*</span></label> <input
													type="text" class="form-control" id="organizacion"
													placeholder="" name="organizacion" minlength="2"
													maxlength="99"
													value="<c:out value='${usuarioEditar.getOrganizacion()}'></c:out>" required>
												<div class="invalid-feedback">Please enter a valid
													email address for shipping updates.</div>
											</div>
										</div>
									</div>
								</c:if>

								<!-- PROFESIONAL -->
								<c:if test="${usuarioEditar.getPerfilId()==3}">
									<div id="form__profesional">
										<div class="row">
											<div class="col-12 mt-2 d-flex justify-content-center">
												<div class="form-group">
													<div class="form-check form-check-inline">
														<input class="form-check-input" type="radio"
															name="perfil_id" id="perfil_3" value="3" checked>
														<label class="form-check-label" for="perfil_3">Profesional</label>
													</div>
												</div>
											</div>
											<div class="col-12">
												<hr class="mb-4">
											</div>
											<div class="col-lg-6 mb-3">
												<label for="titulo">Titulo </label> <input type="text"
													class="form-control" id="titulo" placeholder=""
													name="titulo"
													value="<c:out value='${usuarioEditar.getTitulo()}'></c:out>">
												<div class="invalid-feedback">Please enter a valid
													email address for shipping updates.</div>
											</div>
											<div class="col-lg-6 mb-3">
												<label for="fecha_de_ingreso">Fecha de Ingreso</label> <input
													type="text" class="form-control input-"
													id="fecha_de_ingreso" name="fecha_de_ingreso"
												    value="<c:out value="${usuarioEditar.fechaDeIngresoFommatoDMY()}"></c:out>">
												<div class="invalid-feedback">Please enter a valid
													email address for shipping updates.</div>
											</div>
										</div>
									</div>
								</c:if>
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
				<!-- BR para ver el calendar -->
				<br /> <br /> <br />
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

	<!-- Otras -->
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
	<!--CDN Fancybox-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.5.7/jquery.fancybox.min.js"></script>

	<!--Archivo JS fuente-->
	<script src="app/assets/js/main.js"></script>
	<script src="app/assets/js/muestraFormularioSegunPerfil.js"></script>
</body>
</html>