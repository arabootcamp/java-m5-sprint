package com.empresaprevencionriesgos.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empresaprevencionriesgos.model.CapacitacionDTO;
import com.empresaprevencionriesgos.model.UsuarioDTO;
import com.empresaprevencionriesgos.model.services.CapacitacionService;

/**
 * Servlet implementation class ListarCapacitaciones
 */
@WebServlet("/ListarCapacitaciones")
public class ListarCapacitaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCapacitaciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UsuarioDTO usuario=(UsuarioDTO) session.getAttribute("usuario");
		
		// solo cliente tiene acceso a la página de listarCapacitaciones.
		if (usuario != null && usuario.getPerfilId()==2) {			
			CapacitacionService capacitacionService = new CapacitacionService();
			ArrayList<CapacitacionDTO> listaCapacitaciones= (ArrayList<CapacitacionDTO>) capacitacionService.obtenerListaCapacitacionesCliente(usuario.getRut());	
			request.setAttribute("listaCapacitaciones", listaCapacitaciones);
			getServletContext().getRequestDispatcher("/app/views/cliente/listarCapacitaciones.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/app/views/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UsuarioDTO usuario=(UsuarioDTO) session.getAttribute("usuario");
		// solo cliente tiene acceso a la página de listarCapacitaciones.
		if (usuario != null && usuario.getPerfilId()==2) {
			getServletContext().getRequestDispatcher("/app/views/cliente/listarCapacitaciones.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/app/views/login.jsp").forward(request, response);
		}
	}

}
