package com.example.healthcare;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            if (intent.getBooleanExtra("state", false)) {
                Toast.makeText(context, "Airplane mode is ON", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Airplane mode is OFF", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
