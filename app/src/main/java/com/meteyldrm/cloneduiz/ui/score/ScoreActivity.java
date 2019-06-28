package com.meteyldrm.cloneduiz.ui.score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.utility.App;
import com.meteyldrm.cloneduiz.utility.Score;

import java.util.List;

import javax.inject.Inject;

import io.objectbox.BoxStore;

public class ScoreActivity extends AppCompatActivity {

	@Inject
	BoxStore boxStore;

	List<Score> scores;

	RecyclerView recyclerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);

		((App) getApplication()).getActivityComponent().inject(this);

		scores = boxStore.boxFor(Score.class).getAll();

		recyclerView = findViewById(R.id.recyclerView_score);
		recyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setAdapter(new ScoreRVAdapter(scores));
	}
}
