package com.visa.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.dal.AnswerDao;
import com.visa.training.domain.Answer;

@Service
@Transactional
public class AnswerService {
	
	@Autowired
	AnswerDao dao;
	
	
	public Answer create(Answer answer) {
		return dao.create(answer);
	}

	
	public void delete(int id) {
		dao.delete(id);
	}

	
	public Answer findById(int id) {
		return dao.findById(id);
	}
}
