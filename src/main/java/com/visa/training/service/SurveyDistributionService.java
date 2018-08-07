package com.visa.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.dal.SurveyDistributionDao;
import com.visa.training.domain.SurveyDistribution;

@Service
@Transactional
public class SurveyDistributionService {
	
	@Autowired
	SurveyDistributionDao dao;

	public SurveyDistribution create(SurveyDistribution sd) {
		return dao.create(sd);
	}

	public SurveyDistribution findById(int id) {
		return dao.findById(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}

}
