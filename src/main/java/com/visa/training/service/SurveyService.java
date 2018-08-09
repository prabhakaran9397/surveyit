package com.visa.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.dal.SurveyDao;
import com.visa.training.domain.Survey;
import com.visa.training.domain.User;

@Service
@Transactional
public class SurveyService {
	
	@Autowired
	SurveyDao dao;
	
	@Autowired
	UserService userService;

	public Survey create(Survey s) {
		return dao.create(s);
	}
	
	public Survey create(Survey s, User u) {
		u = userService.findById(u.getId());
		dao.create(s);
		s.setUser(u);
		return s;
	}

	public Survey findById(int id) {
		return dao.findById(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}
	
	
}
