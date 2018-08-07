package com.visa.training.dal;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.visa.training.domain.SurveyDistribution;

public class MysqlSurveyDistributionDao implements SurveyDistributionDao {

	@Autowired
	EntityManager em;
	
	@Override
	public SurveyDistribution create(SurveyDistribution sd) {
		em.persist(sd);
		return sd;
	}

	@Override
	public SurveyDistribution findById(int id) {
		SurveyDistribution sd = em.find(SurveyDistribution.class, id);
		return sd;
	}


}
