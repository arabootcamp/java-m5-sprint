package com.empresaprevencionriesgos.model.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	private static Connection conexion;

	private Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresaprevencionriesgos", "root",
					"hr971322444ATiw@#");
			System.out.println("CONEXION A BD EXISTE");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONEXION A BD NO EXISTE");
		}
	}

	public static Connection getInstance() {
		if (conexion == null) {
			new Conexion();
		}
		return conexion;
	}
}
