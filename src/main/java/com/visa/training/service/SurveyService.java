package com.visa.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.dal.SurveyDao;
import com.visa.training.domain.Survey;

@Service
@Transactional
public class SurveyService {
	
	@Autowired
	SurveyDao dao;

	public Survey create(Survey s) {
		return dao.create(s);
	}

	public Survey findById(int id) {
		return dao.findById(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}
	
	
}
