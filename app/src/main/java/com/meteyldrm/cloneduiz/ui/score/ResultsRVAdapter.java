package com.meteyldrm.cloneduiz.ui.score;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.questions.Answer;
import com.meteyldrm.cloneduiz.questions.Question;

import java.util.List;

public class ResultsRVAdapter extends RecyclerView.Adapter {

	List<Question> questions;

	public ResultsRVAdapter(List<Question> questions){
		this.questions = questions;
	}

	public ResultsRVAdapter() {
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		return new ViewHolderResult(inflater.inflate(R.layout.component_result, parent, false));
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
		((ViewHolderResult) holder).bindResources(questions.get(position));
	}

	@Override
	public int getItemCount() {
		return questions.size();
	}

	public class ViewHolderResult extends RecyclerView.ViewHolder{

		TextView questionText;
		TextView userAnswerText;
		TextView correctAnswerText;

		public ViewHolderResult(@NonNull View itemView) {
			super(itemView);

			questionText = itemView.findViewById(R.id.textView_result_question);
			userAnswerText = itemView.findViewById(R.id.textView_answer_user);
			correctAnswerText = itemView.findViewById(R.id.textView_answer_correct);
		}

		public void bindResources(final Question question){

			boolean isAnswered = false;
			boolean isAnsweredCorrectly = false;

			String userAnswer = "";
			String correctAnswer = "";

			for(Answer answer: question.getAnswers()){
				if(answer.getIsTrue().equals("true")){
					correctAnswer = answer.getName();
				}
				if(answer.getSelected()){
					isAnswered = true;
					userAnswer = answer.getName();
					if(answer.getIsTrue().equals("true")){
						isAnsweredCorrectly = true;
					}
				}
			}

			questionText.setText(question.getQuestion());
			correctAnswerText.setText(correctAnswer);
			correctAnswerText.setTextColor(itemView.getContext().getColor(R.color.green));

			if(!isAnswered){
				itemView.findViewById(R.id.result_constraint_layout).setBackground(itemView.getContext().getDrawable(R.drawable.border_result_empty));
				userAnswerText.setText(itemView.getContext().getString(R.string.user_answer_missing));
				userAnswerText.setTextColor(itemView.getContext().getColor(R.color.gray));
			} else {
				userAnswerText.setText(userAnswer);
				if(isAnsweredCorrectly){
					itemView.findViewById(R.id.result_constraint_layout).setBackground(itemView.getContext().getDrawable(R.drawable.border_result_correct));
					userAnswerText.setTextColor(itemView.getContext().getColor(R.color.green));
				} else {
					itemView.findViewById(R.id.result_constraint_layout).setBackground(itemView.getContext().getDrawable(R.drawable.border_result_incorrect));
					userAnswerText.setTextColor(itemView.getContext().getColor(R.color.red));
				}
			}
		}
	}

	public void updateResources(List<Question> questions){
		this.questions = questions;
		notifyDataSetChanged();
	}

}
