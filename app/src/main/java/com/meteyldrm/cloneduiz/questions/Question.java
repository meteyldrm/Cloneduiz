package com.meteyldrm.cloneduiz.questions;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.List;

public class Question implements Parcelable {
	private String question;
	private String id;
	private String time;
	private String type;
	private Answer[] answers;

	public Question(){}

	protected Question(Parcel in) {
		question = in.readString();
		id = in.readString();
		time = in.readString();
		type = in.readString();
		answers = (Answer[]) in.readArray(Answer.class.getClassLoader());
	}

	public static final Creator<Question> CREATOR = new Creator<Question>() {
		@Override
		public Question createFromParcel(Parcel in) {
			return new Question(in);
		}

		@Override
		public Question[] newArray(int size) {
			return new Question[size];
		}
	};

	public String getQuestion() { return question; }
	public void setQuestion(String value) { this.question = value; }

	public String getID() { return id; }
	public void setID(String value) { this.id = value; }

	public String getTime() { return time; }
	public void setTime(String value) { this.time = value; }

	public String getType() { return type; }
	public void setType(String value) { this.type = value; }

	public Answer[] getAnswers() { return answers; }
	public List<Answer> getAnswersAsList(){
		return Arrays.asList(answers);
	}
	public void setAnswers(Answer[] value) { this.answers = value; }

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(question);
		dest.writeString(id);
		dest.writeString(time);
		dest.writeString(type);
		dest.writeParcelableArray(answers, flags);
	}
}