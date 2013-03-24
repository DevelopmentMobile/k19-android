package br.com.k19.android.cap11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.RotateDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class MainActivity extends Activity {
	private static final int MEDIA_TYPE_IMAGE = 1;
	private static final int MEDIA_TYPE_VIDEO = 2;
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
	private ImageView imageView;
	private Uri fileUri;

	private static Uri getUri(int type) {
		File mediaStorageDir = new File(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				"Closet");
		if (!mediaStorageDir.exists())
			if (!mediaStorageDir.mkdirs()) {
				Log.e("Camera", "Erro nao foi possivel criar o diretorio: "
						+ mediaStorageDir.getPath());
				return null;
			}

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(new Date());
		File mediaFile;

		switch (type) {
		case MEDIA_TYPE_IMAGE:
			mediaFile = new File(mediaStorageDir.getPath() + File.separator
					+ "IMG_" + timeStamp + ".jpg");
			break;
		case MEDIA_TYPE_VIDEO:
			mediaFile = new File(mediaStorageDir.getPath() + File.separator
					+ "VID_" + timeStamp + ".mp4");
			break;
		default:
			return null;

		}

		return Uri.fromFile(mediaFile);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button captureButton = (Button) findViewById(R.id.button_photo);

		captureButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				fileUri = getUri(MEDIA_TYPE_IMAGE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

				startActivityForResult(intent,
						CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

			}
		});


	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				Toast.makeText(MainActivity.this,
						R.string.save_image,
						Toast.LENGTH_LONG);

				if(fileUri != null){
					imageView = (ImageView) findViewById(R.id.image_view);
					Bitmap map = downloadBitmap(fileUri.getPath());
					imageView.setImageBitmap(map);
					}	
			}
		}
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private Bitmap downloadBitmap(String path) {
		File file = new File(path);		
		Bitmap bitmapImage = null;
		try {			
			InputStream is = new FileInputStream(file);
			bitmapImage = BitmapFactory.decodeStream(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bitmapImage;
	}

}
