package com.empresaprevencionriesgos.model.services;

import java.time.LocalDate;

import com.empresaprevencionriesgos.model.AdministrativoDTO;
import com.empresaprevencionriesgos.model.DAO.IAdministrativoDAO;
import com.empresaprevencionriesgos.model.DAO.inMySQL.MySQLAdministrativoDAO;

public class AdministrativoService {

	private IAdministrativoDAO administrativoDao = new MySQLAdministrativoDAO();

	// nick,password1,rut,nombres,apellidos,fechaDeNacimiento,perfilId,area,experienciaPrevia
	private AdministrativoDTO validarAdministrativo(String[] params) {
		int perfilId;
		LocalDate fechaDeNacimiento;
		try {
			perfilId = Integer.parseInt(params[6]);
			String[] arregloFecha = params[5].split("-");
			fechaDeNacimiento = LocalDate.parse(arregloFecha[2] + '-' + arregloFecha[1] + '-' + arregloFecha[0]);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return new AdministrativoDTO(params[0], params[1], params[2], params[3], params[4], fechaDeNacimiento, perfilId,
				params[7], params[8]);
	}

	public boolean crearAdministrativo(String[] params) {
		AdministrativoDTO obj = validarAdministrativo(params);
		if (obj == null) {
			return false;
		}
		return administrativoDao.save(obj);
	}

	public boolean editarAdministrativo(String[] params) {
		AdministrativoDTO obj = validarAdministrativo(params);
		if (obj == null) {
			return false;
		}
		System.out.print("editar");
		return administrativoDao.update(obj);
	}
	
	public AdministrativoDTO obtenerAdministrativo(String rut) {
		return administrativoDao.get(rut);
	}
}
