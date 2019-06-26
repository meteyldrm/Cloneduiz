package com.meteyldrm.cloneduiz.ui.score;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.utility.Score;

public class NameActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_name);

		findViewById(R.id.button_name).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Score score = new Score("username", 5);
				score.save();
			}
		});
	}
}
