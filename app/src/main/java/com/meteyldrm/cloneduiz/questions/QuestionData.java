package com.meteyldrm.cloneduiz.questions;

import com.meteyldrm.cloneduiz.utility.Sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
			Answer[] answers = question.getAnswers();
			for(Answer answer: answers){
				answer.setSelected(false);
			}
		}
	}

	public void randomize(){
		Sort.sort(getQuestionsAsList(), Sort.RANDOM);
		for(Question question: getQuestions()){
			List<Answer> answers = Arrays.asList(question.getAnswers());
			Sort.sort(answers, Sort.RANDOM);
			question.setAnswers((Answer[]) answers.toArray());
		}
	}

	private static Question[] questions;

	public Question[] getQuestions() { return questions; }

	public List<Question> getQuestionsAsList(){
		return Arrays.asList(getQuestions());
	}

	public void setQuestions(Question[] value) { questions = value; }

	public void setQuestionsAsList(List<Question> value){
		questions = (Question[]) value.toArray();
	}


}
