package com.meteyldrm.cloneduiz.ui.question.list;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.questions.QuestionData;

import java.util.Objects;

public class ListPresentationActivity extends AppCompatActivity {

	RecyclerView recyclerView;

	AppCompatButton proceedButton = findViewById(R.id.button_proceed);


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_question_list);

		recyclerView = findViewById(R.id.listRecyclerView);
		recyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(mLayoutManager);

		proceedButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
		itemDecoration.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(this, R.drawable.divider)));
		recyclerView.addItemDecoration(itemDecoration);
		recyclerView.setAdapter(new ListPresentationRVAdapter(QuestionData.getInstance().getQuestions()));
	}

	@Override
	protected void onResume() {
		super.onResume();
		QuestionData.getInstance().resetState();
	}
}
