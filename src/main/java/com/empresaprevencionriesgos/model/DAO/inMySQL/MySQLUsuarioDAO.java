package com.empresaprevencionriesgos.model.DAO.inMySQL;

import com.empresaprevencionriesgos.model.UsuarioDTO;
import com.empresaprevencionriesgos.model.DAO.IUsuarioDAO;
import com.empresaprevencionriesgos.model.singleton.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsuarioDAO implements IUsuarioDAO {

	private Connection conexion;

	public MySQLUsuarioDAO() {
		conexion = Conexion.getInstance();
	}

	// nick, password1, perfilId
	@Override
	public UsuarioDTO get(String nick, String password1, int perfilId) {
		UsuarioDTO usuario = null;
		try {
			String sql = "select * from usuario where nick =? and password1=? and perfil_id=?";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, nick);
			stm.setString(2, password1);
			stm.setInt(3, perfilId);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				LocalDate fechaDeNacimiento = LocalDate.parse(rs.getString("fecha_de_nacimiento"));
				usuario = new UsuarioDTO(rs.getString("nick"), rs.getString("password1"), rs.getString("rut"),
						rs.getString("nombres"), rs.getString("apellidos"), fechaDeNacimiento, rs.getInt("perfil_id"));
				System.out.println("Login Exitoso");
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return usuario;
	}

	public List<UsuarioDTO> getAll() {

		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();

		try {
			String sql = "select * from usuario";
			PreparedStatement stm = conexion.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				LocalDate fechaDeNacimiento = LocalDate.parse(rs.getString("fecha_de_nacimiento"));
				lista.add(new UsuarioDTO(rs.getString("nick"), rs.getString("password1"), rs.getString("rut"),
						rs.getString("nombres"), rs.getString("apellidos"), fechaDeNacimiento, rs.getInt("perfil_id")));
				System.out.println("Lista usuarios obtenida");
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return lista;
	}

	public boolean delete(String rut) {
		boolean isOkQuery = false;
		try {
			String sql = "delete from usuario where rut=?";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, rut);

			stm.execute();
			System.out.println("Eliminacion usuario ok");
			isOkQuery = true;
			stm.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return isOkQuery;
	}
}
