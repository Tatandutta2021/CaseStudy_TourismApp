package com.cg.exception;

public class DataNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	public DataNotFoundException() {
		super();
	}
	public DataNotFoundException(String message) {
		super(message);
		
	}
}
