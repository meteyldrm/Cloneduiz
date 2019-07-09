package com.meteyldrm.cloneduiz.ui.presentation;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.meteyldrm.cloneduiz.R;

import java.util.ArrayList;
import java.util.List;

public class PresentationImagePresenter implements PresentationData {

	Context context;

	public PresentationImagePresenter(Context context) {
		this.context = context;
	}

	@Override
	public List<Drawable> getImages() {
		List<Drawable> drawables = new ArrayList<>();

		drawables.add(context.getDrawable(R.drawable.qunduiz_list));
		drawables.add(context.getDrawable(R.drawable.qunduiz_page));
		drawables.add(context.getDrawable(R.drawable.qunduiz_sorted));

		return drawables;
	}

	@Override
	public List<String> getTitles() {
		List<String> titles = new ArrayList<>();

		titles.add(context.getString(R.string.viewpager_title_list));
		titles.add(context.getString(R.string.viewpager_title_sorted));
		titles.add(context.getString(R.string.viewpager_title_page));

		return titles;
	}
}
