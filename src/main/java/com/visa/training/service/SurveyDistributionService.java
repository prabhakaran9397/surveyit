package com.visa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.dal.SurveyDistributionDao;
import com.visa.training.domain.Survey;
import com.visa.training.domain.SurveyDistribution;

@Service
@Transactional
public class SurveyDistributionService {
	
	@Autowired
	SurveyDistributionDao dao;
	
	@Autowired
	SurveyService surveyService;

	public SurveyDistribution create(SurveyDistribution sd) {
		return dao.create(sd);
	}
	
	public SurveyDistribution create(SurveyDistribution sd, Survey s) {
		s = surveyService.findById(s.getId());
		sd.setSurvey(s);
		dao.create(sd);
		s.getDistributions().add(sd);
		return sd;
	}

	public SurveyDistribution findById(int id) {
		return dao.findById(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<SurveyDistribution> findAllById(Survey s) {
		return dao.findAllByUser(s);		
	}

}
