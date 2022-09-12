package com.digitalers.PracticaBD.entidades;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString
public class Cliente {
	
	private Integer id;
	private String nombre;
	private String calle;
	private String ciudad;
	private Boolean prestamo;
	private Integer idEmpleado;
	

	//Constructor sin parametros
	public Cliente() {
		super();
	}
	
	//Constructor sin id
	public Cliente(String nombre, String calle, String ciudad, Boolean prestamo, Integer idEmpleado) {
		super();
		this.nombre = nombre;
		this.calle = calle;
		this.ciudad = ciudad;
		this.prestamo = prestamo;
		this.idEmpleado = idEmpleado;
	}

	//Constructor con todos los parametros
	public Cliente(Integer id, String nombre, String calle, String ciudad, Boolean prestamo, Integer idEmpleado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.calle = calle;
		this.ciudad = ciudad;
		this.prestamo = prestamo;
		this.idEmpleado = idEmpleado;
	}	
	
}
