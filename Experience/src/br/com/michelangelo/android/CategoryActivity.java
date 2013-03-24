package br.com.michelangelo.android;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import br.com.michelangelo.android.dao.FashionDao;
import br.com.michelangelo.android.model.Category;
import br.com.michelangelo.experience.R;

public class CategoryActivity extends ListActivity {
	private FashionDao dao;
	private List<Category> categories;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category);

		dao = new FashionDao(this);
		dao.open();

		Button addCategoryButton = (Button) findViewById(R.id.add_category);
		addCategoryButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CategoryActivity.this,
						AddCategoryActivity.class);
				startActivity(intent);

			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		dao.open();
		super.onResume();

		if (categories != null)
			categories = dao.getAllCategory();
		ArrayAdapter<Category> adapter = new ArrayAdapter<Category>(this,
				android.R.layout.simple_expandable_list_item_2);
		setListAdapter(adapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		dao.close();
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.category, menu);
		return true;
	}

}
