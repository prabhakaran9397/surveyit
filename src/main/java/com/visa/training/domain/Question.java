package com.visa.training.domain;

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

@Entity
@Table(name = "Questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    @Column(name = "question_type", nullable = false)
    int questionType;
    
    @Column(nullable = false)
    String question;
    
    @ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id")
    Survey survey;
    
    @OneToMany(mappedBy = "question")
	List<QuestionChoice> questionChoices = new ArrayList<>();	

	@OneToMany(mappedBy = "question")
	List<Answer> answers = new ArrayList<>();

	public Question(){
		super();
	}
	
	public Question(int questionType, String question, Survey survey) {
		super();
		this.questionType = questionType;
		this.question = question;
		this.survey = survey;
	}
	
	public int getId() {
		return id;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public List<QuestionChoice> getQuestionChoices() {
		return questionChoices;
	}

	public void setQuestionChoices(List<QuestionChoice> questionChoices) {
		this.questionChoices = questionChoices;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Question other = (Question) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionType=" + questionType + ", question=" + question + ", survey=" + survey
				+ ", questionChoices=" + questionChoices + ", answers=" + answers + "]";
	}
	
	
    
}
