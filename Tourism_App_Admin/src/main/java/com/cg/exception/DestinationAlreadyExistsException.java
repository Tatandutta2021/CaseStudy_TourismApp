package com.cg.exception;

public class DestinationAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	//default Constructor
		public DestinationAlreadyExistsException() {
			super();
		}
		
		//Parameterized Constructor
		public DestinationAlreadyExistsException(String message) {
			super(message);
			
		}
}
