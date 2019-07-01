package com.meteyldrm.cloneduiz.ui.presentation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.meteyldrm.cloneduiz.R;

import java.util.List;

public class PresentationViewPagerAdapter extends PagerAdapter {

	private Context context;
	private List<Drawable> images;
	private List<String> titles;

	public PresentationViewPagerAdapter(Context context, PresentationData data){
		this.context = context;
		this.images = data.getImages();
		this.titles = data.getTitles();
	}

	@NonNull
	@Override
	public Object instantiateItem(@NonNull ViewGroup container, int position) {
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		ViewGroup layout = (ViewGroup) layoutInflater.inflate(R.layout.partial_presentation_image, container, false);
		ImageView imageView = layout.findViewById(R.id.presentationImageView);
		imageView.setImageDrawable(images.get(position));
		container.addView(layout);
		return layout;
	}

	@Override
	public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
		container.removeView((View) object);
	}

	@Override
	public int getCount() {
		return this.images.size();
	}

	@Override
	public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
		return view == object;
	}

	@Nullable
	@Override
	public CharSequence getPageTitle(int position) {
		return titles.get(position);
	}
}
