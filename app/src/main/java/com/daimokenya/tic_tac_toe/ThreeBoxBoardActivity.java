package com.daimokenya.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {
    //The following variables would show the scores of the game played by the user


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String user = getIntent().getStringExtra("EXTRA_USER_PLAYER");
        String altPlayer = getIntent().getStringExtra("EXTRA_ALT_PLAYER");
        GridView threeBoxGrid = findViewById(R.id.play_board_grid);

        ThreeBoxAdapter boxAdapter = new ThreeBoxAdapter(this,user,altPlayer);
        threeBoxGrid.setAdapter(boxAdapter);
    }
    /**
     * The following method takes
     * @param view
     * that allows user to change the size of the board. This will be achieved by
     * 1. Starting a new activity by creating an intent.
     * 2. In the new activity's onCreate; Populate the activity with a {@link FiveBoxAdapter}
     * class to create play board.
     */
    public void playFiveBoxBoard(View view) {
        Intent fiveBoardIntent = new Intent(this, MainActivity.class);
//        fiveBoardIntent.putExtra("EXTRA_USER_PLAYER", user);
//        fiveBoardIntent.putExtra("EXTRA_ALT_PLAYER", altPlayer);
        startActivity(fiveBoardIntent);
    }

}
