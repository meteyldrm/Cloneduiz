package com.meteyldrm.cloneduiz.ui.score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.questions.Question;
import com.meteyldrm.cloneduiz.questions.QuestionPlaceHolder;
import com.meteyldrm.cloneduiz.utility.Constants;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ResultsActivity extends AppCompatActivity {

	RecyclerView recyclerView;
	QuestionPlaceHolder placeHolder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		placeHolder = getIntent().getParcelableExtra(Constants.PARCELABLE_QUESTION_RESULT_KEY);

		setContentView(R.layout.activity_results);

		recyclerView=findViewById(R.id.recyclerView_results);

		recyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setAdapter(new ResultsRVAdapter(placeHolder.questions));
	}
}
