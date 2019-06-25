package com.meteyldrm.cloneduiz.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.gson.Gson;
import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.questions.QuestionData;
import com.meteyldrm.cloneduiz.questions.QuestionPlaceHolder;
import com.meteyldrm.cloneduiz.ui.main.MainActivity;
import com.meteyldrm.cloneduiz.utility.Constants;
import com.meteyldrm.cloneduiz.utility.Sort;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class SplashActivity extends AppCompatActivity {

	private boolean isInitializationFinished = false;
	public boolean isSplashFinished = false;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		findViewById(R.id.activitySplashLayout).setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));

		Handler handler = new Handler();
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

		boolean questionsLoaded = this.initialize();

		if(!questionsLoaded){
			Toast.makeText(this, "Could not initialize", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "Init", Toast.LENGTH_SHORT).show();
		}
	}

	public boolean initialize() {

		boolean success;

		String jsonData;
		int jsonSize;
		try {
			InputStream stream = getAssets().open("questions.json");
			jsonSize = stream.available();
			byte[] bytes = new byte[jsonSize];
			stream.read(bytes);
			stream.close();

			jsonData = new String(bytes, StandardCharsets.UTF_8);
			Gson gson = new Gson();
			final QuestionPlaceHolder questions = gson.fromJson(jsonData, QuestionPlaceHolder.class);
			QuestionData.getInstance().setQuestions(questions.questions);
			//Log.d("LOG", Arrays.deepToString(QuestionData.getInstance().getQuestions().toArray()));
			Sort.sort(QuestionData.getInstance().getQuestions(), Sort.RANDOM);
			/*Log.d("LOG RANDOM", Arrays.deepToString(QuestionData.getInstance().getQuestions().toArray()));
			Sort.sort(QuestionData.getInstance().getQuestions(), Sort.BY_QUESTION);
			Log.d("LOG QUESTION", Arrays.deepToString(QuestionData.getInstance().getQuestions().toArray()));
			Sort.sort(QuestionData.getInstance().getQuestions(), Sort.BY_ID);
			Log.d("LOG ID", Arrays.deepToString(QuestionData.getInstance().getQuestions().toArray()));*/
			success = true;
		} catch (IOException exception) {
			success = false;
			exception.printStackTrace();
		}
		this.onInitializeFinish();
		return success;
	}

	public void onInitializeFinish() {
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
