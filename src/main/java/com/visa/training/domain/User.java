package com.visa.training.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="first_name", nullable=false)
	String firstname;
	
	@Column(name="last_name", nullable=false)
	String lastname;
	
	@Column(name="user_name", nullable=false, unique=true)
	String username;
	
	@Column(name="password", nullable=false)
	String password;
	
	@Column(name="user_type", nullable=false)
	int usertype;
	
	@OneToMany(mappedBy = "user")
	List<Survey> surveys = new ArrayList<>();	
	
	@OneToMany(mappedBy = "user")
	List<Answer> answers = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	List<UserSurvey> userSurveys = new ArrayList<>();

	public User(String firstname, String lastname, String username, String password, int usertype) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
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
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((surveys == null) ? 0 : surveys.hashCode());
		result = prime * result + ((userSurveys == null) ? 0 : userSurveys.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + usertype;
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
		User other = (User) obj;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (surveys == null) {
			if (other.surveys != null)
				return false;
		} else if (!surveys.equals(other.surveys))
			return false;
		if (userSurveys == null) {
			if (other.userSurveys != null)
				return false;
		} else if (!userSurveys.equals(other.userSurveys))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (usertype != other.usertype)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + ", usertype=" + usertype + ", surveys=" + surveys + ", answers=" + answers
				+ ", userSurveys=" + userSurveys + "]";
	}
	
}
