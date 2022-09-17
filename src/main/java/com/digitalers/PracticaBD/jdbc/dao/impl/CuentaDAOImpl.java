package com.digitalers.PracticaBD.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.digitalers.PracticaBD.entidades.Cuenta;
import com.digitalers.PracticaBD.excepciones.DAOExcepcion;
import com.digitalers.PracticaBD.excepciones.JDBCExcepcion;

public class CuentaDAOImpl extends GenericDAOImpl<Cuenta,Integer> {

	public CuentaDAOImpl(Connection conexion) throws JDBCExcepcion {
		super(conexion);
	}

	//--------------------------------------------------------------------
	
	//LISTAR CUENTAS
	@Override
	public List<Cuenta> listar() throws DAOExcepcion {
		
		List<Cuenta> cuentas = new ArrayList<>();
		String query = "SELECT * FROM CUENTAS";
		
		try {
			if(psListar == null)
				psListar = conexion.prepareStatement(query);
			
			ResultSet rs = psListar.executeQuery();
			
			while(rs.next()) {
				
				Cuenta cuenta = Cuenta.builder()
									  .nroCuenta(rs.getInt("nro_cuenta"))
									  .tipoCuenta(rs.getString("tipo_cuenta"))
									  .fechaCreacion(rs.getDate("fecha_creacion").toLocalDate())
									  .activa(rs.getBoolean("activa"))
									  .build();
				
				cuentas.add(cuenta);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cuentas;
		
	}

	//--------------------------------------------------------------------
	
	//OBTENER CUENTA POR CLAVE
	@Override
	public Cuenta obtenerPorClave(Integer clave) throws DAOExcepcion {
		
		Cuenta cuenta = null;
		
		String query = "SELECT * FROM CUENTAS WHERE NRO_CUENTA = ?";
		
		try {
			if(psObtenerPorClave == null)
				psObtenerPorClave = conexion.prepareStatement(query);
			
			psObtenerPorClave.setInt(1, clave);
			
			ResultSet rs = psObtenerPorClave.executeQuery();
			
			while(rs.next()) {
				cuenta = Cuenta.builder()
							   .nroCuenta(rs.getInt("nro_cuenta"))
							   .tipoCuenta(rs.getString("tipo_cuenta"))
							   .fechaCreacion(rs.getDate("fecha_creacion").toLocalDate())
							   .activa(rs.getBoolean("activa"))
							   .build();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cuenta;
		
	}

	//--------------------------------------------------------------------
	
	//ELIMINAR CUENTA POR CLAVE
	@Override
	public boolean eliminar(Integer clave) throws DAOExcepcion {
		
		String query = "DELETE FROM CUENTAS WHERE NRO_CUENTA = ?";
		
		try {
			if(psEliminar == null)
				psEliminar = conexion.prepareStatement(query);
			
			psEliminar.setInt(1, clave);
			
			return psEliminar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	//--------------------------------------------------------------------
	
	//INSERTAR NUEVA CUENTA
	@Override
	public boolean insertar(Cuenta cuenta) throws DAOExcepcion {
		
		String query = "INSERT INTO CUENTAS(TIPO_CUENTA,FECHA_CREACION,ACTIVA) " +
				"VALUES(?,?,?)";

		try {
			if(psInsertar == null)
				psInsertar = conexion.prepareStatement(query);
			
			psInsertar.setString(1, cuenta.getTipoCuenta());
			psInsertar.setDate(2, Date.valueOf(cuenta.getFechaCreacion()));
			psInsertar.setBoolean(3, cuenta.getActiva());
			
			return psInsertar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	//--------------------------------------------------------------------
	
	//ACTUALIZAR CUENTA POR CLAVE
	@Override
	public boolean actualizar(Cuenta cuenta) throws DAOExcepcion {
		
		String query = "UPDATE CUENTAS SET TIPO_CUENTA=?, ACTIVA=? WHERE NRO_CUENTA=?";

		try {
			if(psActualizar == null)
				psActualizar = conexion.prepareStatement(query);
			
			psActualizar.setString(1, cuenta.getTipoCuenta());
			psActualizar.setBoolean(2, cuenta.getActiva());
			psActualizar.setInt(3, cuenta.getNroCuenta());
			
			return psActualizar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	
	
}
