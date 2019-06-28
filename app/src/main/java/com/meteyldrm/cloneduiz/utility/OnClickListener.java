package com.meteyldrm.cloneduiz.utility;

import android.view.View;

public class OnClickListener implements View.OnClickListener{
	public boolean hasBeenClicked = false;

	public void customOnClick(){
		if(!hasBeenClicked){
			hasBeenClicked = true;
		}
	}

	public void resetClick(){
		hasBeenClicked = false;
	}

	@Override
	public void onClick(View view){}
}
