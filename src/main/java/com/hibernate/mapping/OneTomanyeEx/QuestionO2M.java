package com.hibernate.mapping.OneTomanyeEx;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class QuestionO2M {
	@Id
	private int questionsId;
	private String question;

	@OneToMany(mappedBy = "question")
	private List<AnswerM2O> answers;

	public QuestionO2M(int questionsId, String question, List<AnswerM2O> answers) {
		super();
		this.questionsId = questionsId;
		this.question = question;
		this.answers = answers;
	}

	public QuestionO2M() {
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

	public List<AnswerM2O> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerM2O> answers) {
		this.answers = answers;
	}

}
