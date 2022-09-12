package com.digitalers.PracticaBD.excepciones;

public class JDBCExcepcion extends Exception {

	private static final long serialVersionUID = 4258074548509832064L;

	public JDBCExcepcion() {
		super();
	}

	public JDBCExcepcion(String message) {
		super(message);
	}

}
