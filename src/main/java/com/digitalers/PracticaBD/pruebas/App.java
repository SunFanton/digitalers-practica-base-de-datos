package com.digitalers.PracticaBD.pruebas;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
	
		Scanner in = new Scanner(System.in);
		int eleccion = 1;
		
		while(eleccion != 0) {
			
			do {
				System.out.println("\n*****OPCIONES PARA GESTIONAR LA BBDD*****\n");
				System.out.println("1 ---> Gestion Clientes");
				System.out.println("2 ---> Gestion Empleados");
				System.out.println("3 ---> Gestion Cuentas");
				System.out.println("4 ---> Gestion Prestamos");
				System.out.println("0 ---> Salir");
				eleccion = in.nextInt();
				in.nextLine();
			}while(eleccion<0 || eleccion>4);
			
			switch(eleccion) {
				case 1:
					GestionClientes.gestionaClientes();
					break;
				case 2:
					GestionEmpleados.gestionaEmpleados();
					break;
				case 3:
					GestionCuentas.gestionaCuentas();
					break;
				case 4:
					GestionPrestamos.gestionaPrestamos();
					break;
				default:
					System.out.println("Adios!");
					break;
			}
			
			System.out.println("\nGuardando cambios...\n");
			Thread.sleep(3000);
			System.out.println("Listo!!!\n");
			Thread.sleep(1000);
		}
		
		
	}
	
}
