package com.mcjadja.lemmings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Jadja on 5/19/2015.
 */
public class AppSettings extends Activity {

    boolean music = true;
    boolean gamesounds = true;
    boolean vibration = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_settings);
    }

    public void doMenu(View v) {
        //Starting a new Intent
        Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(nextScreen);

    }
    public void toggleMusic(View v) {
        //Starting a new Intent
        if (music)    {
            music = false;
        }
        else    {
            music = true;
        }
    }

    public void toggleGamesounds(View v) {
        //Starting a new Intent
        if (gamesounds)    {
            gamesounds = false;
        }
        else    {
            gamesounds = true;
        }
    }

    public void toggleVibrate(View v) {
        //Starting a new Intent
        if (vibration)    {
            vibration = false;
        }
        else    {
            vibration = true;
        }
    }

}
