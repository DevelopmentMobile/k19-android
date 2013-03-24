package br.com.k19.android.cap05_02;

import java.util.List;

import br.com.k19.android.cap05_02.dao.NotesDao;
import br.com.k19.android.cap05_02.model.Note;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.app.ListActivity;


public class MainActivity extends ListActivity {
	private NotesDao dao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		dao = new NotesDao(this);
		dao.open();
	}

	@Override
	protected void onResume() {
		dao.open();
		super.onResume();

		List<Note> notes = dao.getAll();

		ArrayAdapter<Note> adapter = new ArrayAdapter<Note>(this,
				android.R.layout.simple_dropdown_item_1line, notes);
		setListAdapter(adapter);

	}

	@Override
	protected void onPause() {
		dao.close();
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.add_note) {
			Intent intent = new Intent(this, AddNoteActivity.class);
			startActivity(intent);
		}

		return super.onOptionsItemSelected(item);
	}

}
