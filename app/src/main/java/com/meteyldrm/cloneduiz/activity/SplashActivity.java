package com.meteyldrm.cloneduiz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.utility.Constants;

public class SplashActivity extends AppCompatActivity {

	Handler handler;

	private boolean isInitializationFinished = false;
	private boolean isSplashFinished = false;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		findViewById(R.id.activitySplashLayout).setBackgroundColor(ContextCompat.getColor(this, R.color.cloneduizAccent));

		handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				launchMainActivity();
				if(isInitializationFinished) {
					isSplashFinished = true;
					launchMainActivity();
				}
			}
		}, Constants.SPLASH_SCREEN_DURATION_MINIMUM);

	}

	private void launchMainActivity(){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}
}
