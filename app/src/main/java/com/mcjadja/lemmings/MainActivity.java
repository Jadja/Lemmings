package com.mcjadja.lemmings;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doStart(View v) {
        //Starting a new Intent
        Intent nextScreen = new Intent(getApplicationContext(), LevelSelect.class);

        startActivity(nextScreen);
    }
    public void doSettings(View v) {
        //Starting a new Intent
        Intent nextScreen = new Intent(getApplicationContext(), AppSettings.class);

        startActivity(nextScreen);
    }

}
