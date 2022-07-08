package com.empresaprevencionriesgos.model.DAO.inMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.empresaprevencionriesgos.model.ContactoDTO;
import com.empresaprevencionriesgos.model.DAO.IContactoDAO;
import com.empresaprevencionriesgos.model.singleton.Conexion;
import java.sql.Connection;

public class MySQLContactoDAO implements IContactoDAO {

	private Connection conexion;

	public MySQLContactoDAO() {
		conexion = Conexion.getInstance();
	}

	@Override
	public boolean save(ContactoDTO contacto) {
		boolean isOkQuery = false;
		try {
			int clienteId = 0;
			String sql = "select cliente_id from cliente inner join usuario on cliente.usuario_id=usuario.usuario_id where usuario.rut=?";
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setString(1, contacto.getRutCliente());
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				clienteId = rs.getInt("cliente_id");
				sql = "insert into contacto values (null,?,?)";
				stm = conexion.prepareStatement(sql);
				stm.setString(1, contacto.getMensaje());
				stm.setInt(2, clienteId);
				stm.executeUpdate();
				System.out.println("Insert en tabla contacto realizado");
				isOkQuery  = true;
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return isOkQuery;
	}

	@Override
	public List<String> getDataContacto(ContactoDTO contacto) {
		ArrayList<String> listaContacto = new ArrayList<String>();
		try {
		int usuarioId = 0;
		String nombres = "";
		String apellidos = "";
		String email = "";
		String organizacion = "";
		String sql = "select nombres,apellidos,usuario_id from usuario where usuario.rut =?";
		
		PreparedStatement stm = conexion.prepareStatement(sql);
		stm.setString(1,contacto.getRutCliente());
		ResultSet rs = stm.executeQuery();
		
		if(rs.next()) {
			usuarioId = rs.getInt("usuario_id");
			nombres = rs.getString("nombres");
			apellidos = rs.getString("apellidos");
			
			sql = "select email,organizacion from cliente where cliente.usuario_id =?";
			PreparedStatement stment = conexion.prepareStatement(sql);
			stment.setInt(1, usuarioId);
			ResultSet rst = stment.executeQuery();
			
			if(rst.next()) {
				
				email = rst.getString("email");
				organizacion = rst.getString("organizacion");

			}
            
			rst.close();
			
		}
		listaContacto.add(nombres);
		listaContacto.add(apellidos);
		listaContacto.add(email);
		listaContacto.add(organizacion);
		listaContacto.add(contacto.getMensaje());
		
		rs.close();
		
		stm.close();
		
		}catch(Exception e) {
		  System.out.println(e);
		}
		
		return listaContacto;
	}


}
