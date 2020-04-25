package com.personal.job.portal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.job.portal.domain.User;
import com.personal.job.portal.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public void save(User user) {
		userRepo.save(user);
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	public Optional<User> getUserById(long userId) {
		// TODO Auto-generated method stub
		return userRepo.findById(userId);
	}

	public void deleteById(long userid) {
		// TODO Auto-generated method stub
		userRepo.deleteById(userid);
	}

}
