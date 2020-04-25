package com.personal.job.portal.customHandler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.personal.job.portal.bean.ApiError;
import com.personal.job.portal.bean.ApiResponse;
import com.personal.job.portal.bean.ApiResponseStatus;
import com.personal.job.portal.exception.InputDataLengthException;
import com.personal.job.portal.exception.InvalidInputDataException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidInputDataException.class)
	@ResponseBody
	public ApiResponse invalidDataInput(InvalidInputDataException ex, HttpServletResponse response){
		 
		ArrayList<ApiError> errors = new ArrayList<ApiError>();
		errors.add(new ApiError("Bad Request", ex.getMessage()));
		
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ApiResponse(ApiResponseStatus.FAILURE, errors, null);
	}
	
	@ExceptionHandler(InputDataLengthException.class)
	@ResponseBody
	public ApiResponse invalidLengthInput(InputDataLengthException ex, HttpServletResponse response){
		 
		ArrayList<ApiError> errors = new ArrayList<ApiError>();
		errors.add(new ApiError("Bad Request", ex.getMessage()));
		
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ApiResponse(ApiResponseStatus.FAILURE, errors, null);
	}
}