package com.visa.training.dal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.UserSurvey;

@Repository
@Transactional
public class MysqlUserSurveyDao implements UserSurveyDao {
	
	@Autowired
	EntityManager em;

	@Override
	public UserSurvey findById(int id) {
		
		UserSurvey us = em.find(UserSurvey.class, id);
		return us;
		
	}

	@Override
	public void delete(int id) {
		
		UserSurvey us = findById(id);
		em.remove(us);
		
	}

	@Override
	public UserSurvey create(UserSurvey us) {

		em.persist(us);
		return us;
		
	}

	

}
