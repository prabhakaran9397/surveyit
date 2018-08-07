package com.visa.training.dal;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.User;

@Repository
@Transactional
public interface UserDao {

	User create(User u);
	
	void delete(int id);

	User findById(int id);
	
}
