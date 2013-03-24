package br.com.k19.android.cap04;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		
		Bundle extras = getIntent().getExtras();
		String name = extras.getString("name");
		String age = extras.getString("age");
		
		TextView nameTextView = (TextView) findViewById(R.id.name);
		TextView ageTextView = (TextView) findViewById(R.id.age);
		
		nameTextView.setText(getString(R.string.user_name, name));
		ageTextView.setText(getString(R.string.user_age, age));
	}

}
