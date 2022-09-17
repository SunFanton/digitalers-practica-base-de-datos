package com.digitalers.PracticaBD.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.digitalers.PracticaBD.entidades.Cuenta;
import com.digitalers.PracticaBD.entidades.Cuenta;
import com.digitalers.PracticaBD.excepciones.DAOExcepcion;
import com.digitalers.PracticaBD.excepciones.JDBCExcepcion;
import com.digitalers.PracticaBD.jdbc.conexiones.MariaDB;
import com.digitalers.PracticaBD.jdbc.dao.impl.CuentaDAOImpl;

public class GestionCuentas {

	public static void gestionaCuentas() {

		CuentaDAOImpl cuentaDAOImpl = null;
		Logger miLogger = LogManager.getLogger();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		try {
			if(cuentaDAOImpl == null)
				cuentaDAOImpl = new CuentaDAOImpl(MariaDB.getMariaDB().getConexion());
			
		} catch (JDBCExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error de conexion");
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
			e.printStackTrace();
			miLogger.error("Error al recuperar datos");
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------OBTENER CUENTA POR CLAVE----------\n");
		Cuenta cuenta = null;
		System.out.println("Ingrese nro de cuenta a buscar: ");
		int nroCuenta = in.nextInt();
		try {
			cuenta = cuentaDAOImpl.obtenerPorClave(nroCuenta);
			System.out.println(cuenta);
			miLogger.info("Cuenta con nro " + nroCuenta + " recuperada");
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al recuperar cuenta");
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
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al eliminar cuenta");
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
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al insertar cuenta");
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
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al actualizar cuenta");
		}
		
	
	}
}
