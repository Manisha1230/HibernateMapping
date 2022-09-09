package com.hibernate.mapping.LazyOrEager;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerLOrE 
{
	@Id
	private int answerId;
	private String answer;
	
	@ManyToOne
	private QuestionLOrE question;

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

	public QuestionLOrE getQuestion() {
		return question;
	}

	public void setQuestion(QuestionLOrE question) {
		this.question = question;
	}

	public AnswerLOrE(int answerId, String answer, QuestionLOrE question) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.question = question;
	}

	public AnswerLOrE() {
		super();
		
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answer=" + answer + "]";
	}

}
