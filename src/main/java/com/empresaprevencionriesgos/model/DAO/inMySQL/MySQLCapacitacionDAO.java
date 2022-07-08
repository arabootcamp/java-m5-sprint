package com.empresaprevencionriesgos.model.DAO.inMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.empresaprevencionriesgos.model.CapacitacionDTO;
import com.empresaprevencionriesgos.model.DAO.ICapacitacionDAO;
import com.empresaprevencionriesgos.model.singleton.Conexion;

public class MySQLCapacitacionDAO implements ICapacitacionDAO {

	private Connection conexion;

	public MySQLCapacitacionDAO() {
		conexion = Conexion.getInstance();
	}

	@Override
	public List<CapacitacionDTO> getAll() {

		List<CapacitacionDTO> lista = new ArrayList<CapacitacionDTO>();

		try {
			String sql = "select identificador, capacitacion.dia_id, hora, lugar,duracion,cantidad_de_asistentes, rut from usuario "
					+ "inner join cliente on usuario.usuario_id=cliente.usuario_id "
					+ "inner join capacitacion on cliente.cliente_id=capacitacion.cliente_id "
					+ "inner join dia on capacitacion.dia_id=dia.dia_id ";
			PreparedStatement stm = conexion.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				lista.add(new CapacitacionDTO(rs.getInt("identificador"), rs.getInt("dia_id"), rs.getString("hora"),
						rs.getString("lugar"), rs.getInt("duracion"), rs.getInt("cantidad_de_asistentes"),
						rs.getString("rut")));
			}

			rs.close();
			stm.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return lista;
	}

	@Override
	public List<CapacitacionDTO> getFilterCliente(String rut) {
		List<CapacitacionDTO> lista = new ArrayList<CapacitacionDTO>();
		System.out.println("aca");
		try {
			String sql = "select identificador, capacitacion.dia_id, hora, lugar,duracion,cantidad_de_asistentes, rut from usuario "
					+ "inner join cliente on usuario.usuario_id=cliente.usuario_id "
					+ "inner join capacitacion on cliente.cliente_id=capacitacion.cliente_id "
					+ "inner join dia on capacitacion.dia_id=dia.dia_id where rut=? ";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, rut);
			ResultSet rs = stm.executeQuery();
			System.out.println("aca2");
			while (rs.next()) {
				lista.add(new CapacitacionDTO(rs.getInt("identificador"), rs.getInt("dia_id"), rs.getString("hora"),
						rs.getString("lugar"), rs.getInt("duracion"), rs.getInt("cantidad_de_asistentes"),
						rs.getString("rut")));
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return lista;

	}

	@Override
	public boolean save(CapacitacionDTO capacitacion) {
		boolean isOkQuery = false;

		try {
			int clienteId = 0;
			String sql = "select cliente_id from cliente inner join usuario on cliente.usuario_id=usuario.usuario_id where usuario.rut=?";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, capacitacion.getRutCliente());
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				clienteId = rs.getInt("cliente_id");
				sql = "insert into capacitacion values (null,?,?,?,?,?,?,?)";
				stm = conexion.prepareStatement(sql);
				stm.setInt(1, (int) capacitacion.getIdentificador());
				stm.setInt(2, capacitacion.getDiaId());
				stm.setString(3, capacitacion.getHora());
				stm.setString(4, capacitacion.getLugar());
				stm.setInt(5, capacitacion.getDuracion());
				stm.setInt(6, capacitacion.getCantidadDeAsistentes());
				stm.setInt(7, clienteId);
				stm.executeUpdate();
				System.out.println("Insert en tabla capacitacion realizado");
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
