package com.digitalers.PracticaBD.entidades;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString
public class Cuenta {
	
	private Integer nroCuenta;
	private String tipoCuenta;
	private LocalDate fechaCreacion;
	private Boolean activa;
	
	//Contructor por defecto
	public Cuenta() {
		super();
	}

	//Constructor con todos los parametros excepto nroCuenta
	public Cuenta(String tipoCuenta, LocalDate fechaCreacion, Boolean activa) {
		super();
		this.tipoCuenta = tipoCuenta;
		this.fechaCreacion = fechaCreacion;
		this.activa = activa;
	}
	

	//Constructor con todos los parametros exceto fechaCreacion
	public Cuenta(Integer nroCuenta, String tipoCuenta, Boolean activa) {
		super();
		this.nroCuenta = nroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.activa = activa;
	}

	//Constructor con todos los parametros
	public Cuenta(Integer nroCuenta, String tipoCuenta, LocalDate fechaCreacion, Boolean activa) {
		super();
		this.nroCuenta = nroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.fechaCreacion = fechaCreacion;
		this.activa = activa;
	}	
}
