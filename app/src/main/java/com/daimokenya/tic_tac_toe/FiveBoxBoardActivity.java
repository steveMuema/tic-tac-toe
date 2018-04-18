package com.daimokenya.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class FiveBoxBoardActivity extends FragmentActivity {
    public int numberOfWins = 0;
    public int numberOfDraws =0;
    public int numberOfLoss =0;

    String user1, altPlayer1;

    /**
     *This Activity when Created, it allows the user to:
     * 1. See the Score board when activity is_ depending on the boxes
     * 2. Inflate the playboard grid with Texts when clicked.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_board);
        //The following variables would show the scores of the game played by the user
        user1 = getIntent().getStringExtra("EXTRA_USER_PLAYER");
        altPlayer1 = getIntent().getStringExtra("EXTRA_ALT_PLAYER");

        //Initialize and populate the playboard grid with items i.e. TextViews
        GridView fiveBoxGrid = findViewById(R.id.play_board_grid);
        fiveBoxGrid.setNumColumns(5);

        FiveBoxAdapter boxAdapter = new FiveBoxAdapter(getApplicationContext(), user1, altPlayer1);
        fiveBoxGrid.setAdapter(boxAdapter);
        TextView changeBoard = findViewById(R.id.txt_change_board);
        changeBoard.setText("Change to 3 box board");
    }
    /**
     * The following method takes
     * @param view
     * that allows user to change the size of the board. This will be achieved by
     * 1. Starting a new activity by creating an intent.
     * 2. In the new activity's onCreate; Populate the activity with a {@link ThreeBoxAdapter}
     * class to create play board.
     */
    public void playFiveBoxBoard(View view){
        Intent fiveBoardIntent = new Intent(this, ThreeBoxBoardActivity.class);
        fiveBoardIntent.putExtra("EXTRA_USER_PLAYER", user1);
        fiveBoardIntent.putExtra("EXTRA_ALT_PLAYER", altPlayer1);
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
