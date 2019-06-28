package com.meteyldrm.cloneduiz.ui.score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.events.QuestionRequestEvent;
import com.meteyldrm.cloneduiz.events.QuestionSupplyEvent;
import com.meteyldrm.cloneduiz.questions.Question;
import com.meteyldrm.cloneduiz.questions.QuestionPlaceHolder;
import com.meteyldrm.cloneduiz.utility.Constants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;
import java.util.Objects;

public class ResultsActivity extends AppCompatActivity {

	RecyclerView recyclerView;
	QuestionPlaceHolder placeHolder;

	EventBus eventBus = EventBus.getDefault();

	boolean isRecyclerViewSuppliedData = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_results);

		recyclerView=findViewById(R.id.recyclerView_results);

		recyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setAdapter(new ResultsRVAdapter());
	}

	@Override
	protected void onStart() {
		super.onStart();
		eventBus.register(this);
		eventBus.post(new QuestionRequestEvent());
	}

	@Subscribe
	public void onQuestionSupplyEvent(QuestionSupplyEvent event){
		List<Question> questions = event.questions;
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
}
