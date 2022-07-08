package com.empresaprevencionriesgos.model.services;


import java.time.LocalDate;

import com.empresaprevencionriesgos.model.ProfesionalDTO;
import com.empresaprevencionriesgos.model.DAO.IProfesionalDAO;
import com.empresaprevencionriesgos.model.DAO.inMySQL.MySQLProfesionalDAO;


public class ProfesionalService {

	private IProfesionalDAO profesionalDao = new MySQLProfesionalDAO();

	// nick,password1,rut,nombres,apellidos,fechaDeNacimiento,perfilId,titulo,fechaDeIngreso
	private ProfesionalDTO validarProfesional(String[] params) {
		int perfilId;
		LocalDate fechaDeNacimiento;
		LocalDate fechaDeIngreso;
		try {
			perfilId = Integer.parseInt(params[6]);
			String[] arregloFecha = params[5].split("-");
			fechaDeNacimiento = LocalDate.parse(arregloFecha[2] + '-' + arregloFecha[1] + '-' + arregloFecha[0]);
			arregloFecha = params[8].split("-");
			fechaDeIngreso = LocalDate.parse(arregloFecha[2] + '-' + arregloFecha[1] + '-' + arregloFecha[0]);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return new ProfesionalDTO(params[0], params[1], params[2], params[3], params[4], fechaDeNacimiento, perfilId,
				params[7], fechaDeIngreso);
	}

	public boolean crearProfesional(String[] params) {
		ProfesionalDTO obj = validarProfesional(params);
		if (obj == null) {
			return false;
		}
		return profesionalDao.save(obj);
	}

	public boolean editarProfesional(String[] params) {
		ProfesionalDTO obj = validarProfesional(params);
		if (obj == null) {
			return false;
		}
		return profesionalDao.update(obj);
	}
	
	public ProfesionalDTO obtenerProfesional(String rut) {
		return profesionalDao.get(rut);
	}
}
