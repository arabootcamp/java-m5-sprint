package com.empresaprevencionriesgos.model.DAO.inMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import com.empresaprevencionriesgos.model.ProfesionalDTO;
import com.empresaprevencionriesgos.model.DAO.IProfesionalDAO;
import com.empresaprevencionriesgos.model.singleton.Conexion;

public class MySQLProfesionalDAO implements IProfesionalDAO {

	private Connection conexion;

	public MySQLProfesionalDAO() {
		conexion = Conexion.getInstance();
	}

	@Override
	public ProfesionalDTO get(String rut) {
		ProfesionalDTO profesional = null;
		try {
			String sql = "select * from usuario inner join profesional on usuario.usuario_id = profesional.usuario_id where rut =?";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, rut);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				LocalDate fechaDeNacimiento = LocalDate.parse(rs.getString("fecha_de_nacimiento"));
				System.out.println(rs.getString("fecha_de_ingreso"));
				LocalDate fechaDeIngreso = LocalDate.parse(rs.getString("fecha_de_ingreso"));
				profesional = new ProfesionalDTO(rs.getString("nick"), rs.getString("password1"),
						rs.getString("rut"), rs.getString("nombres"), rs.getString("apellidos"), fechaDeNacimiento,
						rs.getInt("perfil_id"), rs.getString("titulo"), fechaDeIngreso);
				System.out.println("Profesional get ok");
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return profesional;
	}

	@Override
	public boolean save(ProfesionalDTO profesional) {
		boolean isOkQuery = false;

		try {
			String sql = "insert into usuario (usuario_id, nick, password1, rut, nombres, apellidos, fecha_de_nacimiento, perfil_id) values (null,?,?,?,?,?,?,?)";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, profesional.getNick());
			stm.setString(2, profesional.getPassword1());
			stm.setString(3, profesional.getRut());
			stm.setString(4, profesional.getNombres());
			stm.setString(5, profesional.getApellidos());
			stm.setDate(6, java.sql.Date.valueOf(profesional.getFechaDeNacimiento()));
			stm.setInt(7, profesional.getPerfilId());
			stm.executeUpdate();

			sql = "select usuario_id from usuario where rut=?";
			stm = conexion.prepareStatement(sql);
			stm.setString(1, profesional.getRut());
			ResultSet rs = stm.executeQuery();
			int usuarioId = -1;
			if (rs.next()) {
				usuarioId = rs.getInt("usuario_id");
				sql = "insert into profesional values (null,?,?,?)";
				stm = conexion.prepareStatement(sql);
				stm.setString(1, profesional.getTitulo());
				stm.setDate(2, java.sql.Date.valueOf(profesional.getFechaDeIngreso()));
				stm.setInt(3, usuarioId);
				stm.executeUpdate();
				System.out.println("Insert para crear nuevo profesional ok");
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
	public boolean update(ProfesionalDTO profesional) {
		boolean isOkQuery = false;

		try {
			String sql = "update usuario set nick=?, password1=?, nombres=?, apellidos=?, fecha_de_nacimiento=? where rut=?";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, profesional.getNick());
			stm.setString(2, profesional.getPassword1());
			stm.setString(3, profesional.getNombres());
			stm.setString(4, profesional.getApellidos());
			stm.setDate(5, java.sql.Date.valueOf(profesional.getFechaDeNacimiento()));
			stm.setString(6, profesional.getRut());
			stm.executeUpdate();

			sql = "select usuario_id from usuario where rut=?";
			stm = conexion.prepareStatement(sql);
			stm.setString(1, profesional.getRut());
			ResultSet rs = stm.executeQuery();
			int usuarioId = -1;
			if (rs.next()) {
				usuarioId = rs.getInt("usuario_id");
				sql = "update profesional set titulo=?, fecha_de_ingreso=? where usuario_id=?";
				stm = conexion.prepareStatement(sql);
				stm.setString(1, profesional.getTitulo());
				stm.setDate(2, java.sql.Date.valueOf(profesional.getFechaDeIngreso()));
				stm.setInt(3, usuarioId);
				stm.executeUpdate();
				System.out.println("Update de profesional ok");
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
