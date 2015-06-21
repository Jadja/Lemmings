package com.mcjadja.lemmings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.io.Console;

/**
 * Created by Jadja on 5/19/2015.
 */
public class AppSettings extends Activity {

    boolean music = true;
    boolean gamesounds = true;
    boolean vibration = false;

    ToggleButton tgbuttonmusic;
    ToggleButton tgbuttonsound;
    ToggleButton tgbuttonvibration;
    private Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_settings);

        activity = this;

        tgbuttonmusic = (ToggleButton) findViewById(R.id.musicbutton);
        tgbuttonsound = (ToggleButton) findViewById(R.id.gamesoundbutton);
        tgbuttonvibration = (ToggleButton) findViewById(R.id.vibrationbutton);

        tgbuttonmusic.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (tgbuttonmusic.isChecked()) {
                    music = true;
                } else {
                    music = false;
                }
            }
        });
        tgbuttonsound.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (tgbuttonsound.isChecked()) {
                    gamesounds = true;
                } else {
                    gamesounds = false;
                }
            }
        });
        tgbuttonvibration.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (tgbuttonvibration.isChecked()) {
                    vibration = true;
                } else {
                    vibration = false;
                }
            }
        });
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
            Level.ToggleMusic(false);
        }
        else    {
            music = true;
            Level.ToggleMusic(true);
        }
    }

    public void toggleGamesounds(View v) {
        //Starting a new Intent
        if (gamesounds)    {
            gamesounds = false;
            Level.ToggleSound(false);
        }
        else    {
            gamesounds = true;
            Level.ToggleSound(true);
        }
    }

    public void toggleVibrate(View v) {
        //Starting a new Intent
        if (vibration)    {
            vibration = false;
            Level.ToggleVibration(false);
        }
        else    {
            vibration = true;
            Level.ToggleVibration(true);
        }
    }

}
