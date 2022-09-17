package com.digitalers.PracticaBD.entidades;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString
public class Prestamo {

	private Integer nroPrestamo;
	private String tipoPrestamo;
	private LocalDate fechaExpedicion;
	private Integer cantCuotas;
	private Boolean cancelado;
	
	//Constructor por defecto
	public Prestamo() {
		super();
	}

	//Contructor con todos los parametros excepto nroPrestamo
	public Prestamo(String tipoPrestamo, LocalDate fechaExpedicion, Integer cantCuotas, Boolean cancelado) {
		super();
		this.tipoPrestamo = tipoPrestamo;
		this.fechaExpedicion = fechaExpedicion;
		this.cantCuotas = cantCuotas;
		this.cancelado = cancelado;
	}

	//Contructor con todos los parametros excepto fechaExpedicion
	public Prestamo(Integer nroPrestamo, String tipoPrestamo, Integer cantCuotas, Boolean cancelado) {
		super();
		this.nroPrestamo = nroPrestamo;
		this.tipoPrestamo = tipoPrestamo;
		this.cantCuotas = cantCuotas;
		this.cancelado = cancelado;
	}

	//Constructor con todos los parametros
	public Prestamo(Integer nroPrestamo, String tipoPrestamo, LocalDate fechaExpedicion, Integer cantCuotas, Boolean cancelado) {
		super();
		this.nroPrestamo = nroPrestamo;
		this.tipoPrestamo = tipoPrestamo;
		this.fechaExpedicion = fechaExpedicion;
		this.cantCuotas = cantCuotas;
		this.cancelado = cancelado;
	}
}
