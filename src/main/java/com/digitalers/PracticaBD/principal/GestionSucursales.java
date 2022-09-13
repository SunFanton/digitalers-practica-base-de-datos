package com.digitalers.PracticaBD.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.digitalers.PracticaBD.entidades.Sucursal;
import com.digitalers.PracticaBD.excepciones.DAOExcepcion;
import com.digitalers.PracticaBD.excepciones.JDBCExcepcion;
import com.digitalers.PracticaBD.jdbc.conexiones.MariaDB;
import com.digitalers.PracticaBD.jdbc.dao.impl.SucursalDAOImpl;

public class GestionSucursales {

	public static void gestionaSucursales() {
		
		SucursalDAOImpl sucursalDAOImpl = null;
		Logger miLogger = LogManager.getLogger();
		Scanner in = new Scanner(System.in);
		
		try {
			sucursalDAOImpl = new SucursalDAOImpl(MariaDB.getMariaDB().getConexion());
			
		} catch (JDBCExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error de conexion");
		}
		
		//-------------------------------------------------------------------
		
		System.out.println("----------LISTA SUCURSALES----------\n");
		List<Sucursal> sucursales = new ArrayList<>();
		try {
			sucursales = sucursalDAOImpl.listar();
			miLogger.info("Recuperando datos");
			
			for (Sucursal sucursal : sucursales) {
				System.out.println(sucursal);
			}
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al recuperar los datos");
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------OBTENER SUCURSAL POR CLAVE----------\n");
		Sucursal sucursal = null;
		System.out.println("Ingrese nombre de la sucursal a buscar: ");
		String nom = in.nextLine();
		try {
			sucursal = sucursalDAOImpl.obtenerPorClave(nom);
			System.out.println(sucursal);
			miLogger.info("Sucursal " + nom + " recuperada");
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al recuperar sucursal");
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------ELIMINAR SUCURSAL POR CLAVE----------\n");
		System.out.println("Ingrese nombre de la sucursal a eliminar: ");
		nom = in.nextLine();
		boolean resultado;
		try {
			resultado = sucursalDAOImpl.eliminar(nom);
			
			if(resultado){
				System.out.println("Eliminada");
				miLogger.info("Sucursal " + nom + " eliminada");
			}
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al eliminar sucursal");
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------
		
		System.out.println("----------INSERTAR NUEVA SUCURSAL----------\n");
		System.out.println("Ingrese nombre nombre nueva sucursal: ");
		String nombre = in.nextLine();
		System.out.println("Ingrese ciudad: ");
		String ciudad = in.nextLine();
		
		Sucursal sucursalNueva = Sucursal.builder()
										 .nombreSucursal(nombre)
										 .ciudad(ciudad)
										 .build();
		
		try {
			resultado = sucursalDAOImpl.insertar(sucursalNueva);
			
			if(resultado){
				System.out.println("Insertada");
				miLogger.info("Sucursal " + nom + " insertada");
			}
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al insertar nueva sucursal");
		}
		
		System.out.println();
		
		//-------------------------------------------------------------------

		System.out.println("----------ACTUALIZAR SUCURSAL----------\n");
		System.out.println("Ingrese nombre de la sucursal a actualizar: ");
		String nomAct = in.nextLine();
		System.out.println("Ingrese ciudad: ");
		String ciudadAct = in.nextLine();
		
		Sucursal sucActualizada = Sucursal.builder()
										  .nombreSucursal(nomAct)
										  .ciudad(ciudadAct)
										  .build();
		
		try {
			resultado = sucursalDAOImpl.actualizar(sucActualizada);
			
			if(resultado){
				System.out.println("Actualizada");
				miLogger.info("Sucursal " + nomAct + " actualizada");
			}
			
		} catch (DAOExcepcion e) {
			e.printStackTrace();
			miLogger.error("Error al actualizar sucursal " + nomAct);
		}
		
	}

}
