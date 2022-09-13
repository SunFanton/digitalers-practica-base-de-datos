package com.digitalers.PracticaBD.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.digitalers.PracticaBD.entidades.Cliente;
import com.digitalers.PracticaBD.excepciones.DAOExcepcion;
import com.digitalers.PracticaBD.excepciones.JDBCExcepcion;
import com.digitalers.PracticaBD.jdbc.conexiones.MariaDB;
import com.digitalers.PracticaBD.jdbc.dao.impl.ClienteDAOImpl;

public class GestionClientes {
	
	public static void gestionaClientes() {

		ClienteDAOImpl clienteDAOImpl = null;
		Logger miLogger = LogManager.getLogger();
		Scanner in = new Scanner(System.in);
		
		try {
			clienteDAOImpl = new ClienteDAOImpl(MariaDB.getMariaDB().getConexion());
			
		} catch (JDBCExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error de conexion");
		}
		
		//-------------------------------------------------------------------
		
		System.out.println("----------LISTA CLIENTES----------\n");
		List<Cliente> clientes = new ArrayList<>();
		try {
			clientes = clienteDAOImpl.listar();
			miLogger.info("Recuperando datos");
			
			for (Cliente cliente : clientes) {
				System.out.println(cliente);
			}
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al recuperar datos");
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------OBTENER CLIENTE POR CLAVE----------\n");
		Cliente cliente = null;
		System.out.println("Ingrese id del cliente a buscar: ");
		int id = in.nextInt();
		try {
			cliente = clienteDAOImpl.obtenerPorClave(id);
			System.out.println(cliente);
			miLogger.info("Cliente con id " + id + " recuperado");
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al recuperar cliente");
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------ELIMINAR CLIENTE POR CLAVE----------\n");
		System.out.println("Ingrese id del cliente a eliminar: ");
		id = in.nextInt();
		boolean resultado;
		try {
			resultado = clienteDAOImpl.eliminar(id);
			
			if(resultado){
				System.out.println("Eliminado");
				miLogger.info("Cliente con id " + id + " eliminado");
			}
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al eliminar cliente");
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------INSERTAR NUEVO CLIENTE----------\n");
		System.out.println("Ingrese nombre nuevo cliente: ");
		in.nextLine();
		String nombre = in.nextLine();
		System.out.println("Ingrese calle: ");
		String calle = in.nextLine();
		System.out.println("Ingrese ciudad: ");
		String ciudad = in.nextLine();
		System.out.println("Ingrese true o false para prestamo: ");
		boolean prestamo = in.nextBoolean();
		System.out.println("Ingrese id empleado asociado: ");
		int idEmpleado = in.nextInt();
		
		Cliente clienteNuevo = Cliente.builder()
								 	  .nombre(nombre)
								 	  .calle(calle)
								 	  .ciudad(ciudad)
								 	  .prestamo(prestamo)
								 	  .idEmpleado(idEmpleado)
								 	  .build();
		
		try {
			resultado = clienteDAOImpl.insertar(clienteNuevo);
			
			if(resultado){
				System.out.println("Insertado");
				miLogger.info("Cliente nuevo insertado");
			}
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al insertar cliente");
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
	
		System.out.println("----------ACTUALIZAR CLIENTE----------\n");
		System.out.println("Ingrese id del cliente a actualizar: ");
		int idAct = in.nextInt();
		System.out.println("Ingrese nombre nuevo cliente: ");
		in.nextLine();
		String nombreAct = in.nextLine();
		System.out.println("Ingrese calle: ");
		String calleAct = in.nextLine();
		System.out.println("Ingrese ciudad: ");
		String ciudadAct = in.nextLine();
		System.out.println("Ingrese true o false para prestamo: ");
		boolean prestamoAct = in.nextBoolean();
		System.out.println("Ingrese id empleado asociado: ");
		int idEmpleadoAct = in.nextInt();
		
		Cliente clienteActualizado = Cliente.builder()
											.id(idAct)
								 			.nombre(nombreAct)
								 			.calle(calleAct)
								 			.ciudad(ciudadAct)
								 			.prestamo(prestamoAct)
								 			.idEmpleado(idEmpleadoAct)
								 			.build();
		
		try {
			resultado = clienteDAOImpl.actualizar(clienteActualizado);
			
			if(resultado){
				System.out.println("Actualizado");
				miLogger.info("Cliente con id " + idAct + " actualizado");
			}
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al actualizar cliente");
		}
		
	
	}

}