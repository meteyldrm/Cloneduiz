package com.meteyldrm.cloneduiz.di.module;

import android.app.Application;
import android.content.Context;

import com.meteyldrm.cloneduiz.utility.MyObjectBox;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;

@Module
public class ActivityModule {
	private Context context;

	public ActivityModule(Application application) {
		this.context = application;
	}

	@Provides
	Context provideContext(){
		return context;
	}

	@Provides
	@Singleton
	BoxStore provideBoxStore(Context context){
		return MyObjectBox.builder().androidContext(context).build();
	}
}
