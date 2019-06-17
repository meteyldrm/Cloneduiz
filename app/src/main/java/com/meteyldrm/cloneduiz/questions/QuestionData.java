package com.meteyldrm.cloneduiz.questions;

import java.util.LinkedList;

public class QuestionData {

	public static QuestionData instance;

	public static QuestionData getInstance() {
		if(instance == null){
			return new QuestionData();
		} else{
			return instance;
		}
	}

	private static LinkedList<Question> questions;

	public LinkedList<Question> getQuestions() { return questions; }

	public void setQuestions(LinkedList<Question> value) { questions = value; }


}
