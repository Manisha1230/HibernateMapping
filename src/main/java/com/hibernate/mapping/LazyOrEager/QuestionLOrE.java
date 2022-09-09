package com.hibernate.mapping.LazyOrEager;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class QuestionLOrE
{
	@Id
	private int questionsId;
	private String question;
	
	@OneToMany(mappedBy ="question" , fetch = FetchType.LAZY)
	private List<AnswerLOrE> answers;

	public QuestionLOrE(int questionsId, String question, List<AnswerLOrE> answers) {
		
		this.questionsId = questionsId;
		this.question = question;
		this.answers = answers;
	}

	public QuestionLOrE() {
		super();
		
	}

	public int getQuestionsId() {
		return questionsId;
	}

	public void setQuestionsId(int questionsId) {
		this.questionsId = questionsId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<AnswerLOrE> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerLOrE> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "QuestionLOrE [questionsId=" + questionsId + ", question=" + question + ", answers=" + answers + "]";
	}

}
