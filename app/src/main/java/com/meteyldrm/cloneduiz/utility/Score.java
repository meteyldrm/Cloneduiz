package com.meteyldrm.cloneduiz.utility;

import com.orm.SugarRecord;

public class Score extends SugarRecord {
	String username;
	Integer score;

	public Score(){
	}

	public Score(String username, Integer score){
		this.username = username;
		this.score = score;
	}


}
