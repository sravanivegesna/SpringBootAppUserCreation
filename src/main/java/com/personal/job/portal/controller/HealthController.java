package com.personal.job.portal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.job.portal.bean.ApiResponse;
import com.personal.job.portal.bean.ApiResponseStatus;

@RestController
public class HealthController {

	@GetMapping("/")
	public ApiResponse checkHealth() {
		return new ApiResponse(ApiResponseStatus.SUCCESS, null, "server is running");
	}
	
}
