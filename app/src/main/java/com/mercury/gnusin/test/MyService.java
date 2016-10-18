package com.mercury.gnusin.test;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    final String LOG_TAG = "myLogs";

    MyBinder binder = new MyBinder();

    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "MyService onCreate");
        startForeground(1, new Notification());
    }

    public IBinder onBind(Intent intent) {
        Log.d(LOG_TAG, "MyService onBind");
        return binder;
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(LOG_TAG, "MyService onRebind");
    }

    public boolean onUnbind(Intent intent) {
        Log.d(LOG_TAG, "MyService onUnbind");
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "MyService onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "MyService onStartCommand");
        return START_NOT_STICKY;
    }

    public void stop() {
        Log.d(LOG_TAG, "MyService stop");
        stopSelf();
    }

    class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }
}