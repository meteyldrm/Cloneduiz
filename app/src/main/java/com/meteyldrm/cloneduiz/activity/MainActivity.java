package com.meteyldrm.cloneduiz.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.questions.QuestionData;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

	Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		toolbar = findViewById(R.id.toolbar);

		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle(R.string.app_name);

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
