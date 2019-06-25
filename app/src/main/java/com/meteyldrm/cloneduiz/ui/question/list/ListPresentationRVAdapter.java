package com.meteyldrm.cloneduiz.ui.question.list;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.questions.Question;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListPresentationRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	List<? extends RecyclerView.ViewHolder> questionViewHolders = new ArrayList<>();
	List<Question> questions;

	private static int TYPE_QUESTION = 1;

	LayoutInflater inflater;

	public ListPresentationRVAdapter(List<Question> list){
		this.questions = list;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

		RecyclerView.ViewHolder viewHolder = null;
		inflater = LayoutInflater.from(parent.getContext());

		if(viewType == TYPE_QUESTION) {
			View view = inflater.inflate(R.layout.component_presentation_list_item, parent, false);

			viewHolder = new ViewHolderQuestion(view, parent);
		} else {
			View view = inflater.inflate(R.layout.partial_presentation_image, parent, false);
			viewHolder = new ViewHolderDummy(view);
		}

		return viewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

		if(holder.getItemViewType() == TYPE_QUESTION){
			((ViewHolderQuestion) holder).bindResources(questions.get(position));
			((ViewHolderQuestion) holder).answerRecyclerView.setLayoutManager(((ViewHolderQuestion) holder).answerLayoutManager);

			((ViewHolderQuestion) holder).answerRecyclerView.setAdapter(new ListAnswersRVAdapter(Arrays.asList(questions.get(position).getAnswers())));
		}
	}

	@Override
	public int getItemCount() {
		return questions.size();
	}

	@Override
	public int getItemViewType(int position) {
		return TYPE_QUESTION;
	}

	public class ViewHolderDummy extends RecyclerView.ViewHolder{

		public ViewHolderDummy(@NonNull View itemView) {
			super(itemView);
		}
	}

	public class ViewHolderQuestion extends RecyclerView.ViewHolder{

		public RecyclerView.LayoutManager answerLayoutManager;
		public RecyclerView answerRecyclerView;

		public TextView questionTitle;

		public ViewHolderQuestion(View view, ViewGroup parent){
			 super(view);



			 questionTitle = view.findViewById(R.id.textView_presentation_list_question_title);

			answerLayoutManager = new LinearLayoutManager(parent.getContext());

			 answerRecyclerView = view.findViewById(R.id.recyclerView_list_answer_holder);
			 answerRecyclerView.setHasFixedSize(true);
		}

		public void bindResources(final Question question){
			questionTitle.setText(question.getQuestion());
		}
	}
}
