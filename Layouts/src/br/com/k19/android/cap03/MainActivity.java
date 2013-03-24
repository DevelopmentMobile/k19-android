package br.com.k19.android.cap03;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear);
		
		final EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
		Button seeMessageButton = (Button) findViewById(R.id.see_message_button);
		final TextView showMessageText = (TextView) findViewById(R.id.show_message_text); 
		
		seeMessageButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = nameEditText.getEditableText().toString();
				showMessageText.setText(getString(R.string.hello_message, name));
				showMessageText.setVisibility(View.VISIBLE);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
