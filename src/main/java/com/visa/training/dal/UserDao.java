package com.visa.training.dal;

import com.visa.training.domain.User;

public interface UserDao {

	User create(User u);
	
	void delete(int id);

	User findById(int id);
	
	User findByUsername(String username);
	
}
