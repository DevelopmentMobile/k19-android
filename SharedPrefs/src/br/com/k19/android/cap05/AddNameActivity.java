package br.com.k19.android.cap05;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddNameActivity extends Activity {
	private SharedPreferences prefs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_name);
		
		prefs = getSharedPreferences(MainActivity.APP_PREFS, MODE_PRIVATE);
		
		final EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
		Button saveButton = (Button) findViewById(R.id.add_name_button);
		
		saveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String username = nameEditText.getEditableText().toString();
				Editor editor = prefs.edit();
				editor.putString(MainActivity.USERNAME_KEY, username);
				editor.commit();
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_name, menu);
		return true;
	}

}
