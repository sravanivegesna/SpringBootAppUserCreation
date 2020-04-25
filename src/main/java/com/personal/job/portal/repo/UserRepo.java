package com.personal.job.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.job.portal.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
}
