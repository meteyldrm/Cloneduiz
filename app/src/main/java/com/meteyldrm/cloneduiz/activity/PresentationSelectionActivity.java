package com.meteyldrm.cloneduiz.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.meteyldrm.cloneduiz.R;

public class PresentationSelectionActivity extends AppCompatActivity {

	Toolbar toolbar;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_presentation_selection);

		toolbar = findViewById(R.id.toolbar);
		((TextView) toolbar.findViewById(R.id.toolbar_title)).setText(R.string.set_presentation);


	}
}
