package com.meteyldrm.cloneduiz.questions;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class QuestionPlaceHolder implements Parcelable {

	@SerializedName("Questions")
	public Question[] questions;

	private QuestionPlaceHolder(Parcel in) {
		questions = (Question[]) in.readArray(Question.class.getClassLoader());
	}

	public QuestionPlaceHolder(){
	}

	public static final Creator<QuestionPlaceHolder> CREATOR = new Creator<QuestionPlaceHolder>() {
		@Override
		public QuestionPlaceHolder createFromParcel(Parcel in) {
			return new QuestionPlaceHolder(in);
		}

		@Override
		public QuestionPlaceHolder[] newArray(int size) {
			return new QuestionPlaceHolder[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelableArray(questions, flags);
	}
}
