package com.meteyldrm.cloneduiz.questions;

import com.google.gson.annotations.SerializedName;

public class QuestionData {

	public static QuestionData instance;

	public static QuestionData getInstance() {
		if(instance == null){
			return new QuestionData();
		} else{
			return instance;
		}
	}

	@SerializedName("Questions")
	private Question[] questions;

	public Question[] getQuestions() { return questions; }
	public void setQuestions(Question[] value) { this.questions = value; }
}
