package com.example.whowantstobemillionaire_sedrakb1;
/*
Bichoy Sedrak - CSIT551 Mobile Computing Summer 2022
Creating Who wants to be a Millionaire game
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


// the options page that shows the credits.
public class Options extends AppCompatActivity {

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoBackToMainMenu = new Intent(Options.this, MainMenu.class);
                startActivity(GoBackToMainMenu);
            }
        });
    }
}