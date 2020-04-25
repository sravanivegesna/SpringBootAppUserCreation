package com.personal.job.portal.bean;

import java.util.List;

public class ApiResponse {

	private ApiResponseStatus status;
	private List<ApiError> errors;
	private Object data;

	public ApiResponse(ApiResponseStatus status, List<ApiError> errors, Object data) {
		super();
		this.status = status;
		this.errors = errors;
		this.data = data;
	}

	public ApiResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ApiResponseStatus status) {
		this.status = status;
	}

	public List<ApiError> getErrors() {
		return errors;
	}

	public void setErrors(List<ApiError> errors) {
		this.errors = errors;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ApiResponse [status=" + status + ", errors=" + errors + ", data=" + data + "]";
	}

}
