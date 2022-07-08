package com.empresaprevencionriesgos.model.DAO.inMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import com.empresaprevencionriesgos.model.ClienteDTO;
import com.empresaprevencionriesgos.model.DAO.IClienteDAO;
import com.empresaprevencionriesgos.model.singleton.Conexion;

public class MySQLClienteDAO implements IClienteDAO {

	private Connection conexion;

	public MySQLClienteDAO() {
		conexion = Conexion.getInstance();
	}

	@Override
	public ClienteDTO get(String rut) {
		ClienteDTO cliente = null;
		try {
			String sql = "select * from cliente inner join usuario on cliente.usuario_id=usuario.usuario_id where rut =?";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, rut);
			ResultSet rs = stm.executeQuery();

			// en el null va el LocalDate pero no se el formato
			if (rs.next()) {
				LocalDate fechaDeNacimiento = LocalDate.parse(rs.getString("fecha_de_nacimiento"));
				cliente = new ClienteDTO(rs.getString("nick"), rs.getString("password1"), rs.getString("rut"),
						rs.getString("nombres"), rs.getString("apellidos"), fechaDeNacimiento, rs.getInt("perfil_id"),
						rs.getString("telefono"), rs.getString("email"), rs.getInt("afp_id"),
						rs.getInt("sistema_salud_id"), rs.getString("direccion"), rs.getString("comuna"),
						rs.getString("organizacion"));
				
				System.out.println("Cliente get existe");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return cliente;
	}


	@Override
	public boolean save(ClienteDTO cliente) {
		boolean isOkQuery = false;

		try {
			String sql = "insert into usuario (usuario_id, nick, password1, rut, nombres, apellidos, fecha_de_nacimiento, perfil_id) values (null,?,?,?,?,?,?,?)";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, cliente.getNick());
			stm.setString(2, cliente.getPassword1());
			stm.setString(3, cliente.getRut());
			stm.setString(4, cliente.getNombres());
			stm.setString(5, cliente.getApellidos());
			stm.setDate(6, java.sql.Date.valueOf(cliente.getFechaDeNacimiento()));
			stm.setInt(7, cliente.getPerfilId());
			stm.executeUpdate();

			sql = "select usuario_id from usuario where rut=?";
			stm = conexion.prepareStatement(sql);
			stm.setString(1, cliente.getRut());
			ResultSet rs = stm.executeQuery();
			int usuarioId = -1;
			if (rs.next()) {
				usuarioId = rs.getInt("usuario_id");
				sql = "insert into cliente values (null,?,?,?,?,?,?,?,?)";
				stm = conexion.prepareStatement(sql);
				stm.setString(1, cliente.getTelefono());
				stm.setString(2, cliente.getEmail());
				stm.setInt(3, cliente.getAfpId());
				stm.setInt(4, cliente.getSistemaSaludId());
				stm.setString(5, cliente.getDireccion());
				stm.setString(6, cliente.getComuna());
				stm.setString(7, cliente.getOrganizacion());
				stm.setInt(8, usuarioId);
				stm.executeUpdate();
				System.out.println("Insert para crear nuevo cliente ok");
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
	public boolean update(ClienteDTO cliente) {
		boolean isOkQuery = false;

		try {
			String sql = "update usuario set nick=?, password1=?, nombres=?, apellidos=?, fecha_de_nacimiento=? where rut=?";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, cliente.getNick());
			stm.setString(2, cliente.getPassword1());
			stm.setString(3, cliente.getNombres());
			stm.setString(4, cliente.getApellidos());
			stm.setDate(5, java.sql.Date.valueOf(cliente.getFechaDeNacimiento()));
			stm.setString(6, cliente.getRut());
			stm.executeUpdate();

			sql = "select usuario_id from usuario where rut=?";
			stm = conexion.prepareStatement(sql);
			stm.setString(1, cliente.getRut());
			ResultSet rs = stm.executeQuery();
			int usuarioId = -1;
			if (rs.next()) {
				usuarioId = rs.getInt("usuario_id");
				sql = "update cliente set telefono=?, email=?, afp_id=?, sistema_salud_id=?, direccion=?, comuna=?, organizacion=? where usuario_id=?";
				stm = conexion.prepareStatement(sql);
				stm.setString(1, cliente.getTelefono());
				stm.setString(2, cliente.getEmail());
				stm.setInt(3, cliente.getAfpId());
				stm.setInt(4, cliente.getSistemaSaludId());
				stm.setString(5, cliente.getDireccion());
				stm.setString(6, cliente.getComuna());
				stm.setString(7, cliente.getOrganizacion());
				stm.setInt(8, usuarioId);
				stm.executeUpdate();
				System.out.println("Update de cliente ok");
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
