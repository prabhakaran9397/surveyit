package com.visa.training.service;

import java.util.List;

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
		s.setUser(u);
		dao.create(s);
		u.getSurveys().add(s);
		return s;
	}

	public Survey findById(int id) {
		return dao.findById(id);
	}
	
	public List<Survey> findAllByUser(User u) {
		return dao.findAllByUser(u);
	}

	public void delete(int id) {
		dao.delete(id);
	}
	
	public void changeTitle(Survey s, String newTitle)
	{
		s = findById(s.getId());
		s.setTitle(newTitle);
	}
	
	public void changeDescription(Survey s, String newDescription)
	{
		s = findById(s.getId());
		s.setDescription(newDescription);
	}
}
