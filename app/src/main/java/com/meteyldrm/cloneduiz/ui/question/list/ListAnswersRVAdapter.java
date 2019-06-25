package com.meteyldrm.cloneduiz.ui.question.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.questions.Answer;

import java.util.List;

public class ListAnswersRVAdapter extends RecyclerView.Adapter {

	List<Answer> answers;

	public ListAnswersRVAdapter(List<Answer> answers){
		this.answers = answers;
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
		((ViewHolderAnswer) holder).bindResources(answers.get(position));
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
}
