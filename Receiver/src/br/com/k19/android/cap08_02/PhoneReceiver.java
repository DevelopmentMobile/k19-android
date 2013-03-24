package br.com.k19.android.cap08_02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneReceiver extends BroadcastReceiver{
	private static final String TAG = "Phonereceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle extras = intent.getExtras();
		if(extras != null){
			String state = extras.getString(TelephonyManager.EXTRA_STATE);
			Log.w(TAG, state);
			if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
				String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
				Log.w(TAG, phoneNumber);
			}
		}
		
	}

}
