package com.personal.job.portal.customHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import com.personal.job.portal.bean.ApiError;
import com.personal.job.portal.bean.ApiResponseStatus;

@Component
public class ErrorAttribute extends DefaultErrorAttributes  {
	
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		// Let Spring handle the error first, we will modify later :)
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
		
		ArrayList<ApiError> errors = new ArrayList<ApiError>();
		errors.add(new ApiError(errorAttributes.get("error").toString(), errorAttributes.get("message").toString()));

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("status", ApiResponseStatus.FAILURE);
		resMap.put("errors", errors);
		resMap.put("data", null);
		return resMap;
	}
}
