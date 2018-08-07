package com.visa.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.dal.UserDao;
import com.visa.training.domain.User;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDao dao;

	public User create(User u) {
		return dao.create(u);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public User findById(int id) {
		return dao.findById(id);
	}
	
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}
	
}
