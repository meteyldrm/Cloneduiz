package com.meteyldrm.cloneduiz.ui.presentation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.meteyldrm.cloneduiz.R;

import java.util.List;

public class PresentationViewPagerAdapter extends PagerAdapter {

	private Context context;
	private List<Drawable> images;

	public PresentationViewPagerAdapter(Context context, PresentationData data){
		this.context = context;
		this.images = data.getImages();
	}

	@NonNull
	@Override
	public Object instantiateItem(@NonNull ViewGroup container, int position) {
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		ViewGroup layout = (ViewGroup) layoutInflater.inflate(R.layout.partial_presentation_image, container, false);
		ImageView imageView = layout.findViewById(R.id.presentationImageView);
		imageView.setImageDrawable(images.get(position));
		return layout;
	}

	@Override
	public int getCount() {
		return this.images.size();
	}

	@Override
	public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
		return view == object;
	}
}
