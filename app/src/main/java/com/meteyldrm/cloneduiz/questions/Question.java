package com.meteyldrm.cloneduiz.questions;

public class Question {
	private String question;
	private String id;
	private String time;
	private String type;
	private Answer[] answers;

	public String getQuestion() { return question; }
	public void setQuestion(String value) { this.question = value; }

	public String getID() { return id; }
	public void setID(String value) { this.id = value; }

	public String getTime() { return time; }
	public void setTime(String value) { this.time = value; }

	public String getType() { return type; }
	public void setType(String value) { this.type = value; }

	public Answer[] getAnswers() { return answers; }
	public void setAnswers(Answer[] value) { this.answers = value; }
}