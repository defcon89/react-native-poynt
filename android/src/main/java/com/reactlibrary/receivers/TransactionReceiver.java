package com.reactlibrary.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import co.poynt.os.model.Intents;

public class TransactionReceiver extends BroadcastReceiver {
    private static final String TAG = TransactionReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intents.ACTION_TRANSACTION_COMPLETED.equals(action)) {
            if (intent.getExtras() != null) {
                Log.d(TAG, "Received TRANSACTION_COMPLETED broadcast. Transaction id: " +
                        intent.getExtras().get(Intents.INTENT_EXTRAS_TRANSACTION_ID));
            }
        } else if (Intents.ACTION_PAYMENT_CANCELED.equals(action)) {
            Log.d(TAG, "Receved broadcast: PAYMENT_CANCELED");
        } else if (Intents.ACTION_SECOND_SCREEN_IDLE.equals(action)) { // home screen is displayed
            Log.d(TAG, action);
        } else if (Intents.ACTION_SECOND_SCREEN_BUSY.equals(action)) { // payment fragment using second screen
            Log.d(TAG, action);
        }
    }
}
