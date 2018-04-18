package com.daimokenya.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * This Activity will allow the user to choose a player between PlayerX and PlayerO.
 * The user will also be able to choose the number of squares i.e. 3 or 5 to play on.
 * The Activity opens a GamePlayActivity where the user will be able to play the game.
 */
public class MainActivity extends AppCompatActivity {
    /***
     * The game requires two players represented by char 'x' and 'o'.
     * This activity allows the user to choose either of the two players before playing the game
     */

    public GamePlay newGame = new GamePlay();

    /**
     * This method Overrides Android method onCreate to populate the screen with a layout on the
     * MainActivity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize the buttons when the screen is created or opened
        final Button mPlayerO = findViewById(R.id.btn_player_o);
        final Button mPlayerX = findViewById(R.id.btn_player_x);
        final Button mPlay = findViewById(R.id.btn_play);
        //populate the button
        mPlayerX.setBackgroundResource(R.drawable.btn_player_default);
        mPlayerO.setBackgroundResource(R.drawable.btn_player_default);
        mPlay.setBackgroundResource(R.drawable.btn_play_background);
        final String playerX = "X";
        final String playerO = "O";

        /***
         * This method with @param R.id.btn_player_x and:
         * 1. set the user as PlayerX
         * 2. SetBackground of the Button to Red.
         */

        mPlayerX.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Perform setUserPlayer as X
                //Allow GamePlay class to be able getPlayer chosen by the user
                newGame.setUserPlayer(playerX);
                Toast toastPlayerX = Toast.makeText(getApplicationContext(), R.string.msg_set_player_x, Toast.LENGTH_SHORT);
                toastPlayerX.show();
                mPlayerX.setBackgroundResource(R.drawable.btn_player_x_pressed);
                mPlayerO.setBackgroundResource(R.drawable.btn_player_default);

            }
        });

        /***
         * This method with @param R.id.btn_player_o and:
         * 1. set the user as PlayerO
         * 2. SetBackground of the Button to Light_Blue #2D9CDB.
         */

        mPlayerO.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Perform setUserPlayer as X
                //Allow GamePlay class to be able getPlayer chosen by the user
                newGame.setUserPlayer(playerO);
                Toast toastPlayerX = Toast.makeText(getApplicationContext(), R.string.msg_set_player_o, Toast.LENGTH_SHORT);
                toastPlayerX.show();
                mPlayerO.setBackgroundResource(R.drawable.btn_player_o_pressed);
                mPlayerX.setBackgroundResource(R.drawable.btn_player_default);

            }
        });
    }
    /**
     *This method is invoked when the user clicks on the 'Play' button and send the user to GamePlayActivity
     * @param view is used to be attached on the button that invokes the method onClick
     * The method first validates whether the user and alternate player data type was initialized,
     * then sends the data to the GamePlayActivity before opening it.
     **/

    public void play(View view) {
        String checkUser = newGame.getUserPlayer();
        String checkAlt = newGame.getAltPlayer();
    if (checkUser == null) {
            Toast toastError = Toast.makeText(getApplicationContext(), "Please select player", Toast.LENGTH_SHORT);
            toastError.show();
        }
    else {
        Intent intent = new Intent(this, GamePlayActivity.class);
        intent.putExtra("EXTRA_USER_PLAYER", checkUser);
        intent.putExtra("EXTRA_ALT_PLAYER", checkAlt);
        startActivity(intent);
        finish();
    }
    }
}
