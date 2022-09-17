package com.digitalers.PracticaBD.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.digitalers.PracticaBD.entidades.Prestamo;
import com.digitalers.PracticaBD.excepciones.DAOExcepcion;
import com.digitalers.PracticaBD.excepciones.JDBCExcepcion;

public class PrestamoDAOImpl extends GenericDAOImpl<Prestamo, Integer> {

	public PrestamoDAOImpl(Connection conexion) throws JDBCExcepcion {
		super(conexion);
	}

	//--------------------------------------------------------------------
	
	//LISTAR PRESTAMOS
	@Override
	public List<Prestamo> listar() throws DAOExcepcion {
		
		List<Prestamo> prestamos = new ArrayList<>();
		String query = "SELECT * FROM PRESTAMOS";
		
		try {
			if(psListar == null)
				psListar = conexion.prepareStatement(query);
			
			ResultSet rs = psListar.executeQuery();
			
			while(rs.next()) {
				
				Prestamo prestamo = Prestamo.builder()
									  .nroPrestamo(rs.getInt("nro_prestamo"))
									  .tipoPrestamo(rs.getString("tipo_prestamo"))
									  .fechaExpedicion(rs.getDate("fecha_expedicion").toLocalDate())
									  .cantCuotas(rs.getInt("cant_cuotas"))
									  .cancelado(rs.getBoolean("cancelado"))
									  .build();
				
				prestamos.add(prestamo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prestamos;
		
	}

	//--------------------------------------------------------------------
	
	//OBTENER PRESTAMO POR CLAVE
	@Override
	public Prestamo obtenerPorClave(Integer clave) throws DAOExcepcion {
		
		Prestamo prestamo = null;
		
		String query = "SELECT * FROM PRESTAMOS WHERE NRO_PRESTAMO = ?";
		
		try {
			if(psObtenerPorClave == null)
				psObtenerPorClave = conexion.prepareStatement(query);
			
			psObtenerPorClave.setInt(1, clave);
			
			ResultSet rs = psObtenerPorClave.executeQuery();
			
			while(rs.next()) {
				prestamo = Prestamo.builder()
							   .nroPrestamo(rs.getInt("nro_prestamo"))
							   .tipoPrestamo(rs.getString("tipo_prestamo"))
							   .fechaExpedicion(rs.getDate("fecha_expedicion").toLocalDate())
							   .cantCuotas(rs.getInt("cant_cuotas"))
							   .cancelado(rs.getBoolean("cancelado"))
							   .build();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prestamo;
	}

	//--------------------------------------------------------------------
	
	//ELIMINAR PRESTAMO POR CLAVE
	@Override
	public boolean eliminar(Integer clave) throws DAOExcepcion {
		
		String query = "DELETE FROM PRESTAMOS WHERE NRO_PRESTAMO = ?";
		
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
	
	//INSERTAR NUEVO PRESTAMO
	@Override
	public boolean insertar(Prestamo prestamo) throws DAOExcepcion {
		
		String query = "INSERT INTO PRESTAMOS(TIPO_PRESTAMO,FECHA_EXPEDICION,CANT_CUOTAS,CANCELADO) " +
				"VALUES(?,?,?,?)";

		try {
			if(psInsertar == null)
				psInsertar = conexion.prepareStatement(query);
			
			psInsertar.setString(1, prestamo.getTipoPrestamo());
			psInsertar.setDate(2, Date.valueOf(prestamo.getFechaExpedicion()));
			psInsertar.setInt(3, prestamo.getCantCuotas());
			psInsertar.setBoolean(4, prestamo.getCancelado());
			
			return psInsertar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	//--------------------------------------------------------------------
	
	//ACTUALIZAR PRESTAMO POR CLAVE
	@Override
	public boolean actualizar(Prestamo prestamo) throws DAOExcepcion {
		
		String query = "UPDATE PRESTAMOS SET TIPO_PRESTAMO=?, CANT_CUOTAS=?, CANCELADO=? WHERE NRO_PRESTAMO=?";

		try {
			if(psActualizar == null)
				psActualizar = conexion.prepareStatement(query);
			
			psActualizar.setString(1, prestamo.getTipoPrestamo());
			psActualizar.setBoolean(2, prestamo.getCancelado());
			psActualizar.setInt(3, prestamo.getCantCuotas());
			psActualizar.setInt(4, prestamo.getNroPrestamo());
			
			return psActualizar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}
