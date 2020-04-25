package com.personal.job.portal.testscenario;

import java.util.ArrayList;
import java.util.List;

import com.personal.job.portal.bean.ApiError;
import com.personal.job.portal.bean.ApiResponse;
import com.personal.job.portal.bean.ApiResponseStatus;

public class TestApiResponseMock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApiError apiError = new ApiError("not found", "user Not found");
		List<ApiError> apiErrorlist = new ArrayList<>();
		apiErrorlist.add(apiError);
		ApiResponse apiResponse = new ApiResponse(ApiResponseStatus.FAILURE, apiErrorlist, null);
		System.out.println("Api Response" + apiResponse.toString());
	}

}
