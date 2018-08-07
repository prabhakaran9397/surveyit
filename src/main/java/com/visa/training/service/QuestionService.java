package com.visa.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.dal.QuestionDao;
import com.visa.training.domain.Question;

@Service
@Transactional
public class QuestionService {
	@Autowired
	QuestionDao dao;

	public Question create(Question question) {
		return dao.create(question);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public Question findById(int id) {
		return dao.findById(id);
	}
	
}
