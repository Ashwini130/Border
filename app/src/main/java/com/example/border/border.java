package com.example.border;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * Created by Ashwini on 10-02-2018.
 */

public class border extends Service {

    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mParams;
    FrameLayout thview;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);




        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
       // mWindowManager.addView(thview, mParams);



        mParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT);

        mParams.flags=WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        RelativeLayout thisview = (RelativeLayout) inflater.inflate(R.layout.boundary, null);
        mWindowManager.addView(thisview, mParams);
        return START_NOT_STICKY;
    }
}


           /*



           // Toast.makeText(getContext(),String.valueOf(maxX),Toast.LENGTH_LONG).show();
           // Toast.makeText(getContext(),String.valueOf(maxY),Toast.LENGTH_LONG).show();

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();

        float maxX = metrics.xdpi;
        float maxY = metrics.ydpi;


        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        canvas.drawPoint(0, 0, paint);
        canvas.drawPoint(0, maxY, paint);
        canvas.drawPoint(maxX, 0, paint);
        canvas.drawPoint(maxX, maxY, paint);
        canvas.drawPoint(maxX/2, maxY/2, paint);
        return false;
    }
}

*/