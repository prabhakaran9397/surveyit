package com.visa.training.dal;


import com.visa.training.domain.SurveyDistribution;


public interface SurveyDistributionDao {
	
	SurveyDistribution create(SurveyDistribution sd);
	
	SurveyDistribution findById(int id);

	void delete(int id);
}
