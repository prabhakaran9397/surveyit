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
@Table(name = "Question_choices")
public class QuestionChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    @Column(name="question_choice", nullable = false)
    String questionChoice;
    
    @ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    Question question;

    public QuestionChoice(int id, String questionChoice, Question question) {
        super();
        this.id = id;
        this.questionChoice = questionChoice;
        this.question = question;
    }
    
    public QuestionChoice() {
        super();
    }

    @Override
    public String toString() {
        return "QuestionChoice [id=" + id + ", questionChoice=" + questionChoice + ", question=" + question + "]";
    }

    public String getQuestionChoice() {
		return questionChoice;
	}

	public void setQuestionChoice(String questionChoice) {
		this.questionChoice = questionChoice;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getId() {
		return id;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((question == null) ? 0 : question.hashCode());
        result = prime * result + ((questionChoice == null) ? 0 : questionChoice.hashCode());
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
        QuestionChoice other = (QuestionChoice) obj;
        if (id != other.id)
            return false;
        if (question == null) {
            if (other.question != null)
                return false;
        } else if (!question.equals(other.question))
            return false;
        if (questionChoice == null) {
            if (other.questionChoice != null)
                return false;
        } else if (!questionChoice.equals(other.questionChoice))
            return false;
        return true;
    }
    
    

}
