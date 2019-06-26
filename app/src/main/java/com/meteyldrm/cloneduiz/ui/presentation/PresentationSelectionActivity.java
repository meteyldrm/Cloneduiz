package com.meteyldrm.cloneduiz.ui.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.ui.question.list.ListPresentationActivity;

public class PresentationSelectionActivity extends AppCompatActivity {

	Toolbar toolbar;

	ViewPager viewPager;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_presentation_selection);

		toolbar = findViewById(R.id.toolbar);
		/*((TextView) toolbar.findViewById(R.id.toolbar_title)).setText(R.string.set_presentation);*/

		viewPager = findViewById(R.id.viewPager);

		viewPager.setAdapter(new PresentationViewPagerAdapter(this, new PresentationImagePresenter()));

		Intent intent = new Intent(PresentationSelectionActivity.this, ListPresentationActivity.class);
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(intent);
			}
		}, (long) 5);
	}
}
