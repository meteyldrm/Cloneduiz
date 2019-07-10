package com.meteyldrm.cloneduiz.ui.score;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.utility.App;
import com.meteyldrm.cloneduiz.utility.Score;
import com.meteyldrm.cloneduiz.utility.Sort;

import java.util.List;

import javax.inject.Inject;

import io.objectbox.BoxStore;

public class ScoreActivity extends AppCompatActivity {

	@Inject
	BoxStore boxStore;

	List<Score> scores;

	RecyclerView recyclerView;
	RecyclerView.Adapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);

		((App) getApplication()).getActivityComponent().inject(this);

		scores = boxStore.boxFor(Score.class).getAll();
		Sort.sort(scores, Sort.BY_SCORE);

		recyclerView = findViewById(R.id.recyclerView_score);
		recyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(mLayoutManager);
		adapter = new ScoreRVAdapter(scores);
		recyclerView.setAdapter(adapter);

		findViewById(R.id.button_reset_scores).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(ScoreActivity.this)
						.setTitle(R.string.reset_scores)
						.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								boxStore.boxFor(Score.class).removeAll();
								scores = boxStore.boxFor(Score.class).getAll();
								((ScoreRVAdapter) adapter).updateScores(scores);
							}
						})
						.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								dialog.cancel();
							}
						}).show();
			}
		});
	}
}
