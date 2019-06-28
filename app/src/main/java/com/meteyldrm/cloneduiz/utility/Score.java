package com.meteyldrm.cloneduiz.utility;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Score {
	@Id public long id;
	public String username;
	public Integer score;

	public Score(){
	}

	public Score(String username, Integer score){
		this.username = username;
		this.score = score;
	}
}
