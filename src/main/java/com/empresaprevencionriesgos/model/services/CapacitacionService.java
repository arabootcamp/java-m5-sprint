package com.empresaprevencionriesgos.model.services;

import java.util.List;

import com.empresaprevencionriesgos.model.CapacitacionDTO;
import com.empresaprevencionriesgos.model.DAO.ICapacitacionDAO;
import com.empresaprevencionriesgos.model.DAO.inMySQL.MySQLCapacitacionDAO;

public class CapacitacionService {

	private ICapacitacionDAO capacitacionDao = new MySQLCapacitacionDAO();

	// identificador,diaId,hora,lugar,duracion,cantidadDeAsistentes,rutCliente
	public boolean crearCapacitacion(String[] params) {
		// identificador lo asigna el sistema, por ahora solo lo haremos random existe
		// una pequeña posibilidad de que se repita pero vamos a obviar esto.
		int identificador = (int) (Math.random() * 1500000000);
		int diaId, duracion, cantidadDeAsistentes;
		try {
			diaId = Integer.parseInt(params[1]);
			duracion = Integer.parseInt(params[4]);
			cantidadDeAsistentes = Integer.parseInt(params[5]);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return capacitacionDao.save(new CapacitacionDTO(identificador, diaId, params[2], params[3], duracion, cantidadDeAsistentes, params[6]));
	}
	
	public List<CapacitacionDTO> obtenerListaCapacitaciones(){
		return capacitacionDao.getAll();
	}
	
	public List<CapacitacionDTO> obtenerListaCapacitacionesCliente(String rutCliente){
		return capacitacionDao.getFilterCliente(rutCliente);
	}
}
