package com.visa.training.dal;


import java.util.List;

import com.visa.training.domain.Survey;
import com.visa.training.domain.SurveyDistribution;


public interface SurveyDistributionDao {
	
	SurveyDistribution create(SurveyDistribution sd);
	
	SurveyDistribution findById(int id);

	void delete(int id);

	List<SurveyDistribution> findAllByUser(Survey s);
	
}
