package com.digitalers.PracticaBD.principal;

import java.util.ArrayList;
import java.util.List;

import com.digitalers.PracticaBD.entidades.Cliente;
import com.digitalers.PracticaBD.excepciones.DAOExcepcion;
import com.digitalers.PracticaBD.excepciones.JDBCExcepcion;
import com.digitalers.PracticaBD.jdbc.conexiones.MariaDB;
import com.digitalers.PracticaBD.jdbc.dao.impl.ClienteDAOImpl;

public class AppCliente {

	public static void main(String[] args) {
		
		ClienteDAOImpl clienteDAOImpl = null;
		
		try {
			clienteDAOImpl = new ClienteDAOImpl(MariaDB.getMariaDB().getConexion());
			
		} catch (JDBCExcepcion e) {
			e.printStackTrace();
		}
		
		System.out.println("----------LISTA CLIENTES----------");
		System.out.println();
		List<Cliente> clientes = new ArrayList<>();
		try {
			clientes = clienteDAOImpl.listar();
		} catch (DAOExcepcion e) {
			e = new DAOExcepcion("Error al listar");
			e.printStackTrace();
		}
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
		
		System.out.println();
		
		System.out.println("----------OBTENER CLIENTE POR CLAVE----------");
		System.out.println();
		Cliente cliente = null;
		try {
			cliente = clienteDAOImpl.obtenerPorClave(2);
			System.out.println(cliente);
		} catch (DAOExcepcion e) {
			e = new DAOExcepcion("Error al obtener por clave");
			e.printStackTrace();
		}
		
		System.out.println();
		
		System.out.println("----------ELIMINAR CLIENTE POR CLAVE----------");
		System.out.println();
		boolean resultado;
		/*try {
			resultado = clienteDAOImpl.eliminar(4);
			System.out.println(resultado ? "Eliminado" : "No eliminado");
		} catch (DAOExcepcion e) {
			e = new DAOExcepcion("Error al eliminar");
			e.printStackTrace();
		}*/
		
		System.out.println();
		
		System.out.println("----------INSERTAR NUEVO CLIENTE----------");
		System.out.println();
		
		Cliente clienteNuevo = Cliente.builder()
								 .nombre("Rosalia Graciela Murcia")
								 .calle("Avenida del Corral 123")
								 .ciudad("Villa Devoto")
								 .prestamo(false)
								 .idEmpleado(20)
								 .build();
		
		/*try {
			resultado = clienteDAOImpl.insertar(clienteNuevo);
			System.out.println(resultado ? "Insertado" : "No insertado");
		} catch (DAOExcepcion e) {
			e = new DAOExcepcion("Error al insertar");
			e.printStackTrace();
		}*/
		
		System.out.println();

		System.out.println("----------ACTUALIZAR CLIENTE----------");
		System.out.println();
		
		Cliente clienteActualizado = Cliente.builder()
											.id(27)
								 			.nombre("Rosalia Mariana Murcia")
								 			.calle("Avenida del Corral 124")
								 			.ciudad("Villa Devoto")
								 			.prestamo(true)
								 			.idEmpleado(20)
								 			.build();
		
		/*try {
			resultado = clienteDAOImpl.actualizar(clienteActualizado);
			System.out.println(resultado ? "Actualizado" : "No actualizado");
		} catch (DAOExcepcion e) {
			e = new DAOExcepcion("Error al actualizar");
			e.printStackTrace();
		}*/
	}

}
