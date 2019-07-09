package com.meteyldrm.cloneduiz.ui.score;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.utility.Score;

import java.util.List;

public class ScoreRVAdapter extends RecyclerView.Adapter {

	List<Score> scores;

	private int PRIMARY = 0;
	private int ORDINARY = 1;

	public ScoreRVAdapter(List<Score> scores) {
		this.scores = scores;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		if(viewType == ORDINARY) {
			return new ViewHolderScore(inflater.inflate(R.layout.component_score, parent, false));
		} else if(viewType == PRIMARY){
			return new ViewHolderPrimaryScore(inflater.inflate(R.layout.component_score_primary, parent, false));
		} else {
			return new ViewHolderScore(inflater.inflate(R.layout.component_score, parent, false));
		}
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
		if(holder.getItemViewType() == ORDINARY) {
			Score s = scores.get(position);
			String name = s.username;
			int score = s.score;
			((ViewHolderScore) holder).bindResources(name, score);
		} else if(holder.getItemViewType() == PRIMARY){
			Score s = scores.get(position);
			String name = s.username;
			int score = s.score;
			((ViewHolderPrimaryScore) holder).bindResources(name, score);
		}
	}

	@Override
	public int getItemCount() {
		return scores.size();
	}

	@Override
	public int getItemViewType(int position) {
		if(position == 0){
			return PRIMARY;
		} else return ORDINARY;
	}

	public class ViewHolderScore extends RecyclerView.ViewHolder{

		TextView textViewUserName;
		TextView textViewScore;

		public ViewHolderScore(@NonNull View itemView) {
			super(itemView);

			textViewUserName = itemView.findViewById(R.id.textView_score_name);
			textViewScore = itemView.findViewById(R.id.textView_score_value);
		}

		public void bindResources(String username, int score){
			textViewUserName.setText(username);
			textViewScore.setText(String.format(itemView.getContext().getString(R.string.score), score));
		}
	}

	public class ViewHolderPrimaryScore extends RecyclerView.ViewHolder{

		TextView textViewUserName;
		TextView textViewScore;

		public ViewHolderPrimaryScore(@NonNull View itemView) {
			super(itemView);

			textViewUserName = itemView.findViewById(R.id.textView_score_name);
			textViewScore = itemView.findViewById(R.id.textView_score_value);
		}

		public void bindResources(String username, int score){
			textViewUserName.setText(username);
			textViewScore.setText(String.format(itemView.getContext().getString(R.string.score), score));
		}
	}
}
