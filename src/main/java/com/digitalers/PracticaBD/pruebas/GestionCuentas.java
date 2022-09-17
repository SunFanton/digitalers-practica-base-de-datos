package com.digitalers.PracticaBD.pruebas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.digitalers.PracticaBD.entidades.Cuenta;
import com.digitalers.PracticaBD.excepciones.DAOExcepcion;
import com.digitalers.PracticaBD.excepciones.JDBCExcepcion;
import com.digitalers.PracticaBD.jdbc.conexiones.MariaDB;
import com.digitalers.PracticaBD.jdbc.dao.impl.CuentaDAOImpl;

public class GestionCuentas {

	private static CuentaDAOImpl cuentaDAOImpl = null;
	
	public static void gestionaCuentas() {

		Logger miLogger = LogManager.getLogger();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		try {
			if(cuentaDAOImpl == null)
				cuentaDAOImpl = new CuentaDAOImpl(MariaDB.getMariaDB().getConexion());
			
		} catch (JDBCExcepcion e) {
			miLogger.error("Error de conexion",e);
		}
		
		//-------------------------------------------------------------------
		
		System.out.println("----------LISTA CUENTAS----------\n");
		List<Cuenta> cuentas = new ArrayList<>();
		try {
			cuentas = cuentaDAOImpl.listar();
			miLogger.info("Recuperando datos");
			
			for (Cuenta cuenta : cuentas) {
				System.out.println(cuenta);
			}
			
		} catch (DAOExcepcion e) {
			miLogger.error("Error al recuperar datos",e);
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------OBTENER CUENTA POR CLAVE----------\n");
		Cuenta cuenta = null;
		System.out.println("Ingrese nro de cuenta a buscar: ");
		int nroCuenta = in.nextInt();
		try {
			cuenta = cuentaDAOImpl.obtenerPorClave(nroCuenta);
			if(cuenta != null) {
				System.out.println(cuenta);
				miLogger.info("Cuenta con nro " + nroCuenta + " recuperada");
			}
			else {
				System.out.println("No existe");
			}
		} catch (DAOExcepcion e) {
			miLogger.error("Error al recuperar cuenta",e);
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------ELIMINAR CUENTA POR CLAVE----------\n");
		System.out.println("Ingrese nro de cuenta a eliminar: ");
		nroCuenta = in.nextInt();
		boolean resultado;
		try {
			resultado = cuentaDAOImpl.eliminar(nroCuenta);
			
			if(resultado){
				System.out.println("Eliminada");
				miLogger.info("Cuenta nro " + nroCuenta + " eliminada");
			}
			else {
				System.out.println("No eliminada");
			}
			
		} catch (DAOExcepcion e) {
			miLogger.error("Error al eliminar cuenta",e);
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------INSERTAR NUEVA CUENTA----------\n");
		System.out.println("Ingrese tipo de cuenta: ");
		in.nextLine();
		String tipoCuenta = in.nextLine();
		System.out.println("Ingrese activa o no (true o false): ");
		Boolean activa = in.nextBoolean();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fecha = LocalDate.now().format(formatter);
		LocalDate fechaCreacion = LocalDate.parse(fecha);
		
		Cuenta cuentaNueva = Cuenta.builder()
								   .tipoCuenta(tipoCuenta)
								   .fechaCreacion(fechaCreacion)
								   .activa(activa)
								   .build();
		
		try {
			resultado = cuentaDAOImpl.insertar(cuentaNueva);
			
			if(resultado){
				System.out.println("Insertada");
				miLogger.info("Cuenta nueva insertada");
			}
			else {
				System.out.println("No insertada");
			}
			
		} catch (DAOExcepcion e) {
			miLogger.error("Error al insertar cuenta",e);
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
	
		System.out.println("----------ACTUALIZAR CUENTA----------\n");
		System.out.println("Ingrese nro de cuenta a actualizar: ");
		int nroCuentaAct = in.nextInt();
		System.out.println("Ingrese tipo de cuenta: ");
		in.nextLine();
		String tipoCuentaAct = in.nextLine();
		System.out.println("Ingrese activa o no (true o false): ");
		Boolean activaAct = in.nextBoolean();
		
		Cuenta cuentaActualizada = Cuenta.builder()
									     .nroCuenta(nroCuentaAct)
									     .tipoCuenta(tipoCuentaAct)
									     .activa(activaAct)
									     .build();
		
		try {
			resultado = cuentaDAOImpl.actualizar(cuentaActualizada);
			
			if(resultado){
				System.out.println("Actualizada");
				miLogger.info("Cuenta nro " + nroCuentaAct + " actualizada");
			}
			else {
				System.out.println("No actualizada");
			}
			
		} catch (DAOExcepcion e) {
			miLogger.error("Error al actualizar cuenta",e);
		}
		
	
	}
}
