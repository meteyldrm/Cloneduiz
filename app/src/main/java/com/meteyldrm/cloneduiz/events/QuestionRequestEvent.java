package com.meteyldrm.cloneduiz.events;

public class QuestionRequestEvent {

	public String sorting;
	public String filtering;

	public QuestionRequestEvent() {
		this.sorting = "";
		this.filtering = "";
	}

	public QuestionRequestEvent(String sorting, String filtering) {
		this.sorting = sorting;
		this.filtering = filtering;
	}
}
