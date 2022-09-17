package com.digitalers.PracticaBD.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.digitalers.PracticaBD.entidades.Empleado;
import com.digitalers.PracticaBD.excepciones.DAOExcepcion;
import com.digitalers.PracticaBD.excepciones.JDBCExcepcion;

public class EmpleadoDAOImpl extends GenericDAOImpl<Empleado,Integer> {

	public EmpleadoDAOImpl(Connection conexion) throws JDBCExcepcion {
		super(conexion);
	}

	//--------------------------------------------------------------------
	
	//LISTAR EMPLEADOS
	@Override
	public List<Empleado> listar() throws DAOExcepcion {
		
		List<Empleado> empleados = new ArrayList<>();
		Empleado empleado = null;
		String query = "SELECT * FROM EMPLEADOS";
		
		try {
			if(psListar == null)
				psListar = conexion.prepareStatement(query);
			
			ResultSet rs = psListar.executeQuery();
			
			while(rs.next()) {
				
				empleado = Empleado.builder()
								   .id(rs.getInt("id_empleado"))
								   .nombre(rs.getString("nombre"))
								   .telefono(rs.getString("telefono"))
								   .idJefe(rs.getInt("id_empleado_jefe"))
								   .fechaIncorp(rs.getDate("fecha_incorporacion").toLocalDate())
								   .build();
				
				empleados.add(empleado);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empleados;
	}

	//--------------------------------------------------------------------
	
	//OBTENER EMPLEADO POR CLAVE
	@Override
	public Empleado obtenerPorClave(Integer clave) throws DAOExcepcion {
		
		Empleado empleado = null;
		
		String query = "SELECT * FROM EMPLEADOS WHERE ID_EMPLEADO = ?";
		
		try {
			if(psObtenerPorClave == null)
				psObtenerPorClave = conexion.prepareStatement(query);
			
			psObtenerPorClave.setInt(1, clave);
			
			ResultSet rs = psObtenerPorClave.executeQuery();
			
			while(rs.next()) {
				
				empleado = Empleado.builder()
								   .id(rs.getInt("id_empleado"))
								   .nombre(rs.getString("nombre"))
								   .telefono(rs.getString("telefono"))
								   .idJefe(rs.getInt("id_empleado_jefe"))
								   .fechaIncorp(rs.getDate("fecha_incorporacion").toLocalDate())
								   .build();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empleado;
	}

	//--------------------------------------------------------------------
	
	//ELIMINAR EMPLEADO POR CLAVE
	@Override
	public boolean eliminar(Integer clave) throws DAOExcepcion {
		
		String query = "DELETE FROM EMPLEADOS WHERE ID_EMPLEADO = ?";
		
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
	
	//INSERTAR NUEVO EMPLEADO
	@Override
	public boolean insertar(Empleado empleado) throws DAOExcepcion {
		
		String query = "INSERT INTO EMPLEADOS(NOMBRE,TELEFONO,ID_EMPLEADO_JEFE,FECHA_INCORPORACION) " +
				"VALUES(?,?,?,?)";

		try {
			if(psInsertar == null)
				psInsertar = conexion.prepareStatement(query);
			
			psInsertar.setString(1, empleado.getNombre());
			psInsertar.setString(2, empleado.getTelefono());
			psInsertar.setInt(3, empleado.getIdJefe());
			psInsertar.setDate(4, Date.valueOf(empleado.getFechaIncorp()));
			
			return psInsertar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	//--------------------------------------------------------------------
	
	//ACTUALIZAR EMPLEADO POR CLAVE
	@Override
	public boolean actualizar(Empleado empleado) throws DAOExcepcion {
		
		String query = "UPDATE EMPLEADOS SET NOMBRE=?, TELEFONO=?, ID_EMPLEADO_JEFE=?, FECHA_INCORPORACION=? WHERE ID_EMPLEADO=?";

		try {
			if(psActualizar == null)
				psActualizar = conexion.prepareStatement(query);
			
			psActualizar.setString(1, empleado.getNombre());
			psActualizar.setString(2, empleado.getTelefono());
			psActualizar.setInt(3, empleado.getIdJefe());
			psActualizar.setDate(4, Date.valueOf(empleado.getFechaIncorp()));
			psActualizar.setInt(5, empleado.getId());
			
			return psActualizar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
