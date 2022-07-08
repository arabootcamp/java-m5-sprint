package com.empresaprevencionriesgos.controller;

import java.io.IOException;
//import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empresaprevencionriesgos.model.UsuarioDTO;
import com.empresaprevencionriesgos.model.services.CapacitacionService;

/**
 * Servlet implementation class CrearCapacitacion
 */
@WebServlet("/CrearCapacitacion")
public class CrearCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearCapacitacion() {
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
		
		// solo cliente tiene acceso a la página de crearCapacitacion.
		if (usuario!= null && usuario.getPerfilId()==2) {
			getServletContext().getRequestDispatcher("/app/views/cliente/crearCapacitacion.jsp").forward(request,
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
		request.setAttribute("postResponse", true);
		HttpSession session = request.getSession();
		UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario"); 
		
		// solo cliente tiene acceso a la página de crearCapacitacion.
		if (usuario != null && usuario.getPerfilId()==2) {

			// a nivel de modelo el usuario y cliente deberia ya estar creado, pero lo vamos
			// a obviar y persistir solo la capacitacion
			// tambien vamos a obvviar las validaciones que deberia hacer el backend,
			// asumimos que se envia el formato requerid
			CapacitacionService capacitacionService = new CapacitacionService();
			// por el momento tomaremos la hora
			String identificador = null;
			String diaId = request.getParameter("dia_id");
			String hora = request.getParameter("hora");
			String lugar = request.getParameter("lugar");
			String duracion = request.getParameter("duracion");
			String cantidadDeAsistentes = request.getParameter("cantidadDeAsistentes");
			String[] params = { identificador, diaId, hora, lugar, duracion, cantidadDeAsistentes, usuario.getRut() };
			
			// retorna true si se creo la capacitacion y false en caso contrario
			if (capacitacionService.crearCapacitacion(params)) {
				request.setAttribute("isOk", true);
			} else {
				request.setAttribute("isOk", false);
			}
			
			// redirigimos a la pagina que genero la solicitud
			getServletContext().getRequestDispatcher("/app/views/cliente/crearCapacitacion.jsp").forward(request,
					response);

		} else {
			getServletContext().getRequestDispatcher("/app/views/login.jsp").forward(request, response);
		}

	}

}
