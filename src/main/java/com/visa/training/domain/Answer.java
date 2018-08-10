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
@Table(name="Answers")
public class Answer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    
    @ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
    @JoinColumn(name="question_id")
    Question question;
    
    @ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    User user;
    
    @Column(nullable=false)
    String answer;

    public Answer(Question question, User user, String answer) {
		super();
		this.question = question;
		this.user = user;
		this.answer = answer;
	}
    
    public Answer() {
		super();
	}
    
    public int getId() {
        return id;
    }

	public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((answer == null) ? 0 : answer.hashCode());
        result = prime * result + id;
        result = prime * result + ((question == null) ? 0 : question.hashCode());
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
        Answer other = (Answer) obj;
        if (answer == null) {
            if (other.answer != null)
                return false;
        } else if (!answer.equals(other.answer))
            return false;
        if (id != other.id)
            return false;
        if (question == null) {
            if (other.question != null)
                return false;
        } else if (!question.equals(other.question))
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
		return "Answer [id=" + id + ", question=" + question + ", user=" + user + ", answer=" + answer + "]";
	}

    
    
}
