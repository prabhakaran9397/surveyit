package com.visa.training.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.Question;
import com.visa.training.domain.QuestionChoice;

@Repository
@Transactional
public class MysqlQuestionChoiceDao implements QuestionChoiceDao {

	@Autowired
	EntityManager em;
	@Override
	public QuestionChoice create(QuestionChoice questionChoice) {
		em.persist(questionChoice);
		return questionChoice;
	}

	@Override
	public void delete(int id) {
		QuestionChoice questionChoice=em.find(QuestionChoice.class, id);
		em.remove(questionChoice);
		
	}

	@Override
	public QuestionChoice findById(int id) {
		return em.find(QuestionChoice.class, id);
	}

	@Override
	public List<QuestionChoice> findAllBySurvey(Question q) {
		return (List<QuestionChoice>) em.createQuery("SELECT qc FROM QuestionChoice qc WHERE qc.question.id = " + q.getId()).getResultList();

	}
  
}
		