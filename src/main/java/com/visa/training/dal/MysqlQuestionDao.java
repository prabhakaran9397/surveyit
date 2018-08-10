package com.visa.training.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.Question;
import com.visa.training.domain.Survey;
import com.visa.training.domain.UserSurvey;

@Repository
@Transactional
public class MysqlQuestionDao implements QuestionDao {
	
	@Autowired
	EntityManager em;

	@Override
	public Question create(Question question) {
		em.persist(question);
		return question;
	}

	@Override
	public void delete(int id) {
		Question q=em.find(Question.class, id);
		em.remove(q);
		
	}

	@Override
	public Question findById(int id) {
		return em.find(Question.class, id);
	}

	@Override
	public List<Question> findAllBySurvey(Survey s) {
		return (List<Question>) em.createQuery("SELECT q FROM Question q WHERE q.survey.id = " + s.getId()).getResultList();

	}
	

}
