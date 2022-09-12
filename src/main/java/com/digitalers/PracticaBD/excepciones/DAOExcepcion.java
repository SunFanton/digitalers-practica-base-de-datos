package com.digitalers.PracticaBD.excepciones;

public class DAOExcepcion extends Exception {

	private static final long serialVersionUID = -4388397196084316144L;

	public DAOExcepcion() {
		super();
	}

	public DAOExcepcion(String message) {
		super(message);
	}

}
