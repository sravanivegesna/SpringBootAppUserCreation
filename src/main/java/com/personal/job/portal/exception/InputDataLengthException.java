package com.personal.job.portal.exception;

public class InputDataLengthException extends Exception {

	private static final long serialVersionUID = 7972502497138507528L;

	public InputDataLengthException() {
		super();
	}

	public InputDataLengthException(String message) {
		super(message);
	}

	public InputDataLengthException(String message, Throwable cause) {
		super(message, cause);
	}
}
