package com.digitalers.PracticaBD.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.digitalers.PracticaBD.entidades.Sucursal;
import com.digitalers.PracticaBD.excepciones.DAOExcepcion;
import com.digitalers.PracticaBD.excepciones.JDBCExcepcion;

public class SucursalDAOImpl extends GenericDAOImpl<Sucursal, String> {

	public SucursalDAOImpl(Connection conexion) throws JDBCExcepcion {
		super(conexion);
	}

	//--------------------------------------------------------------------
	
	//LISTAR SUCURSALES
	@Override
	public List<Sucursal> listar() throws DAOExcepcion {
		
		List<Sucursal> sucursales = new ArrayList<>();
		String query = "SELECT * FROM SUCURSALES";
		
		try {
			if(psListar == null)
				psListar = conexion.prepareStatement(query);
			
			ResultSet rs = psListar.executeQuery();
			
			while(rs.next()) {
				
				Sucursal sucursal = Sucursal.builder()
											.nombreSucursal(rs.getString("nombre_sucursal"))
											.ciudad(rs.getString("ciudad"))
											.build();
				
				sucursales.add(sucursal);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sucursales;
	}
	
	//--------------------------------------------------------------------
	
	//OBTENER SUCURSAL POR NOMBRE
	@Override
	public Sucursal obtenerPorClave(String nombreSuc) throws DAOExcepcion {
		
		Sucursal sucursal = null;
		
		String query = "SELECT * FROM SUCURSALES WHERE NOMBRE_SUCURSAL = ?";
		
		try {
			if(psObtenerPorClave == null)
				psObtenerPorClave = conexion.prepareStatement(query);
			
			psObtenerPorClave.setString(1, nombreSuc);
			
			ResultSet rs = psObtenerPorClave.executeQuery();
			
			while(rs.next()) {
				
				sucursal = Sucursal.builder()
								   .nombreSucursal(rs.getString("nombre_sucursal"))
								   .ciudad(rs.getString("ciudad"))
								   .build();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sucursal;
	}

	//--------------------------------------------------------------------
	
	//ELIMINAR SUCURSAL
	@Override
	public boolean eliminar(String nombreSuc) throws DAOExcepcion {
		
		String query = "DELETE FROM SUCURSALES WHERE NOMBRE_SUCURSAL = ?";
		
		try {
			if(psEliminar == null)
				psEliminar = conexion.prepareStatement(query);
			
			psEliminar.setString(1, nombreSuc);
			
			return psEliminar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	//--------------------------------------------------------------------
	
	//INSERTAR NUEVA SUCURSAL
	@Override
	public boolean insertar(Sucursal sucursal) throws DAOExcepcion {
		
		String query = "INSERT INTO SUCURSALES(NOMBRE_SUCURSAL,CIUDAD) " +
				"VALUES(?,?)";

		try {
			if(psInsertar == null)
				psInsertar = conexion.prepareStatement(query);
			
			psInsertar.setString(1, sucursal.getNombreSucursal());
			psInsertar.setString(2, sucursal.getCiudad());
			
			return psInsertar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	//--------------------------------------------------------------------
	
	//ACTUALIZAR SUCURSAL
	@Override
	public boolean actualizar(Sucursal sucursal) throws DAOExcepcion {
		
		String query = "UPDATE SUCURSALES SET CIUDAD=? WHERE NOMBRE_SUCURSAL=?";

		try {
			if(psActualizar == null)
				psActualizar = conexion.prepareStatement(query);
			
			psActualizar.setString(1, sucursal.getCiudad());
			psActualizar.setString(2, sucursal.getNombreSucursal());
			
			return psActualizar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
