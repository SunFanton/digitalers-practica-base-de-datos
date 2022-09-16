package com.digitalers.PracticaBD.principal;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		int eleccion = 1;
		
		while(eleccion != 0) {
			
			do {
				System.out.println("\n*****OPCIONES PARA GESTIONAR LA BBDD*****");
				System.out.println("1 ---> Gestion Clientes");
				System.out.println("0 ---> Salir");
				eleccion = in.nextInt();
				in.nextLine();
			}while(eleccion<0 || eleccion>2);
			
			switch(eleccion) {
				case 1:
					GestionClientes.gestionaClientes();
					break;
				default:
					System.out.println("Adios!");
					break;
			}
			
			
		}
		
		
	}
	
}
