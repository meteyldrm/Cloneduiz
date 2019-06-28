package com.meteyldrm.cloneduiz.ui.score;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.utility.Score;

import java.util.List;

public class ScoreRVAdapter extends RecyclerView.Adapter {

	List<Score> scores;

	public ScoreRVAdapter(List<Score> scores) {
		this.scores = scores;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		return new ViewHolderScore(inflater.inflate(R.layout.component_score, parent, false));
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
		Score s = scores.get(position);
		String name = s.username;
		int score = s.score;
		((ViewHolderScore) holder).bindResources(name, score);
	}

	@Override
	public int getItemCount() {
		return scores.size();
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
}
