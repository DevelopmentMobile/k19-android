package br.com.k19.android.cap05_02;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import br.com.k19.android.cap05_02.dao.NotesDao;

public class AddNoteActivity extends Activity {
	private NotesDao dao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_note);

		dao = new NotesDao(this);
		dao.open();

		Button saveButton = (Button) findViewById(R.id.save_note_button);
		final EditText noteText = (EditText) findViewById(R.id.note_text);

		saveButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String note = noteText.getEditableText().toString();
				dao.create(note);
				finish();
			}
		});
	}

	@Override
	protected void onResume() {
		dao.open();
		super.onResume();
	}

	@Override
	protected void onPause() {
		dao.close();
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_note, menu);
		return true;
	}

}
