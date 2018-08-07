package com.visa.training.dal;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.SurveyDistribution;


@Repository
@Transactional
public interface SurveyDistributionDao {
	
	SurveyDistribution create(SurveyDistribution sd);
	
	SurveyDistribution findById(int id);

	
}
