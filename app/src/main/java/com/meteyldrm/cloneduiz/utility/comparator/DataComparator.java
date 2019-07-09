package com.meteyldrm.cloneduiz.utility.comparator;

import com.meteyldrm.cloneduiz.questions.Answer;
import com.meteyldrm.cloneduiz.questions.Question;
import com.meteyldrm.cloneduiz.utility.Score;

import java.util.Comparator;

public interface DataComparator {
	class QuestionIdComparator implements Comparator<Question>{
		@Override
		public int compare(Question o1, Question o2) {
			int aId = Integer.valueOf(o1.getID());
			int bId = Integer.valueOf(o2.getID());
			return Integer.compare(aId, bId);
		}
	}

	class QuestionQuestionComparator implements Comparator<Question>{
		@Override
		public int compare(Question o1, Question o2) {
			String question1 = o1.getQuestion();
			String question2 = o2.getQuestion();
			return question1.compareTo(question2);
		}
	}

	class AnswerNameComparator implements Comparator<Answer>{
		@Override
		public int compare(Answer o1, Answer o2) {
			String answer1 = o1.getName();
			String answer2 = o2.getName();
			return answer1.compareTo(answer2);
		}
	}

	class ScoreValueComparator implements Comparator<Score>{
		@Override
		public int compare(Score o1, Score o2){
			return Integer.compare(o2.score, o1.score);
		}
	}
}
