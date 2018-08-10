package com.visa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.dal.QuestionChoiceDao;
import com.visa.training.domain.Question;
import com.visa.training.domain.QuestionChoice;


@Service
@Transactional
public class QuestionChoiceService {
	@Autowired
	QuestionChoiceDao dao;
	
	@Autowired
	QuestionService questionService;

	public QuestionChoice create(QuestionChoice questionChoice) {
		return dao.create(questionChoice);
	}
	
	public QuestionChoice create(QuestionChoice qc, Question q) {
		q = questionService.findById(q.getId());
		qc.setQuestion(q);
		dao.create(qc);
		q.getQuestionChoices().add(qc);
		return qc;
	}
	
	public void delete(int id) {
		dao.delete(id);
	}
	
	public QuestionChoice findById(int id) {
		return dao.findById(id);
	}

	public List<QuestionChoice> findAllByQuestion(Question q) {
		return dao.findAllBySurvey(q);
	}
  
}
