package com.visa.training.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="survey_distribution")
public class SurveyDistribution {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    
    @ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.EAGER)
    @JoinColumn(name="survey_id")
    Survey survey;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="distributed_time",nullable=false)
    Date distributedTime;
    
    @OneToMany(mappedBy = "surveyDistribution")
	List<UserSurvey> userSurveys = new ArrayList<>();
    
    public SurveyDistribution() {
    	
    }

    public SurveyDistribution(int id, Survey survey, Date distributedTime) {
        super();
        this.id = id;
        this.survey = survey;
        this.distributedTime = distributedTime;
    }
    
    public int getId() {
    	return id;
    }

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Date getDistributedTime() {
		return distributedTime;
	}

	public void setDistributedTime(Date distributedTime) {
		this.distributedTime = distributedTime;
	}

	public List<UserSurvey> getUserSurveys() {
		return userSurveys;
	}

	public void setUserSurveys(List<UserSurvey> userSurveys) {
		this.userSurveys = userSurveys;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distributedTime == null) ? 0 : distributedTime.hashCode());
		result = prime * result + id;
		result = prime * result + ((survey == null) ? 0 : survey.hashCode());
		result = prime * result + ((userSurveys == null) ? 0 : userSurveys.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SurveyDistribution other = (SurveyDistribution) obj;
		if (distributedTime == null) {
			if (other.distributedTime != null)
				return false;
		} else if (!distributedTime.equals(other.distributedTime))
			return false;
		if (id != other.id)
			return false;
		if (survey == null) {
			if (other.survey != null)
				return false;
		} else if (!survey.equals(other.survey))
			return false;
		if (userSurveys == null) {
			if (other.userSurveys != null)
				return false;
		} else if (!userSurveys.equals(other.userSurveys))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SurveyDistribution [id=" + id + ", survey=" + survey + ", distributedTime=" + distributedTime
				+ ", userSurveys=" + userSurveys + "]";
	}

    
    
}
