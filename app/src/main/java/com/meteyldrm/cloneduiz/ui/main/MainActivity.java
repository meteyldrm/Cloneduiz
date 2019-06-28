package com.meteyldrm.cloneduiz.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.ui.presentation.PresentationSelectionActivity;
import com.meteyldrm.cloneduiz.ui.score.ScoreActivity;

public class MainActivity extends AppCompatActivity {

	Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		toolbar = findViewById(R.id.toolbar_question_list);

		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle(R.string.app_name);

		findViewById(R.id.button_main_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				launchPresentationSelectionActivity();
			}
		});

		findViewById(R.id.button_main_highscore).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				launchScoresActivity();
			}
		});

	}

	public void launchPresentationSelectionActivity(){
		Intent intent = new Intent(this, PresentationSelectionActivity.class);
		startActivity(intent);
	}
	public void launchScoresActivity(){
		Intent intent = new Intent(this, ScoreActivity.class);
		startActivity(intent);
	}
}
