package com.visa.training.dal;


import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.Survey;
import com.visa.training.domain.SurveyDistribution;

@Repository
@Transactional
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

	@Override
	public void delete(int id) {
		em.remove(findById(id));
	}

	@Override
	public List<SurveyDistribution> findAllByUser(Survey s) {
		return (List<SurveyDistribution>) em.createQuery("SELECT s FROM SurveyDistribution s WHERE s.survey.id = " + s.getId()).getResultList();

	}
	

}
