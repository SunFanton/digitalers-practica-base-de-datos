package com.digitalers.PracticaBD.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.digitalers.PracticaBD.entidades.Cliente;
import com.digitalers.PracticaBD.excepciones.DAOExcepcion;
import com.digitalers.PracticaBD.excepciones.JDBCExcepcion;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente, Integer> {

	public ClienteDAOImpl(Connection conexion) throws JDBCExcepcion {
		super(conexion);
	}

	//--------------------------------------------------------------------
	
	//LISTAR CLIENTES
	@Override
	public List<Cliente> listar() throws DAOExcepcion{
		
		List<Cliente> clientes = new ArrayList<>();
		String query = "SELECT * FROM CLIENTES";
		
		try {
			if(psListar == null)
				psListar = conexion.prepareStatement(query);
			
			ResultSet rs = psListar.executeQuery();
			
			while(rs.next()) {
				
				Cliente cliente = Cliente.builder()
										 .id(rs.getInt("id_cliente"))
										 .nombre(rs.getString("nombre"))
										 .calle(rs.getString("calle"))
										 .ciudad(rs.getString("ciudad"))
										 .prestamo(rs.getBoolean("prestamo"))
										 .idEmpleado(rs.getInt("id_empleado"))
										 .build();
				
				clientes.add(cliente);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clientes;
	}

	//--------------------------------------------------------------------
	
	//OBTENER CLIENTE POR ID
	@Override
	public Cliente obtenerPorClave(Integer clave) throws DAOExcepcion{
		
		Cliente cliente = null;
		
		String query = "SELECT * FROM CLIENTES WHERE ID_CLIENTE = ?";
		
		try {
			if(psObtenerPorClave == null)
				psObtenerPorClave = conexion.prepareStatement(query);
			
			psObtenerPorClave.setInt(1, clave);
			
			ResultSet rs = psObtenerPorClave.executeQuery();
			
			while(rs.next()) {
				
				cliente = Cliente.builder()
						 		 .id(rs.getInt("id_cliente"))
						 		 .nombre(rs.getString("nombre"))
						 		 .calle(rs.getString("calle"))
						 		 .ciudad(rs.getString("ciudad"))
						 		 .prestamo(rs.getBoolean("prestamo"))
						 		 .idEmpleado(rs.getInt("id_empleado"))
						 		 .build();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cliente;
	}

	//--------------------------------------------------------------------
	
	//ELIMINAR CLIENTE
	@Override
	public boolean eliminar(Integer clave) throws DAOExcepcion{
		
		String query = "DELETE FROM CLIENTES WHERE ID_CLIENTE = ?";
		
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
	
	//INSERTAR NUEVO CLIENTE
	@Override
	public boolean insertar(Cliente cliente) throws DAOExcepcion{
		
		String query = "INSERT INTO CLIENTES(NOMBRE,CALLE,CIUDAD,PRESTAMO,ID_EMPLEADO) " +
						"VALUES(?,?,?,?,?)";
		
		try {
			if(psInsertar == null)
				psInsertar = conexion.prepareStatement(query);
			
			psInsertar.setString(1, cliente.getNombre());
			psInsertar.setString(2, cliente.getCalle());
			psInsertar.setString(3, cliente.getCiudad());
			psInsertar.setBoolean(4, cliente.getPrestamo());
			psInsertar.setInt(5, cliente.getIdEmpleado());
			
			return psInsertar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	//--------------------------------------------------------------------
	
	//ACTUALIZAR CLIENTE
	@Override
	public boolean actualizar(Cliente cliente) throws DAOExcepcion{
		
		String query = "UPDATE CLIENTES SET NOMBRE=?, CALLE=?, CIUDAD=?, PRESTAMO=?, ID_EMPLEADO=? WHERE ID_CLIENTE=?";

		try {
			if(psActualizar == null)
				psActualizar = conexion.prepareStatement(query);
			
			psActualizar.setString(1, cliente.getNombre());
			psActualizar.setString(2, cliente.getCalle());
			psActualizar.setString(3, cliente.getCiudad());
			psActualizar.setBoolean(4, cliente.getPrestamo());
			psActualizar.setInt(5, cliente.getIdEmpleado());
			psActualizar.setInt(6, cliente.getId());
			
			return psActualizar.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
