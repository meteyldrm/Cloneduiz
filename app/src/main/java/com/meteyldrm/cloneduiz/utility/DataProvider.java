package com.meteyldrm.cloneduiz.utility;

import android.content.res.Resources;

import com.orm.SugarApp;

public class DataProvider extends SugarApp {

	private static DataProvider instance = null;

	private static Resources resources = null;

	public static DataProvider getInstance() {
		if(instance == null){
			instance = new DataProvider();
		}
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		if(resources == null) {
			resources = getResources();
		}
	}

	public static Resources getAppResources() {
		return resources;
	}
}
