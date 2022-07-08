package com.empresaprevencionriesgos.model.DAO.inMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import com.empresaprevencionriesgos.model.AdministrativoDTO;
import com.empresaprevencionriesgos.model.DAO.IAdministrativoDAO;
import com.empresaprevencionriesgos.model.singleton.Conexion;
import java.sql.Connection;

public class MySQLAdministrativoDAO implements IAdministrativoDAO {

	private Connection conexion;

	public MySQLAdministrativoDAO() {
		conexion = Conexion.getInstance();
	}

	@Override
	public AdministrativoDTO get(String rut) {
		AdministrativoDTO administrativo = null;
		try {
			String sql = "select * from usuario inner join administrativo on usuario.usuario_id = administrativo.usuario_id where rut =?";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, rut);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				LocalDate fechaDeNacimiento = LocalDate.parse(rs.getString("fecha_de_nacimiento"));
				administrativo = new AdministrativoDTO(rs.getString("nick"), rs.getString("password1"),
						rs.getString("rut"), rs.getString("nombres"), rs.getString("apellidos"), fechaDeNacimiento,
						rs.getInt("perfil_id"), rs.getString("area"), rs.getString("experiencia_previa"));
				System.out.println("Administrativo get ok");
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return administrativo;
	}

	@Override
	public boolean save(AdministrativoDTO administrativo) {
		boolean isOkQuery = false;

		try {
			String sql = "insert into usuario (usuario_id, nick, password1, rut, nombres, apellidos, fecha_de_nacimiento, perfil_id) values (null,?,?,?,?,?,?,?)";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, administrativo.getNick());
			stm.setString(2, administrativo.getPassword1());
			stm.setString(3, administrativo.getRut());
			stm.setString(4, administrativo.getNombres());
			stm.setString(5, administrativo.getApellidos());
			stm.setDate(6, java.sql.Date.valueOf(administrativo.getFechaDeNacimiento()));
			stm.setInt(7, administrativo.getPerfilId());
			stm.executeUpdate();

			sql = "select usuario_id from usuario where rut=?";
			stm = conexion.prepareStatement(sql);
			stm.setString(1, administrativo.getRut());
			ResultSet rs = stm.executeQuery();
			int usuarioId = -1;
			if (rs.next()) {
				usuarioId = rs.getInt("usuario_id");
				sql = "insert into administrativo values (null,?,?,?)";
				stm = conexion.prepareStatement(sql);
				stm.setString(1, administrativo.getArea());
				stm.setString(2, administrativo.getExperienciaPrevia());
				stm.setInt(3, usuarioId);
				stm.executeUpdate();
				System.out.println("Insert para crear nuevo administrativo ok");
				isOkQuery = true;
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return isOkQuery;
	}

	@Override
	public boolean update(AdministrativoDTO administrativo) {
		boolean isOkQuery = false;

		try {
			String sql = "update usuario set nick=?, password1=?, nombres=?, apellidos=?, fecha_de_nacimiento=? where rut=?";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, administrativo.getNick());
			stm.setString(2, administrativo.getPassword1());
			stm.setString(3, administrativo.getNombres());
			stm.setString(4, administrativo.getApellidos());
			stm.setDate(5, java.sql.Date.valueOf(administrativo.getFechaDeNacimiento()));
			stm.setString(6, administrativo.getRut());
			stm.executeUpdate();

			sql = "select usuario_id from usuario where rut=?";
			stm = conexion.prepareStatement(sql);
			stm.setString(1, administrativo.getRut());
			ResultSet rs = stm.executeQuery();
			int usuarioId = -1;
			if (rs.next()) {
				usuarioId = rs.getInt("usuario_id");
				sql = "update administrativo set area=?, experiencia_previa=? where usuario_id=?";
				stm = conexion.prepareStatement(sql);
				stm.setString(1, administrativo.getArea());
				stm.setString(2, administrativo.getExperienciaPrevia());
				stm.setInt(3, usuarioId);
				stm.executeUpdate();
				System.out.println("Update de administrativo ok");
				isOkQuery = true;
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return isOkQuery;
	}

}
