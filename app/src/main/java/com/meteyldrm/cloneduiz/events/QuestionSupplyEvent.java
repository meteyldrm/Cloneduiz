package com.meteyldrm.cloneduiz.events;

import com.meteyldrm.cloneduiz.questions.Question;

import java.util.List;

public class QuestionSupplyEvent {

	public List<Question> questions;

	public QuestionSupplyEvent(List<Question> questions) {
		this.questions = questions;
	}
}
