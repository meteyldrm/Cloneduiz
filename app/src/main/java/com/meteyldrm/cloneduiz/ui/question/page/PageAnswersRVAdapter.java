package com.meteyldrm.cloneduiz.ui.question.page;

import android.graphics.drawable.TransitionDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.questions.Answer;
import com.meteyldrm.cloneduiz.utility.Constants;

import java.util.List;

public class PageAnswersRVAdapter extends RecyclerView.Adapter {
	List<Answer> answers;

	public PageAnswersRVAdapter(List<Answer> answers){
		this.answers = answers;
	}

	public PageAnswersRVAdapter(){

	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.component_answer, parent, false);
		return new ViewHolderAnswer(view);
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

		Answer answer=answers.get(position);
		((ViewHolderAnswer) holder).bindResources(answer);
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!answer.getSelected()){
					for(Answer ans: answers){
						ans.setSelected(false);
					}
					answer.setSelected(true);
					notifyDataSetChanged();
				} else {
					answer.setSelected(false);
					notifyDataSetChanged();
				}
			}
		});
		TransitionDrawable transitionDrawable = (TransitionDrawable) holder.itemView.getBackground();
		transitionDrawable.setCrossFadeEnabled(true);
		if (answer.getSelected()){
			transitionDrawable.startTransition(Constants.TRANSITION_DRAWABLE_TIME);
			//holder.itemView.setBackground(holder.itemView.getContext().getDrawable(R.drawable.border_selected_answer));
		} else {
			transitionDrawable.resetTransition();
			//transitionDrawable.reverseTransition(Constants.TRANSITION_DRAWABLE_TIME);
			//holder.itemView.setBackground(holder.itemView.getContext().getDrawable(R.drawable.border_answers));
		}
	}

	@Override
	public int getItemCount() {
		return answers.size();
	}

	public class ViewHolderAnswer extends RecyclerView.ViewHolder{

		public TextView answer;

		public ViewHolderAnswer(@NonNull View itemView) {
			super(itemView);
			answer = itemView.findViewById(R.id.textView_answer);
		}

		public void bindResources(final Answer answerText){
			answer.setText(answerText.getName());
		}
	}

	public void setAnswers(List<Answer> answers){
		this.answers = answers;
		this.notifyDataSetChanged();
	}
}
