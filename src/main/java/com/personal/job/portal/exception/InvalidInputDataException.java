package com.personal.job.portal.exception;

public class InvalidInputDataException  extends Exception{

	private static final long serialVersionUID = 5029130073815840890L;
	
	public InvalidInputDataException() {
		super();
	}

	public InvalidInputDataException(String message) {
		super(message);
	}

	public InvalidInputDataException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
