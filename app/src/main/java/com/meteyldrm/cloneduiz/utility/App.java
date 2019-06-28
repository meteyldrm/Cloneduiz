package com.meteyldrm.cloneduiz.utility;

import android.app.Application;

import com.meteyldrm.cloneduiz.di.component.ActivityComponent;
import com.meteyldrm.cloneduiz.di.component.DaggerActivityComponent;
import com.meteyldrm.cloneduiz.di.module.ActivityModule;

public class App extends Application {

	private ActivityComponent activityComponent;


	@Override
	public void onCreate() {
		super.onCreate();

		activityComponent = DaggerActivityComponent.builder()
				.activityModule(new ActivityModule(this)).build();
	}

	public ActivityComponent getActivityComponent() {
		return activityComponent;
	}


	public void setActivityComponent(ActivityComponent activityComponent) {
		this.activityComponent = activityComponent;
	}

}
