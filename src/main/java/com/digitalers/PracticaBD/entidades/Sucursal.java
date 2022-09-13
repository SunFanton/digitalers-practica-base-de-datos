package com.digitalers.PracticaBD.entidades;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString
public class Sucursal {

	private String nombreSucursal;
	private String ciudad;
	
	//Constructor por defecto
	public Sucursal() {
		super();
	}

	//Constructor con todos los parametros
	public Sucursal(String nombreSucursal, String ciudad) {
		super();
		this.nombreSucursal = nombreSucursal;
		this.ciudad = ciudad;
	}

	//Constructor sin parametro clave
	public Sucursal(String ciudad) {
		super();
		this.ciudad = ciudad;
	}
	
}
