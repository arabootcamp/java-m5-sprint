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
 * Servlet implementation class Ingreso
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		request.setAttribute("postResponse", false);
		getServletContext().getRequestDispatcher("/app/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("postResponse", false);
		String nick = request.getParameter("nick");
		String password1 = request.getParameter("password1");
		String perfilId = request.getParameter("perfil_id");
		String[] params = { nick, password1, perfilId };

		UsuarioService usuarioService = new UsuarioService();
		UsuarioDTO usuario=usuarioService.get(params); 
		
		if (usuario!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			getServletContext().getRequestDispatcher("/Inicio").forward(request, response);
		} else {
			request.setAttribute("postResponse", true);
			getServletContext().getRequestDispatcher("/app/views/login.jsp").forward(request, response);
		}

	}

}
