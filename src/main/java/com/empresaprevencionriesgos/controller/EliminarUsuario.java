package com.empresaprevencionriesgos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empresaprevencionriesgos.model.UsuarioDTO;
import com.empresaprevencionriesgos.model.services.UsuarioService;

/**
 * Servlet implementation class EliminiarUsuario
 */
@WebServlet("/EliminarUsuario")
public class EliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

		System.out.println("Entrando a eliminar usuario");
		// solo administrativo tiene acceso a la página..
		if (usuario != null && usuario.getPerfilId() == 1) {

			String rutUsuarioEliminar = request.getParameter("rut");
			UsuarioService usuarioService = new UsuarioService();

			if (rutUsuarioEliminar != null) {
				boolean eliminacionUsuarioOk = usuarioService.eliminarUsuario(rutUsuarioEliminar);
				request.setAttribute("postResponse", true);
				request.setAttribute("respuestaEliminacion",eliminacionUsuarioOk);
				request.setAttribute("rut",rutUsuarioEliminar);
			}
			// redirigo
			getServletContext().getRequestDispatcher("/ListadoDeUsuarios").forward(request,response);
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

		HttpSession session = request.getSession();
		UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
		System.out.println("Entrando a eliminar usuario 2");
		// solo administrativo tiene acceso a la página..
		if (usuario != null && usuario.getPerfilId() == 1) {
			// redirigo

			getServletContext().getRequestDispatcher("/ListadoDeUsuarios").forward(request,response);
		} else {
			getServletContext().getRequestDispatcher("/app/views/login.jsp").forward(request, response);
		}
	}

}
