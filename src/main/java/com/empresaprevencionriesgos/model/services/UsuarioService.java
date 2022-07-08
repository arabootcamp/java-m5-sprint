package com.empresaprevencionriesgos.model.services;

import java.util.List;
import com.empresaprevencionriesgos.model.UsuarioDTO;
import com.empresaprevencionriesgos.model.DAO.IUsuarioDAO;
import com.empresaprevencionriesgos.model.DAO.inMySQL.MySQLUsuarioDAO;

public class UsuarioService {

	private IUsuarioDAO usuarioDao = new MySQLUsuarioDAO();

	// nick, password1, perfilId
	public UsuarioDTO get(String[] params) {
		int perfilId;
		try {
			perfilId = Integer.parseInt(params[2]);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return usuarioDao.get(params[0], params[1], perfilId);
	}

	public List<UsuarioDTO> obtenerListaUsuarios() {
		return usuarioDao.getAll();
	}
	
	public boolean eliminarUsuario(String rut) {
		return usuarioDao.delete(rut);
	}


}
