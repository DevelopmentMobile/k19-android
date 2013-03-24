package br.com.michelangelo.android;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView;

public class MainActivity extends SherlockActivity implements ActionBar.TabListener  {
	private TextView text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		text = (TextView) findViewById(R.id.text);
		
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.Tab tab = getSupportActionBar().newTab();
		tab.setText("Clothes");
		tab.setTabListener(this);
		getSupportActionBar().addTab(tab);
		
		tab = getSupportActionBar().newTab();
		tab.setText("Categories");
		tab.setTabListener(this);
		getSupportActionBar().addTab(tab);
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		text.setText("Selected: " + tab.getText());
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//Create the search view
        SearchView searchView = new SearchView(getSupportActionBar().getThemedContext());
        searchView.setQueryHint("Search for…");

        menu.add("Search")
            .setIcon(R.drawable.ic_search_inverse)
            .setActionView(searchView)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        return true;
	}

}
