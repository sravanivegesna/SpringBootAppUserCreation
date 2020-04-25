package com.personal.job.portal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.job.portal.bean.ApiError;
import com.personal.job.portal.bean.ApiResponse;
import com.personal.job.portal.bean.ApiResponseStatus;
import com.personal.job.portal.domain.User;
import com.personal.job.portal.exception.InputDataLengthException;
import com.personal.job.portal.exception.InvalidInputDataException;
import com.personal.job.portal.service.UserService;
import com.personal.job.portal.util.DateConvertor;

@RestController
@RequestMapping("/users")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@GetMapping(path = "/{userid}")
	public ApiResponse getUser(@PathVariable long userid) {
		Optional<User> user = null;

		try {
			logger.info("Inside single get user method");
			user = userService.getUserById(userid);
			if (user.isPresent() == false) {
				List<ApiError> apiErrorList = new ArrayList<ApiError>();
				apiErrorList.add(new ApiError("User Not Found", "Input info doesn't exists with userid : " + userid));
				return new ApiResponse(ApiResponseStatus.FAILURE, apiErrorList, user);
			}
		} catch (Exception e) {
			logger.error("Unable to retrieve the user by given id : {}", e.getMessage());
			e.printStackTrace();
		}
		return new ApiResponse(ApiResponseStatus.SUCCESS, null, user);
	}

	@GetMapping("/")
	public ApiResponse getUsers() {
		List<User> users = null;
		try {
			logger.info("Inside get user method");
			users = userService.getUsers();
			logger.info("Retrived Users : {}", users);
		} catch (Exception e) {
			logger.error("Unable to retrieve the user list : {}", e.getMessage());
			e.printStackTrace();
		}
		return new ApiResponse(ApiResponseStatus.SUCCESS, null, users);
	}

	@PostMapping("/")
	public ApiResponse saveUser(@RequestBody User user) throws InvalidInputDataException, InputDataLengthException {
		/**
		 * logger.info("input Email"+ user.getEmail()); logger.info("input First Name :
		 * {}" , user.getFirstName()); logger.info("input Last Name : {}" ,
		 * user.getLastName()); logger.info("input Phone Number : {}" ,
		 * user.getPhoneNumber()); logger.info("input Create Date String : {}" ,
		 * user.getCreatedDateString());
		 */
		logger.info("User info : {}", user.toString());
		if (StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getFirstName())
				|| StringUtils.isEmpty(user.getLastName()) || StringUtils.isEmpty(user.getCreatedDateString())
				|| StringUtils.isEmpty(user.getPhoneNumber())) {
			logger.error("Empty fields should not be allowed");
			throw new InvalidInputDataException("Empty fields should not be allowed");
		}
		if (user.getPhoneNumber().length() > 10) {
			logger.error("Input phone number must be equal to ten numbers");
			throw new InputDataLengthException("Input phone number must be equal to ten numbers");
		}
		try {
			// convert string date to Date Object
			user.setCreatedDate(DateConvertor.convertStringToDate(user.getCreatedDateString()));
			userService.save(user);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return new ApiResponse(ApiResponseStatus.SUCCESS, null, "inside save user method");
	}

	@PutMapping("/{userid}")
	public ApiResponse updateUser(@PathVariable long userid, @RequestBody User inputUser) {
		User retrievedUser = null;
		logger.info("user info", inputUser.toString());
		
		try {
			Optional<User> retrievedOptionalUser = userService.getUserById(userid);
			if (retrievedOptionalUser.isPresent() == false) {
				List<ApiError> apiErrorList = new ArrayList<ApiError>();
				apiErrorList.add(new ApiError("User Not Found", "Input info doesn't exists with userid : " + userid));
				return new ApiResponse(ApiResponseStatus.FAILURE, apiErrorList, null);
			} 
			retrievedUser = retrievedOptionalUser.get();
			if(!StringUtils.isEmpty(inputUser.getEmail())) {
				retrievedUser.setEmail(inputUser.getEmail());
			}
			if(!StringUtils.isEmpty(inputUser.getFirstName())) {
				retrievedUser.setFirstName(inputUser.getFirstName());
			}
			if(!StringUtils.isEmpty(inputUser.getLastName())) {
				retrievedUser.setLastName(inputUser.getLastName());
			} 
			if(!StringUtils.isEmpty(inputUser.getPhoneNumber())) {
				retrievedUser.setPhoneNumber(inputUser.getPhoneNumber());
			}
			userService.save(retrievedUser);
		} catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return new ApiResponse(ApiResponseStatus.SUCCESS, null, retrievedUser);
	}
	
	@DeleteMapping("/{userid}")
	public ApiResponse updateUser(@PathVariable long userid) {
		logger.info("user id", userid);
		try {
			Optional<User> retrievedOptionalUser = userService.getUserById(userid);
			if (retrievedOptionalUser.isPresent() == false) {
				List<ApiError> apiErrorList = new ArrayList<ApiError>();
				apiErrorList.add(new ApiError("User Id Not Found", "UserId Not found to delete : " + userid));
				return new ApiResponse(ApiResponseStatus.SUCCESS, apiErrorList, null);
			} 
			userService.deleteById(userid);
		} catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return new ApiResponse(ApiResponseStatus.SUCCESS, null, "Successfully deleted the row");
	}
}
