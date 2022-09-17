package com.digitalers.PracticaBD.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.digitalers.PracticaBD.entidades.Empleado;
import com.digitalers.PracticaBD.excepciones.DAOExcepcion;
import com.digitalers.PracticaBD.excepciones.JDBCExcepcion;
import com.digitalers.PracticaBD.jdbc.conexiones.MariaDB;
import com.digitalers.PracticaBD.jdbc.dao.impl.EmpleadoDAOImpl;

public class GestionEmpleados {

	private static EmpleadoDAOImpl empleadoDAOImpl = null;
	
	public static void gestionaEmpleados() {

		Logger miLogger = LogManager.getLogger();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		try {
			if(empleadoDAOImpl == null)
				empleadoDAOImpl = new EmpleadoDAOImpl(MariaDB.getMariaDB().getConexion());
			
		} catch (JDBCExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error de conexion");
		}
		
		//-------------------------------------------------------------------
		
		System.out.println("----------LISTA EMPLEADOS----------\n");
		List<Empleado> empleados = new ArrayList<>();
		try {
			empleados = empleadoDAOImpl.listar();
			miLogger.info("Recuperando datos");
			
			for (Empleado empleado : empleados) {
				System.out.println(empleado);
			}
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al recuperar datos");
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------OBTENER EMPLEADO POR CLAVE----------\n");
		Empleado empleado = null;
		System.out.println("Ingrese id del empleado a buscar: ");
		int id = in.nextInt();
		try {
			empleado = empleadoDAOImpl.obtenerPorClave(id);
			System.out.println(empleado);
			miLogger.info("Empleado con id " + id + " recuperado");
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al recuperar empleado");
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------ELIMINAR EMPELADO POR CLAVE----------\n");
		System.out.println("Ingrese id del empleado a eliminar: ");
		id = in.nextInt();
		boolean resultado;
		try {
			resultado = empleadoDAOImpl.eliminar(id);
			
			if(resultado){
				System.out.println("Eliminado");
				miLogger.info("Empleado con id " + id + " eliminado");
			}
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al eliminar empleado");
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------INSERTAR NUEVO EMPLEADO----------\n");
		System.out.println("Ingrese nombre nuevo empleado: ");
		in.nextLine();
		String nombre = in.nextLine();
		System.out.println("Ingrese telefono: ");
		String telefono = in.nextLine();
		System.out.println("Ingrese id jefe: ");
		int idJefe = in.nextInt();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fecha = LocalDate.now().format(formatter);
		LocalDate fechaIncorp = LocalDate.parse(fecha);
		
		Empleado empleadoNuevo = Empleado.builder()
										 .nombre(nombre)
										 .telefono(telefono)
										 .idJefe(idJefe)
										 .fechaIncorp(fechaIncorp)
										 .build();
								 	  
		
		try {
			resultado = empleadoDAOImpl.insertar(empleadoNuevo);
			
			if(resultado){
				System.out.println("Insertado");
				miLogger.info("Empelado nuevo insertado");
			}
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al insertar empleado");
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
	
		System.out.println("----------ACTUALIZAR EMPLEADO----------\n");
		System.out.println("Ingrese id del empleado a actualizar: ");
		int idAct = in.nextInt();
		System.out.println("Ingrese nombre nuevo empleado: ");
		in.nextLine();
		String nombreAct = in.nextLine();
		System.out.println("Ingrese telefono: ");
		String telefonoAct = in.nextLine();
		System.out.println("Ingrese id jefe: ");
		int idJefeAct = in.nextInt();
		String fechaAct = LocalDate.now().format(formatter);
		LocalDate fechaIncorpAct = LocalDate.parse(fechaAct);
		
		Empleado empleadoActualizado = Empleado.builder()
											   .id(idAct)
										 	   .nombre(nombreAct)
										       .telefono(telefonoAct)
										       .idJefe(idJefeAct)
										       .fechaIncorp(fechaIncorpAct)
										       .build();
		
		try {
			resultado = empleadoDAOImpl.actualizar(empleadoActualizado);
			
			if(resultado){
				System.out.println("Actualizado");
				miLogger.info("Empleado con id " + idAct + " actualizado");
			}
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al actualizar empleado");
		}
		
	
	}
	
}
