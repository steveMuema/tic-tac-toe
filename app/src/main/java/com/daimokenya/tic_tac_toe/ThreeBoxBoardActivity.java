package com.daimokenya.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;


public class ThreeBoxBoardActivity extends AppCompatActivity {
    String user, altPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_board);
        //The following variables would show the scores of the game played by the user
        user = getIntent().getStringExtra("EXTRA_USER_PLAYER");
        altPlayer = getIntent().getStringExtra("EXTRA_ALT_PLAYER");

        //Initialize the playboard grid and populate it
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
        Intent fiveBoardIntent = new Intent(this, FiveBoxBoardActivity.class);
        fiveBoardIntent.putExtra("EXTRA_USER_PLAYER", user);
        fiveBoardIntent.putExtra("EXTRA_ALT_PLAYER", altPlayer);
        startActivity(fiveBoardIntent);
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}
