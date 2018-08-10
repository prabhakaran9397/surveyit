package com.visa.training.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="users_surveys_association")
public class UserSurvey {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    
    @ManyToOne(cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    User user;
    
    @ManyToOne(cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER)
    @JoinColumn(name="survey_distribution_id")
    SurveyDistribution surveyDistribution;
    
    @Column(name="is_finished")
    boolean isFinished;

    public UserSurvey(int id, User user, SurveyDistribution surveyDistribution, boolean isFinished) {
        super();
        this.id = id;
        this.user = user;
        this.surveyDistribution = surveyDistribution;
        this.isFinished = isFinished;
    }
    
    public UserSurvey() {
		
	}

	public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SurveyDistribution getSurveyDistribution() {
        return surveyDistribution;
    }

    public void setSurveyDistribution(SurveyDistribution surveyDistribution) {
        this.surveyDistribution = surveyDistribution;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + (isFinished ? 1231 : 1237);
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        UserSurvey other = (UserSurvey) obj;
        if (id != other.id)
            return false;
        if (isFinished != other.isFinished)
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UsersSurveysAssociation [id=" + id + ", user=" + user + ", surveyDistribution=" + surveyDistribution + ", isFinished=" + isFinished + "]";
    }
    
    

}
