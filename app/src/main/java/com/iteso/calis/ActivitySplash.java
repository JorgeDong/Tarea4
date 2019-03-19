package com.iteso.calis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iteso.calis.beans.User;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                User user = loadPreferences();
                Intent mainIntent;
                if(user.isLogged()) {
                    mainIntent  = new Intent(ActivitySplash.this, MainActivity.class);
                    mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(mainIntent);
                    finish();
                }
                else {
                    mainIntent = new Intent(ActivitySplash.this, ActivityLogin.class);
                    mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(mainIntent);
                    finish();
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 2000);

    }

    public User loadPreferences(){
        SharedPreferences sharedPreferences =
                getSharedPreferences("com.iteso.session12.PREFERENCES", MODE_PRIVATE);
        User user = new User();
        user.setName(sharedPreferences.getString("USER", null));
        user.setPassword(sharedPreferences.getString("PWD", null));
        user.setLogged(sharedPreferences.getBoolean("LOGGED", false));
        // sharedPreferences = null;
        return user;
    }
}
