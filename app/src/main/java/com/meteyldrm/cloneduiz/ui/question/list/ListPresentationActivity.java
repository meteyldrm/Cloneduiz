package com.meteyldrm.cloneduiz.ui.question.list;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.events.QuestionRequestEvent;
import com.meteyldrm.cloneduiz.events.QuestionSupplyEvent;
import com.meteyldrm.cloneduiz.questions.Question;
import com.meteyldrm.cloneduiz.questions.QuestionData;
import com.meteyldrm.cloneduiz.questions.QuestionPlaceHolder;
import com.meteyldrm.cloneduiz.ui.score.ResultsActivity;
import com.meteyldrm.cloneduiz.utility.Sort;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;
import java.util.Objects;

public class ListPresentationActivity extends AppCompatActivity {

	RecyclerView recyclerView;

	AppCompatButton proceedButton;

	EventBus eventBus = EventBus.getDefault();

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_question_list);

		proceedButton = findViewById(R.id.button_proceed_question_list);

		recyclerView = findViewById(R.id.listRecyclerView);

		proceedButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				QuestionPlaceHolder placeHolder = new QuestionPlaceHolder();
				placeHolder.questions = QuestionData.getInstance().getQuestions();
				Intent intent = new Intent(v.getContext(), ResultsActivity.class);
				startActivity(intent);
				finish();
			}
		});

		DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
		itemDecoration.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(this, R.drawable.divider)));
		recyclerView.addItemDecoration(itemDecoration);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(new ListPresentationRVAdapter(QuestionData.getInstance().getQuestions()));
	}

	@Subscribe
	public void onQuestionRequestEvent(QuestionRequestEvent event){
		String sorting = event.sorting;
		String filtering = event.filtering;

		List<Question> questions = QuestionData.getInstance().getQuestions();

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
}
