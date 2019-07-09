package com.meteyldrm.cloneduiz.ui.question.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.questions.Question;

import java.util.List;

public class PageViewPagerAdapter extends PagerAdapter {

	private Context context;
	private List<Question> questions;

	RecyclerView recyclerView = null;
	RecyclerView.Adapter adapter;

	public PageViewPagerAdapter(Context context, List<Question> questions) {
		this.context = context;
		this.questions = questions;
	}

	@Override
	public int getCount() {
		return questions.size();
	}

	@NonNull
	@Override
	public Object instantiateItem(@NonNull ViewGroup container, int position) {
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		ViewGroup layout = (ViewGroup) layoutInflater.inflate(R.layout.component_presentation_page_item, container, false);
		TextView question = layout.findViewById(R.id.textView_presentation_page_question_title);
		question.setText(questions.get(position).getQuestion());
		recyclerView = layout.findViewById(R.id.recyclerView_page_answer_holder);
		recyclerView.setLayoutManager(new LinearLayoutManager(context));
		adapter = new PageAnswersRVAdapter();
		recyclerView.setAdapter(adapter);
		((PageAnswersRVAdapter) adapter).setAnswers(questions.get(position).getAnswers());
		container.addView(layout);
		return layout;
	}

	@Override
	public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
		container.removeView((View) object);
	}

	@Override
	public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
		return view == object;
	}
}
