package com.visa.training.dal;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.visa.training.domain.Survey;


public class MysqlSurveyDao implements SurveyDao {

	@Autowired
	EntityManager em;

	@Override
	public Survey create(Survey s) {
		em.persist(s);
		return s;
	}

	@Override
	public Survey findById(int id) {
		Survey s = em.find(Survey.class, id);
		return s;
	}

}
