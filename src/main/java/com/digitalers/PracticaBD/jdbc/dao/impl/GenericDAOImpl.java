package com.digitalers.PracticaBD.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.digitalers.PracticaBD.excepciones.JDBCExcepcion;
import com.digitalers.PracticaBD.jdbc.dao.GenericDAO;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T,K>{

	protected PreparedStatement psListar;
	protected PreparedStatement psObtenerPorClave;
	protected PreparedStatement psEliminar;
	protected PreparedStatement psInsertar;
	protected PreparedStatement psActualizar;
	protected Connection conexion;

	public GenericDAOImpl(Connection conexion) throws JDBCExcepcion {
		if (conexion == null) {
			throw new JDBCExcepcion("Necesitas una conexion a BBDD!!!");
		}
		this.conexion = conexion;
	}
}
