package br.com.k19.android.cap08_02;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button notificationButton = (Button) findViewById(R.id.create_notification_button);
		
		notificationButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						NotificationActivity.class);
				PendingIntent peding = PendingIntent.getActivity(
						MainActivity.this, 0, intent, 0);
				
				Notification notification = new NotificationCompat.Builder(MainActivity.this)
					.setContentTitle(getString(R.string.new_notification))
					.setContentText(getString(R.string.notification_content))
					.setSmallIcon(R.drawable.ic_action_search)
					.setContentIntent(peding)
					.getNotification();
				
				notification.flags |= Notification.FLAG_AUTO_CANCEL;

				NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				manager.notify(0, notification);
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
