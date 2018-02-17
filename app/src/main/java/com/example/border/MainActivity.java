package com.example.border;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    // Preferences
    //Preference change;
    //private SharedPreferences mPrefs = null;

    // Preference change listener
    //private PreferenceChangeListener mPreferenceListener = null;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!Settings.canDrawOverlays(this)) {
            Intent intent1 = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent1, 0);
        }

        //mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferenceListener = new PreferenceChangeListener();
        //mPrefs.registerOnSharedPreferenceChangeListener(mPreferenceListener);
        //startService(new Intent(this, border.class));
        //finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
            {
                Intent intent = new Intent(this, PreferenceSettingActivity.class);
                startActivity(intent);

                return true;
            }
            default:
            {
                return false;
            }
        }
    }

    /*
    private class PreferenceChangeListener implements SharedPreferences.OnSharedPreferenceChangeListener {

        @Override
        public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
            if ( key.equals("border")) {

                startService(new Intent(MainActivity.this, border.class));
                Log.v("PreferenceChange", "**** KEY test_preference_key modified ****");
            }
        }
    }*/
}

