package com.digitalers.PracticaBD.entidades;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString
public class Empleado {

	private Integer id;
	private String nombre;
	private String telefono;
	private Integer idJefe;
	private LocalDate fechaIncorp;
	
	//Constructor por dfecto
	public Empleado() {
		super();
	}

	//Contructor todos los parametros excepto id
	public Empleado(String nombre, String telefono, Integer idJefe, LocalDate fechaIncorp) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.idJefe = idJefe;
		this.fechaIncorp = fechaIncorp;
	}

	//Constructor todos los parametros
	public Empleado(Integer id, String nombre, String telefono, Integer idJefe, LocalDate fechaIncorp) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.idJefe = idJefe;
		this.fechaIncorp = fechaIncorp;
	} 
	
}
