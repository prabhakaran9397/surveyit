package com.visa.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.dal.QuestionChoiceDao;
import com.visa.training.domain.QuestionChoice;


@Service
@Transactional
public class QuestionChoiceService {
  @Autowired
  QuestionChoiceDao dao;

public QuestionChoice create(QuestionChoice questionChoice) {
	return dao.create(questionChoice);
}

public void delete(int id) {
	dao.delete(id);
}

public QuestionChoice findById(int id) {
	return dao.findById(id);
}
  
}
