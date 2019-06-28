package com.meteyldrm.cloneduiz.questions;

import com.meteyldrm.cloneduiz.utility.Sort;


import java.util.List;

public class QuestionData {

	public static QuestionData instance;

	public static QuestionData getInstance() {
		if(instance == null){
			return new QuestionData();
		} else{
			return instance;
		}
	}

	public void resetState(){
		for(Question question: getQuestions()){
			List<Answer> answers = question.getAnswers();
			for(Answer answer: answers){
				answer.setSelected(false);
			}
		}
	}

	public void randomize(){
		Sort.sort(getQuestions(), Sort.RANDOM);
		for(Question question: getQuestions()){
			Sort.sort(question.getAnswers(), Sort.RANDOM);
		}
	}

	private static List<Question> questions;

	public List<Question> getQuestions() { return questions; }

	public void setQuestions(List<Question> value) { questions = value; }


}
