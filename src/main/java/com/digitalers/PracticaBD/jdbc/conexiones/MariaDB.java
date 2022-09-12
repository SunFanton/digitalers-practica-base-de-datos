package com.digitalers.PracticaBD.jdbc.conexiones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MariaDB {

	private static MariaDB mariaDB;
	private Connection conexion;
	
	private MariaDB() {
		setConexion();
	}

	public static MariaDB getMariaDB() {

		if (mariaDB == null) {
			mariaDB = new MariaDB();
		}

		return mariaDB;
	}

	public Connection getConexion() {
		return conexion;
	}

	private void setConexion() {
		
		Properties propiedades = new Properties();
		try {
			propiedades.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("base_datos.properties"));
			} catch (IOException e) {
			e.printStackTrace();
		}
		String url = propiedades.getProperty("mariadb.url");
		String usuario = propiedades.getProperty("mariadb.user", "root");
		String clave = propiedades.getProperty("mariadb.password");
		String driver = propiedades.getProperty("mariadb.driver");

		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, usuario, clave);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
}
