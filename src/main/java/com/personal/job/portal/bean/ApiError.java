package com.personal.job.portal.bean;

public class ApiError {

	private String code;
	private String message;

	public ApiError(String status, String error) {
		// TODO Auto-generated constructor stub
		super();
		this.code = status;
		this.message = error;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ApiError [code=" + code + ", message=" + message + "]";
	}

}
