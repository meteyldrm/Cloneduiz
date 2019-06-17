package com.meteyldrm.cloneduiz.utility;

import com.meteyldrm.cloneduiz.utility.comparator.DataComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
	public static final String BY_ID = "BY_ID";
	public static final String BY_QUESTION = "BY_QUESTION";
	public static final String BY_NAME = "BY_NAME";
	public static final String RANDOM = "RANDOM";

	@SuppressWarnings("unchecked")
	public static <T> void sort(List<T> list, String type){
		if(type.equals(RANDOM)){
			Collections.shuffle(list);
		} else if(type.equals(BY_ID)){
			Collections.sort(list, (Comparator<? super T>) new DataComparator.QuestionIdComparator());
		} else if(type.equals(BY_QUESTION)){
			Collections.sort(list, (Comparator<? super T>) new DataComparator.QuestionQuestionComparator());
		} else if (type.equals(BY_NAME)){
			Collections.sort(list, (Comparator<? super T>) new DataComparator.AnswerNameComparator());
		}
	}
}