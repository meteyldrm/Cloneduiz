package com.meteyldrm.cloneduiz.questions;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;

public class QuestionPlaceHolder {

	@SerializedName("Questions")
	public LinkedList<Question> questions;
}
