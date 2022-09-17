package com.digitalers.PracticaBD.pruebas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.digitalers.PracticaBD.entidades.Prestamo;
import com.digitalers.PracticaBD.excepciones.DAOExcepcion;
import com.digitalers.PracticaBD.excepciones.JDBCExcepcion;
import com.digitalers.PracticaBD.jdbc.conexiones.MariaDB;
import com.digitalers.PracticaBD.jdbc.dao.impl.PrestamoDAOImpl;

public class GestionPrestamos {

	private static PrestamoDAOImpl prestamoDAOImpl = null;
	
	public static void gestionaPrestamos() {

		Logger miLogger = LogManager.getLogger();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		try {
			if(prestamoDAOImpl == null)
				prestamoDAOImpl = new PrestamoDAOImpl(MariaDB.getMariaDB().getConexion());
			
		} catch (JDBCExcepcion e) {
			miLogger.error("Error de conexion",e);
		}
		
		//-------------------------------------------------------------------
		
		System.out.println("----------LISTA PRESTAMOS----------\n");
		List<Prestamo> prestamos = new ArrayList<>();
		try {
			prestamos = prestamoDAOImpl.listar();
			miLogger.info("Recuperando datos");
			
			for (Prestamo prestamo : prestamos) {
				System.out.println(prestamo);
			}
			
		} catch (DAOExcepcion e) {
			miLogger.error("Error al recuperar datos",e);
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------OBTENER PRESTAMO POR CLAVE----------\n");
		Prestamo prestamo = null;
		System.out.println("Ingrese nro de prestamo a buscar: ");
		int nroPrestamo = in.nextInt();
		try {
			prestamo = prestamoDAOImpl.obtenerPorClave(nroPrestamo);
			if(prestamo != null) {
				System.out.println(prestamo);
				miLogger.info("Prestamo con nro " + nroPrestamo + " recuperado");
			}
			else {
				System.out.println("No existe");
			}
		} catch (DAOExcepcion e) {
			miLogger.error("Error al recuperar prestamo",e);
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------ELIMINAR PRESTAMO POR CLAVE----------\n");
		System.out.println("Ingrese nro de prestamo a eliminar: ");
		nroPrestamo = in.nextInt();
		boolean resultado;
		try {
			resultado = prestamoDAOImpl.eliminar(nroPrestamo);
			
			if(resultado){
				System.out.println("Eliminado");
				miLogger.info("Prestamo nro " + nroPrestamo + " eliminado");
			}
			else {
				System.out.println("No eliminado");
			}
			
		} catch (DAOExcepcion e) {
			miLogger.error("Error al eliminar prestamo",e);
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------INSERTAR NUEVO PRESTAMO----------\n");
		System.out.println("Ingrese tipo de prestamo: ");
		in.nextLine();
		String tipoPrestamo = in.nextLine();
		System.out.println("Ingrese nro de cuotas: ");
		int cuotas = in.nextInt();
		System.out.println("Ingrese cancelado o no (true o false): ");
		Boolean cancelado = in.nextBoolean();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fecha = LocalDate.now().format(formatter);
		LocalDate fechaExpedicion = LocalDate.parse(fecha);
		
		Prestamo prestamoNuevo = Prestamo.builder()
										 .tipoPrestamo(tipoPrestamo)
										 .fechaExpedicion(fechaExpedicion)
										 .cantCuotas(cuotas)
										 .cancelado(cancelado)
										 .build();
		
		try {
			resultado = prestamoDAOImpl.insertar(prestamoNuevo);
			
			if(resultado){
				System.out.println("Insertado");
				miLogger.info("Prestamo nuevo insertado");
			}
			else {
				System.out.println("No insertado");
			}
			
		} catch (DAOExcepcion e) {
			miLogger.error("Error al insertar prestamo",e);
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
	
		System.out.println("----------ACTUALIZAR PRESTAMO----------\n");
		System.out.println("Ingrese nro de prestamo a actualizar: ");
		int nroPrestamoAct = in.nextInt();
		System.out.println("Ingrese tipo de prestamo: ");
		in.nextLine();
		String tipoPrestamoAct = in.nextLine();
		System.out.println("Ingrese nro de cuotas: ");
		int cuotasAct = in.nextInt();
		System.out.println("Ingrese cancelado o no (true o false): ");
		Boolean canceladoAct = in.nextBoolean();
		
		Prestamo prestamoActualizado = Prestamo.builder()
											   .nroPrestamo(nroPrestamoAct)
											   .tipoPrestamo(tipoPrestamoAct)
											   .cantCuotas(cuotasAct)
											   .cancelado(canceladoAct)
											   .build();
											   
		
		try {
			resultado = prestamoDAOImpl.actualizar(prestamoActualizado);
			
			if(resultado){
				System.out.println("Actualizado");
				miLogger.info("Prestamo nro " + nroPrestamoAct + " actualizado");
			}
			else {
				System.out.println("No actualizado");
			}
			
		} catch (DAOExcepcion e) {
			miLogger.error("Error al actualizar prestamo",e);
		}
		
	
	}
	
}
