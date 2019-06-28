package com.meteyldrm.cloneduiz.questions;


import android.os.Parcel;
import android.os.Parcelable;

public class Answer {
	private String name;
	private String isTrue;
	private boolean isSelected=false;

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

}
