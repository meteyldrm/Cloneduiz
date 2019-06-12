package com.meteyldrm.cloneduiz.questions;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class QuestionDeserializer implements JsonDeserializer<QuestionData> {
	@Override
	public QuestionData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		Gson gson = new Gson();
		QuestionData questionData = gson.fromJson(json, QuestionData.class);
		return questionData;
	}
}
