package com.meteyldrm.cloneduiz.ui.score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.events.QuestionRequestEvent;
import com.meteyldrm.cloneduiz.events.QuestionSupplyEvent;
import com.meteyldrm.cloneduiz.questions.Answer;
import com.meteyldrm.cloneduiz.questions.Question;
import com.meteyldrm.cloneduiz.utility.Constants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;
import java.util.Objects;

public class ResultsActivity extends AppCompatActivity {

	RecyclerView recyclerView;

	List<Question> questions;

	EventBus eventBus = EventBus.getDefault();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_results);

		recyclerView=findViewById(R.id.recyclerView_results);

		recyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setAdapter(new ResultsRVAdapter());

		findViewById(R.id.button_proceed_results).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				launchNameActivity();
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		eventBus.register(this);
		eventBus.post(new QuestionRequestEvent());
	}

	@Subscribe
	public void onQuestionSupplyEvent(QuestionSupplyEvent event){
		questions = event.questions;
		((ResultsRVAdapter) Objects.requireNonNull(recyclerView.getAdapter())).updateResources(questions);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onStop() {
		eventBus.unregister(this);
		super.onStop();
	}

	public void launchNameActivity(){

		int score = 0;

		for(Question question: questions){
			boolean isCorrect = false;
			for(Answer answer: question.getAnswers()){
				if(answer.getSelected() && answer.getIsTrue().equals("true")){
					isCorrect = true;
				}
			}
			if(isCorrect){
				score += Constants.SCORE_VALUE;
			}
		}

		Intent intent = new Intent(this, NameActivity.class);
		intent.putExtra(Constants.SCORE_INTENT_KEY, score);
		startActivity(intent);
		finish();
	}
}
