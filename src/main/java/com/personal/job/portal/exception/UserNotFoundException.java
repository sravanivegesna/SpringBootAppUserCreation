package com.personal.job.portal.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -2512488696159560519L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
