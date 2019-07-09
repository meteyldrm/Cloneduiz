package com.meteyldrm.cloneduiz.ui.question.page;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.events.QuestionRequestEvent;
import com.meteyldrm.cloneduiz.events.QuestionSupplyEvent;
import com.meteyldrm.cloneduiz.questions.Question;
import com.meteyldrm.cloneduiz.questions.QuestionData;
import com.meteyldrm.cloneduiz.questions.QuestionPlaceHolder;
import com.meteyldrm.cloneduiz.ui.main.MainActivity;
import com.meteyldrm.cloneduiz.ui.score.ResultsActivity;
import com.meteyldrm.cloneduiz.utility.Sort;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;


public class PagePresentationActivity extends AppCompatActivity {

	List<Question> questions;

	ViewPager viewPager;
	int pageNumber = 0;

	Toolbar toolbar;

	EventBus eventBus = EventBus.getDefault();

	AppCompatButton endTestButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page_presentation);
		ButterKnife.bind(this);

		questions = QuestionData.getInstance().getQuestions();

		View view = findViewById(R.id.page_toolbar);
		toolbar = (Toolbar) view.findViewById(R.id.toolbar);

		endTestButton = findViewById(R.id.endTestButton);
		endTestButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(PagePresentationActivity.this)
						.setTitle(R.string.end_test)
						.setMessage(R.string.end_test_subtitle)
						.setIcon(R.drawable.ic_assignment_late_black_24dp)
						.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								startActivity(new Intent(PagePresentationActivity.this, MainActivity.class));
								finish();
							}
						})
						.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								dialog.cancel();
							}
						}).show();
			}
		});

		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(false);

		viewPager = findViewById(R.id.viewPager_page);
		viewPager.setAdapter(new PageViewPagerAdapter(this, questions));
		viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			}

			@Override
			public void onPageSelected(int position) {
				performOnPageForward(position);
			}

			@Override
			public void onPageScrollStateChanged(int state) {
			}
		});
		performOnPageForward(pageNumber);

		findViewById(R.id.button_proceed_question_page).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onContinue(pageNumber);
			}
		});

		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				performOnPageBack(pageNumber);
			}
		});
	}

	@Subscribe
	public void onQuestionRequestEvent(QuestionRequestEvent event){
		String sorting = event.sorting;
		String filtering = event.filtering;

		if(!sorting.equals("")){
			Sort.sort(questions, sorting);
		}

		eventBus.post(new QuestionSupplyEvent(questions));
	}

	@Override
	protected void onStart() {
		super.onStart();
		eventBus.register(this);
	}

	@Override
	protected void onStop() {
		eventBus.unregister(this);
		super.onStop();
	}

	public void enableEndText(){
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		endTestButton.setVisibility(View.VISIBLE);
	}

	public void disableEndText(){
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		endTestButton.setVisibility(View.INVISIBLE);
	}

	public void performOnPageForward(int pageNumber){
		if(pageNumber == 0){
			enableEndText();
		} else {
			disableEndText();
		}
		this.pageNumber = pageNumber;
	}

	public void performOnPageBack(int pageNumber){
		if(pageNumber == 0){
			new AlertDialog.Builder(PagePresentationActivity.this)
					.setTitle(R.string.end_test)
					.setMessage(R.string.end_test_subtitle)
					.setIcon(R.drawable.ic_assignment_late_black_24dp)
					.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							startActivity(new Intent(PagePresentationActivity.this, MainActivity.class));
							finish();
						}
					})
					.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
						}
					}).show();
		} else {
			viewPager.setCurrentItem(pageNumber - 1);
		}
		this.pageNumber = pageNumber - 1;
	}

	public void onContinue(int pageNumber){
		if(pageNumber == questions.size() - 1){
			QuestionPlaceHolder placeHolder = new QuestionPlaceHolder();
			placeHolder.questions = QuestionData.getInstance().getQuestions();
			Intent intent = new Intent(this, ResultsActivity.class);
			startActivity(intent);
			finish();
		} else {
			viewPager.setCurrentItem(pageNumber + 1);
		}
	}
}
