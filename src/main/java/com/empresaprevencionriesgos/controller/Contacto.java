package com.empresaprevencionriesgos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empresaprevencionriesgos.model.ClienteDTO;
import com.empresaprevencionriesgos.model.ContactoDTO;
import com.empresaprevencionriesgos.model.UsuarioDTO;
import com.empresaprevencionriesgos.model.services.ClienteService;
import com.empresaprevencionriesgos.model.services.ContactoService;

/**
 * Servlet implementation class Contacto
 */
@WebServlet("/Contacto")
public class Contacto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Contacto() {
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
		HttpSession session = request.getSession();
		UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

		// solo cliente tiene acceso a la página de contacto.
		if (usuario != null && usuario.getPerfilId() == 2) {
			ClienteService clienteService = new ClienteService();
			ClienteDTO cliente = clienteService.obtenerCliente(usuario.getRut());
			request.setAttribute("cliente", cliente);
			getServletContext().getRequestDispatcher("/app/views/cliente/contacto.jsp").forward(request, response);
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
		request.setAttribute("postResponse", false);
		HttpSession session = request.getSession();
		UsuarioDTO usuario=(UsuarioDTO) session.getAttribute("usuario");
		// solo cliente tiene acceso a la página de contacto.
		if ( usuario!= null && usuario.getPerfilId()==2) {
			ContactoService contactoService = new ContactoService();
			String mensaje = request.getParameter("mensaje");
			ContactoDTO contactoDTO = new ContactoDTO(mensaje, usuario.getRut());
			if (contactoService.addContacto(contactoDTO)) {
				request.setAttribute("isOk", true);
				contactoService.showDataContacto(contactoDTO);
			} else {
				request.setAttribute("isOk", false);
			}
			request.setAttribute("postResponse", true);
			getServletContext().getRequestDispatcher("/app/views/cliente/contacto.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/app/views/login.jsp").forward(request, response);
		}

	}

}
