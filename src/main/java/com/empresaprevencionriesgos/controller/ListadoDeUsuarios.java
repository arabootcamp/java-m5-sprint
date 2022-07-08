package com.empresaprevencionriesgos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empresaprevencionriesgos.model.UsuarioDTO;
import com.empresaprevencionriesgos.model.services.UsuarioService;

/**
 * Servlet implementation class ListarUsuarios
 */
@WebServlet("/ListadoDeUsuarios")
public class ListadoDeUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListadoDeUsuarios() {
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

		// solo administrativo tiene acceso a la página de listadoDeUsuarios.
		if (usuario!= null && usuario.getPerfilId()==1) {
			
			// Se crea una instancia de la clase UsuarioServicio(lógica de negocio).
			UsuarioService usuarioService = new UsuarioService();

			// Se crea una lista de usuarios que serán seteados para mostrar en la página
			// web.
			List<UsuarioDTO> listaUsuarios = usuarioService.obtenerListaUsuarios();
			request.setAttribute("listaUsuarios", listaUsuarios);
			
			getServletContext().getRequestDispatcher("/app/views/administrativo/listadoDeUsuarios.jsp").forward(request,
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
		// solo administrativo tiene acceso a la página de listadoDeUsuarios.
		if (usuario!= null && usuario.getPerfilId()==1) {
			getServletContext().getRequestDispatcher("/app/views/administrativo/listadoDeUsuarios.jsp").forward(request,
					response);
		} else {
			getServletContext().getRequestDispatcher("/app/views/login.jsp").forward(request, response);
		}
	}

}
