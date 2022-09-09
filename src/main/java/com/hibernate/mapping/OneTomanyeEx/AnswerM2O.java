package com.hibernate.mapping.OneTomanyeEx;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerM2O 
{
	@Id
	private int answerId;
	private String answer;
	
	@ManyToOne
	private QuestionO2M question;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public QuestionO2M getQuestion() {
		return question;
	}

	public void setQuestion(QuestionO2M question) {
		this.question = question;
	}

	public AnswerM2O(int answerId, String answer, QuestionO2M question) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.question = question;
	}

	public AnswerM2O() {
		super();
		
	}

}
