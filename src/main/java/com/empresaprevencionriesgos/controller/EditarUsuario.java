package com.empresaprevencionriesgos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empresaprevencionriesgos.model.AdministrativoDTO;
import com.empresaprevencionriesgos.model.ClienteDTO;
import com.empresaprevencionriesgos.model.ProfesionalDTO;
import com.empresaprevencionriesgos.model.UsuarioDTO;
import com.empresaprevencionriesgos.model.services.AdministrativoService;
import com.empresaprevencionriesgos.model.services.ClienteService;
import com.empresaprevencionriesgos.model.services.ProfesionalService;

/**
 * Servlet implementation class EditarUsuario
 */
@WebServlet("/EditarUsuario")
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//System.out.println(usuarioEditar.getFechaDeNacimiento());
		HttpSession session = request.getSession();
		UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

		// solo administrativo tiene acceso a la página..
		if (usuario != null && usuario.getPerfilId() == 1) {
			String rutEditar = request.getParameter("rut");
			String perfilIdEditar = request.getParameter("perfil_id");

			UsuarioDTO usuarioEditar=null;
			//administrativo
			if (perfilIdEditar.equals("1")) {
				AdministrativoService administrativoService=new AdministrativoService();
				usuarioEditar=(AdministrativoDTO)administrativoService.obtenerAdministrativo(rutEditar);
			}

			//cliente
			if (perfilIdEditar.equals("2")) {
				ClienteService clienteService = new ClienteService();
				usuarioEditar=(ClienteDTO)clienteService.obtenerCliente(rutEditar);
			}

			//profesional
			if (perfilIdEditar.equals("3")) {
				ProfesionalService profesionalService= new ProfesionalService();
				usuarioEditar=(ProfesionalDTO)profesionalService.obtenerProfesional(rutEditar);
			}
            
			request.setAttribute("usuarioEditar", usuarioEditar);
			request.setAttribute("postResponse", false);//esto para saber que no va de post
			getServletContext().getRequestDispatcher("/app/views/administrativo/editarUsuario.jsp").forward(request,
					response);
		} else {
			getServletContext().getRequestDispatcher("/app/views/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Editar Usuario");
		// hace nada dopost
		HttpSession session = request.getSession();
		UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
		
		// solo administrativo tiene acceso a la página..
		if (usuario != null && usuario.getPerfilId() == 1) {

			boolean respuestaEdicion=false;
			
			String nick = request.getParameter("nick");
			String password1 = request.getParameter("password1");
			String rut = request.getParameter("rut");
			String nombres = request.getParameter("nombres");
			String apellidos = request.getParameter("apellidos");
			String fechaDeNacimiento = request.getParameter("birthday");
			String perfilId = request.getParameter("perfil_id");//va ser null pq no hay radio			
			System.out.println("post editar");
			UsuarioDTO usuarioEditar=null;
			//administrativo
			if (perfilId.equals("1")) {
				String  area= request.getParameter("area");
				String  experienciaPrevia= request.getParameter("experiencia_previa");
				AdministrativoService administrativoService=new AdministrativoService();
				String[] params= {nick,password1,rut,nombres,apellidos,fechaDeNacimiento,perfilId,area,experienciaPrevia};
				respuestaEdicion=administrativoService.editarAdministrativo(params);
				usuarioEditar=administrativoService.obtenerAdministrativo(rut);
			}
			
			//cliente
			if (perfilId.equals("2")) {
				String  telefono= request.getParameter("telefono");
				String  email= request.getParameter("email");
				String  afpId= request.getParameter("afp_id");
				String  sistemaSaludId= request.getParameter("sistema_salud_id");
				String  direccion= request.getParameter("direccion");
				String  comuna= request.getParameter("comuna");
				String  organizacion= request.getParameter("organizacion");
				ClienteService clienteService = new ClienteService();
				String[] params= {nick,password1,rut,nombres,apellidos,fechaDeNacimiento,perfilId,telefono,email,afpId,sistemaSaludId,direccion,comuna,organizacion};
				respuestaEdicion=clienteService.editarCliente(params);
				usuarioEditar=clienteService.obtenerCliente(rut);
			}

			//profesional
			if (perfilId.equals("3")) {
				String  titulo= request.getParameter("titulo");
				String  fechaDeIngreso= request.getParameter("fecha_de_ingreso");//revisar esto
				ProfesionalService profesionalService= new ProfesionalService();
				String[] params= {nick,password1,rut,nombres,apellidos,fechaDeNacimiento,perfilId,titulo,fechaDeIngreso};
				respuestaEdicion=profesionalService.editarProfesional(params);
				usuarioEditar=profesionalService.obtenerProfesional(rut);
			}
			
			request.setAttribute("postResponse", true);
			request.setAttribute("respuestaEdicion", respuestaEdicion);
			request.setAttribute("usuarioEditar", usuarioEditar);
			request.setAttribute("rut",rut);
			
			getServletContext().getRequestDispatcher("/app/views/administrativo/editarUsuario.jsp").forward(request,
					response);
		} else {
			getServletContext().getRequestDispatcher("/app/views/login.jsp").forward(request, response);
		}

	}

}
