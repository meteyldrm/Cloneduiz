package com.meteyldrm.cloneduiz.ui.score;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.meteyldrm.cloneduiz.R;
import com.meteyldrm.cloneduiz.ui.main.MainActivity;
import com.meteyldrm.cloneduiz.utility.App;
import com.meteyldrm.cloneduiz.utility.Constants;
import com.meteyldrm.cloneduiz.utility.Score;
import com.meteyldrm.cloneduiz.utility.Score_;

import java.util.Objects;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class NameActivity extends AppCompatActivity {

	@Inject
	BoxStore boxStore;

	Box<Score> scoreBox;

	int score;

	String name;

	TextInputEditText editText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_name);
		score = getIntent().getIntExtra(Constants.SCORE_INTENT_KEY, -1);

		((App) getApplication()).getActivityComponent().inject(this);

		if (score > -1) {


			editText = findViewById(R.id.textInput_name);

			scoreBox = boxStore.boxFor(Score.class);

			findViewById(R.id.button_name).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					name = Objects.requireNonNull(((TextInputEditText) editText).getText()).toString();

					if (name.equals("")) {
						toast(getText(R.string.name_required).toString());
					} else if(scoreBox.query().equal(Score_.username, name).build().find().size() > 0){
						toast(getText(R.string.username_already_used).toString());
					} else {
						scoreBox.put(new Score(name, score));
						Intent intent = new Intent(v.getContext(), ScoreActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intent);
						finish();
					}
				}
			});
		}
	}

	protected void toast(String text){
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
}
