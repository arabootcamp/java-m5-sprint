package com.empresaprevencionriesgos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empresaprevencionriesgos.model.UsuarioDTO;
/*import com.empresaprevencionriesgos.model.services.AdministrativoService;
import com.empresaprevencionriesgos.model.services.ClienteService;
import com.empresaprevencionriesgos.model.services.ProfesionalService;*/
import com.empresaprevencionriesgos.model.services.AdministrativoService;
import com.empresaprevencionriesgos.model.services.ClienteService;
import com.empresaprevencionriesgos.model.services.ProfesionalService;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
		// solo administrativo tiene acceso a la página de crearUsuario.
		if (usuario != null && usuario.getPerfilId() == 1) {
			getServletContext().getRequestDispatcher("/app/views/administrativo/crearUsuario.jsp").forward(request,
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
		// solo administrativo tiene acceso a la página de crearUsuario.
		if (usuario != null && usuario.getPerfilId() == 1) {
			
			boolean respuestaCreacion=false;
			
			String nick = request.getParameter("nick");
			String password1 = request.getParameter("password1");
			String rut = request.getParameter("rut");
			String nombres = request.getParameter("nombres");
			String apellidos = request.getParameter("apellidos");
			String fechaDeNacimiento = request.getParameter("birthday");
			String perfilId = request.getParameter("perfil_id");			
			
			//administrativo
			if (perfilId.equals("1")) {
				String  area= request.getParameter("area");
				String  experienciaPrevia= request.getParameter("experiencia_previa");
				AdministrativoService administrativoService=new AdministrativoService();
				String[] params= {nick,password1,rut,nombres,apellidos,fechaDeNacimiento,perfilId,area,experienciaPrevia};
				respuestaCreacion=administrativoService.crearAdministrativo(params);
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
				respuestaCreacion=clienteService.crearCliente(params);
			}

			//profesional
			if (perfilId.equals("3")) {
				String  titulo= request.getParameter("titulo");
				String  fechaDeIngreso= request.getParameter("fecha_de_ingreso");//revisar esto
				ProfesionalService profesionalService= new ProfesionalService();
				String[] params= {nick,password1,rut,nombres,apellidos,fechaDeNacimiento,perfilId,titulo,fechaDeIngreso};
				respuestaCreacion=profesionalService.crearProfesional(params);
			}

			request.setAttribute("postResponse", true);
			request.setAttribute("respuestaCreacion", respuestaCreacion);
			request.setAttribute("rut",rut);
			getServletContext().getRequestDispatcher("/app/views/administrativo/crearUsuario.jsp").forward(request, response);
		} else {
			request.setAttribute("postResponse", true);
			getServletContext().getRequestDispatcher("/app/views/login.jsp").forward(request, response);
		}
	}

}
