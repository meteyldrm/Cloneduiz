package com.meteyldrm.cloneduiz.questions;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionPlaceHolder {

	@SerializedName("Questions")
	public List<Question> questions;

	public QuestionPlaceHolder(){
	}

}
