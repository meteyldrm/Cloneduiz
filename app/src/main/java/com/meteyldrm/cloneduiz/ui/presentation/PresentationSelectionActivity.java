package com.meteyldrm.cloneduiz.ui.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.questions.QuestionData;
import com.meteyldrm.cloneduiz.ui.question.list.ListPresentationActivity;
import com.meteyldrm.cloneduiz.ui.question.page.PagePresentationActivity;

import java.util.ArrayList;
import java.util.List;

public class PresentationSelectionActivity extends AppCompatActivity {

	Toolbar toolbar;

	ViewPager viewPager;

	public int pagePosition = 0;

	List<Class> classList = new ArrayList<>();

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_presentation_selection);

		toolbar = findViewById(R.id.toolbar_presentation_selection);
		/*((TextView) toolbar.findViewById(R.id.toolbar_title)).setText(R.string.set_presentation);*/

		classList.add(ListPresentationActivity.class);
		classList.add(PagePresentationActivity.class);

		viewPager = findViewById(R.id.viewPager);
		viewPager.setAdapter(new PresentationViewPagerAdapter(this, new PresentationImagePresenter(this)));
		viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				pagePosition = position;
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});

		findViewById(R.id.button_proceed_presentation_selection).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(pagePosition < classList.size()) {
					Intent intent = new Intent(PresentationSelectionActivity.this, classList.get(pagePosition));
					startActivity(intent);
				}
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		QuestionData.getInstance().resetState();
	}
}
