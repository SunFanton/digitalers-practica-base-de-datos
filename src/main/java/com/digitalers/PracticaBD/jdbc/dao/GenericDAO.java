package com.digitalers.PracticaBD.jdbc.dao;

import java.util.List;

import com.digitalers.PracticaBD.excepciones.DAOExcepcion;

public interface GenericDAO<T,K> {

	public List<T> listar() throws DAOExcepcion;
	public T obtenerPorClave(K k) throws DAOExcepcion;
	public boolean eliminar(K k) throws DAOExcepcion;
	public boolean insertar(T t) throws DAOExcepcion;
	public boolean actualizar(T t) throws DAOExcepcion;
	
}
