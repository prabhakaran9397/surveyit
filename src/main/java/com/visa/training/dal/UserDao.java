package com.visa.training.dal;

import java.util.List;

import com.visa.training.domain.User;

public interface UserDao {

	User create(User u);
	
	void delete(int id);

	User findById(int id);
	
	User findByUsername(String username);
	
	List<User> findAll();
	
}
