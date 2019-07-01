package com.meteyldrm.cloneduiz.utility;

import android.app.Application;
import android.content.res.Resources;

import com.meteyldrm.cloneduiz.di.component.ActivityComponent;
import com.meteyldrm.cloneduiz.di.component.DaggerActivityComponent;
import com.meteyldrm.cloneduiz.di.module.ActivityModule;

public class App extends Application {

	private ActivityComponent activityComponent;

	private static App instance = null;

	public static App getInstance(){
		if(instance == null){
			instance = new App();
		}
		return instance;
	}

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
