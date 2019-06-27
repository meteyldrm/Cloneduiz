package com.meteyldrm.cloneduiz.questions;


import android.os.Parcel;
import android.os.Parcelable;

public class Answer implements Parcelable {
	private String name;
	private String isTrue;
	private boolean isSelected=false;

	protected Answer(Parcel in) {
		name = in.readString();
		isTrue = in.readString();
		byte tmpIsSelected = in.readByte();
		isSelected = tmpIsSelected == 1;
	}

	public static final Creator<Answer> CREATOR = new Creator<Answer>() {
		@Override
		public Answer createFromParcel(Parcel in) {
			return new Answer(in);
		}

		@Override
		public Answer[] newArray(int size) {
			return new Answer[size];
		}
	};

	public String getName() { return name; }
	public void setName(String value) { this.name = value; }

	public String getIsTrue() { return isTrue; }
	public void setIsTrue(String value) { this.isTrue = value; }

	public Boolean getSelected() {
		return isSelected;
	}

	public void setSelected(Boolean selected) {
		isSelected = selected;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(isTrue);
		dest.writeInt(isSelected ? 1 : 0);
	}
}
