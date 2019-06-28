package com.meteyldrm.cloneduiz.di.component;

import com.meteyldrm.cloneduiz.di.module.ActivityModule;
import com.meteyldrm.cloneduiz.ui.score.NameActivity;
import com.meteyldrm.cloneduiz.ui.score.ScoreActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
	void inject(NameActivity activity);
	void inject(ScoreActivity activity);
}
