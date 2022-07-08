package com.empresaprevencionriesgos.model.services;

import java.time.LocalDate;

import com.empresaprevencionriesgos.model.ClienteDTO;
import com.empresaprevencionriesgos.model.DAO.IClienteDAO;
import com.empresaprevencionriesgos.model.DAO.inMySQL.MySQLClienteDAO;

public class ClienteService {
	private IClienteDAO clienteDao = new MySQLClienteDAO();

	// nick,password1,rut,nombres,apellidos,fechaDeNacimiento,perfilId,telefono,email,afpId,sistemaSaludId,direccion,comuna,organizacion
	private ClienteDTO validarCliente(String[] params) {
		LocalDate fechaDeNacimiento;
		int perfilId, afpId, sistemaSaludId;
		try {
			String[] arregloFecha = params[5].split("-");
			fechaDeNacimiento = LocalDate.parse(arregloFecha[2] + '-' + arregloFecha[1] + '-' + arregloFecha[0]);
			perfilId = Integer.parseInt(params[6]);
			afpId = Integer.parseInt(params[9]);
			sistemaSaludId = Integer.parseInt(params[10]);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return new ClienteDTO(params[0], params[1], params[2], params[3], params[4], fechaDeNacimiento, perfilId,
				params[7], params[8], afpId, sistemaSaludId, params[11], params[12], params[13]);
	}

	public boolean crearCliente(String[] params) {
		ClienteDTO obj = validarCliente(params);
		if (obj == null) {
			return false;
		}
		return clienteDao.save(obj);
	}

	public boolean editarCliente(String[] params) {
		ClienteDTO obj = validarCliente(params);
		if (obj == null) {
			return false;
		}
		return clienteDao.update(obj);
	}

	public ClienteDTO obtenerCliente(String rut) {
		return clienteDao.get(rut);
	}
}
