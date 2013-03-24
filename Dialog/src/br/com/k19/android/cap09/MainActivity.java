package br.com.k19.android.cap09;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button progressButton = (Button) findViewById(R.id.show_progress_dialog_button);
		Button alertButton = (Button) findViewById(R.id.show_alert_dialog_button);
		Button customButton = (Button) findViewById(R.id.show_custom_dialog_button);

		progressButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DialogFragment dialog = new ProgressDialogFragment();
				dialog.show(getFragmentManager(), "progress");
			}
		});

		alertButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DialogFragment dialog = new AlertDialogFragment();
				dialog.show(getFragmentManager(), "alert");

			}
		});

		customButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DialogFragment dialog = new CustomDialogFragment();
				dialog.show(getFragmentManager(), "custom");

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public static class AlertDialogFragment extends DialogFragment {
		public static AlertDialogFragment newInstance() {
			AlertDialogFragment frag = new AlertDialogFragment();
			return frag;
		}

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			AlertDialog dialog = new AlertDialog.Builder(getActivity())
					.create();
			dialog.setTitle(getActivity().getString(R.string.attention));
			dialog.setMessage(getActivity().getString(
					R.string.witch_button_gonna_press));
			dialog.setButton(DialogInterface.BUTTON_POSITIVE, getActivity()
					.getString(R.string.yes),
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(getActivity(), R.string.pressed_yes,
									Toast.LENGTH_SHORT).show();
						}
					});
			dialog.setButton(DialogInterface.BUTTON_NEGATIVE, getActivity()
					.getString(R.string.no),
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(getActivity(), R.string.pressed_no,
									Toast.LENGTH_SHORT).show();

						}
					});
			return dialog;
		}
	}

	public static class ProgressDialogFragment extends DialogFragment {
		public static ProgressDialogFragment newInstance() {
			ProgressDialogFragment frag = new ProgressDialogFragment();
			return frag;
		}

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			Dialog dialog = new ProgressDialog(getActivity());
			return dialog;
		}

	}

	public static class CustomDialogFragment extends DialogFragment {
		public static CustomDialogFragment newInstance() {
			CustomDialogFragment frag = new CustomDialogFragment();
			return frag;
		}

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View v = inflater.inflate(R.layout.custom_layout, container,
					false);
			getDialog().setTitle(R.string.k19_training);
			return v;
		}

	}

}
