package com.meteyldrm.cloneduiz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meteyldrm.cloneduiz.R;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView title = findViewById(R.id.toolbar).findViewById(R.id.toolbar_title);
		title.setTextSize((float) 24.0);
		title.setText(R.string.app_name);

		findViewById(R.id.button_main_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				launchPresentationSelectionActivity();
			}
		});


	}

	public void launchPresentationSelectionActivity(){
		Intent intent = new Intent(this, PresentationSelectionActivity.class);
		startActivity(intent);
	}
}
