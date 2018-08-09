package com.visa.training.dal;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.Survey;

@Repository
@Transactional
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

	@Override
	public void delete(int id) {
		em.remove(findById(id));
	}
}
