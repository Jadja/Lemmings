package com.mcjadja.lemmings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Jadja on 5/19/2015.
 */
public class LevelSelect extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_select);
    }
    public void doLevel(View v) {
        //Starting a new Intent
        Intent nextScreen = new Intent(getApplicationContext(), Level.class);

        startActivity(nextScreen);
    }


}
