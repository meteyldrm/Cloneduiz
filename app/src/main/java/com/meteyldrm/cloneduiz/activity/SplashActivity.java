package com.meteyldrm.cloneduiz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.gson.Gson;
import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.questions.Question;
import com.meteyldrm.cloneduiz.questions.QuestionData;
import com.meteyldrm.cloneduiz.utility.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class SplashActivity extends AppCompatActivity {

	Handler handler;
	QuestionData question;

	private boolean isInitializationFinished = false;
	public boolean isSplashFinished = false;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		findViewById(R.id.activitySplashLayout).setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));

		handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				if(isInitializationFinished) {
					launchMainActivity();
				} else {
					isSplashFinished = true;
				}
			}
		}, Constants.SPLASH_SCREEN_DURATION_MINIMUM);

		this.initialize();
	}

	public boolean initialize() {

		boolean success;

		String jsonData = "";
		int jsonSize = 0;
		try {
			InputStream stream = getAssets().open("questions.json");
			jsonSize = stream.available();
			byte[] bytes = new byte[jsonSize];
			stream.read(bytes);
			stream.close();

			jsonData = new String(bytes, StandardCharsets.UTF_8);
			Gson gson = new Gson();
			final QuestionData question = gson.fromJson(jsonData, QuestionData.class);
			Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
				@Override
				public void run() {
					Toast.makeText(getApplicationContext(), Integer.toString(question.getQuestions().length), Toast.LENGTH_SHORT).show();
				}
			},((long) 1000));

			for(Object o: question.getQuestions()){
				Log.d("TEST", ((Question) o).getQuestion());
			}

			success = true;
		} catch (IOException exception) {
			success = false;
			exception.printStackTrace();
		}

		this.onInitializeFinish();
		return success;
	}

	public void onInitializeFinish() {
		Toast.makeText(this, "Initialized", Toast.LENGTH_LONG).show();
		if(isSplashFinished) {
			launchMainActivity();
		} else {
			isInitializationFinished = true;
		}
	}

	private void launchMainActivity(){
		Intent intent = new Intent(this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(intent);
	}
}
