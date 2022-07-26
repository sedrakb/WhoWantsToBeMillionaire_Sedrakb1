/*
Bichoy Sedrak - CSIT551 Mobile Computing Summer 2022
Creating Who wants to be a Millionaire game
 */

package com.example.whowantstobemillionaire_sedrakb1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

// the main Menu Page
public class MainMenu extends AppCompatActivity {
    ImageView Start, Menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Start = findViewById(R.id.start);
        Menu = findViewById(R.id.menu);

// the start button that goes to the game.
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoGame = new Intent(MainMenu.this, MainActivity.class);
                startActivity(GotoGame);
            }
        });

// the menu/option button to go to credits.
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoOptions = new Intent(MainMenu.this, Options.class);
                startActivity(GotoOptions);
            }
        });
    }
}