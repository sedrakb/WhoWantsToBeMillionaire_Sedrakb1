package com.example.whowantstobemillionaire_sedrakb1;


/*
Bichoy Sedrak - CSIT551 Mobile Computing Summer 2022
Creating Who wants to be a Millionaire game
 */
// the splash screen activity

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.Objects;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // linking the splash screen xml to the java class
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // hiding the action bar on the splash screen
        Objects.requireNonNull(getSupportActionBar()).hide();


        // intent to go to the game Main Menu.
        new Handler().postDelayed(() -> {
            Intent GotoGame = new Intent(Splash.this, MainMenu.class);
            startActivity(GotoGame);
            finish();
        },4000);     // will display for 4 seconds
    }
}
// End By Bichoy Sedrak