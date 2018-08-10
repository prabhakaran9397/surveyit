package com.visa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.dal.QuestionDao;
import com.visa.training.domain.Question;
import com.visa.training.domain.Survey;

@Service
@Transactional
public class QuestionService {
	@Autowired
	QuestionDao dao;
	
	@Autowired
	SurveyService surveyService;

	public Question create(Question question) {
		return dao.create(question);
	}
	
	public Question create(Question q, Survey s) {
		s = surveyService.findById(s.getId());
		q.setSurvey(s);
		dao.create(q);
		s.getQuestions().add(q);
		return q;
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public Question findById(int id) {
		return dao.findById(id);
	}

	public List<Question> findAllBySurvey(Survey s) {
		return dao.findAllBySurvey(s);
		
	}
	
}
