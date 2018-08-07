package com.visa.training.dal;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.Survey;


@Repository
@Transactional
public interface SurveyDao {
	
	Survey create(Survey s);
	
	Survey findById(int id);
	
}
