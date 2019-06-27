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
import com.meteyldrm.cloneduiz.ui.question.list.ListAnswersRVAdapter;
import com.meteyldrm.cloneduiz.ui.question.list.ListPresentationRVAdapter;

import org.w3c.dom.Text;

public class ResultsRVAdapter extends RecyclerView.Adapter {

	Question[] questions;

	public ResultsRVAdapter(Question[] questions){
		this.questions = questions;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		return new ViewHolderResult(inflater.inflate(R.layout.component_result, parent, false));
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
		((ViewHolderResult) holder).bindResources(questions[position]);
	}

	@Override
	public int getItemCount() {
		return questions.length;
	}

	public class ViewHolderResult extends RecyclerView.ViewHolder{

		TextView question;
		TextView userAnswer;
		TextView correctAnswer;

		public ViewHolderResult(@NonNull View itemView) {
			super(itemView);

			question = itemView.findViewById(R.id.textView_result_question);
			userAnswer = itemView.findViewById(R.id.textView_answer_user);
			correctAnswer = itemView.findViewById(R.id.textView_answer_correct);
		}

		public void bindResources(final Question question){

			boolean isAnswered = false;
			boolean isAnsweredCorrectly = false;


			for(Answer answer: question.getAnswers()){
				if(answer.getSelected()){
					isAnswered = true;
					if(answer.getIsTrue().equals("true")){
						isAnsweredCorrectly = true;
					}
				}
			}

			if(!isAnswered){
				itemView.findViewById(R.id.result_constraint_layout).setBackground(itemView.getContext().getDrawable(R.drawable.border_result_empty));
			} else {
				if(isAnsweredCorrectly){
					itemView.findViewById(R.id.result_constraint_layout).setBackground(itemView.getContext().getDrawable(R.drawable.border_result_correct));
				} else {
					itemView.findViewById(R.id.result_constraint_layout).setBackground(itemView.getContext().getDrawable(R.drawable.border_result_incorrect));
				}
			}
		}
	}
}
