package com.daimokenya.tic_tac_toe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by hitch_sex on 4/10/18.
 * This adapter will be used to populate the grid view with TextView items
 */


public class ThreeBoxAdapter extends BaseAdapter {
    private Context context;
    private String[] playBoard;
    private String user, altPlayer;
    public int numberOfWins, numberOfLost;

    private GamePlay game = new GamePlay(user, altPlayer);
    ThreeBoxAdapter(Context applicationContext, String user, String altPlayer) {
        this.context = applicationContext;
        this.user = user;
        this.altPlayer = altPlayer;
        this.playBoard = new String[9];
        this.numberOfWins =0;
        this.numberOfLost=0;
        game.setUserPlayer(user);

    }

    @Override
    public int getCount() {
        return playBoard.length;
    }
    @Override
    public String getItem(int position) {
        return playBoard[position];
    }
    @Override
    public long getItemId(int position) {
        return playBoard[position].hashCode();
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
         return PlayTextView(context, i);
    }

    /**
     * This method takes
     * @param position which is the position of the cell in GridView
     * @param view this is this the TextView to be populated via the getView()method
     * When this view is clicked:
     *             It sets the Text and size of the current player
     */
    private void playGame(int position, View view){

        if(playBoard[position]==null) {
            playBoard[position] = game.getUserPlayer();
            setCellBackground(view);
            if(hasWon(position)){
                numberOfWins++;
                Toast toastWon = Toast.makeText(context, "You have won "+numberOfWins+".", Toast.LENGTH_SHORT);
                toastWon.show();
                showScoreBoard();
            }
            if(hasLost(position)){
                numberOfLost++;
                Toast toastLost = Toast.makeText(context, "You have lost "+numberOfLost+".", Toast.LENGTH_SHORT);
                toastLost.show();
                showScoreBoard();
            }
                game.hasNextPlayer();
        }else {
            Toast toastPlayer = Toast.makeText(context, "cell not null", Toast.LENGTH_SHORT);
            toastPlayer.show();
        }
    }

    /**
     * This method is used to display the scores of the game
     */
    private void showScoreBoard() {
        Intent scoreIntent = new Intent(context, ScoreBoardActivity.class);
        scoreIntent.putExtra("EXTRA_SCORE_WINS", numberOfWins);
        context.startActivity(scoreIntent);
    }

    /**
     * This method takes:
     * @param context This is the current context of the application to produce a view
     * @param i this is the position of the cell at which the grid is to be populated.
     *          and returns:
     * @return This is the TextView of the current player on the cell which was clicked
     */
    private View PlayTextView(Context context, final int i){
        final TextView text_play = new TextView(context);
        text_play.setLayoutParams(new GridView.LayoutParams(90, 90));
        text_play.setBackgroundColor(Color.parseColor("#d3d3d3"));
        text_play.setBackgroundResource(R.drawable.grid_view_border);
        text_play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                playGame(i, text_play);
                text_play.setText(getItem(i));
                text_play.setTextSize(36);
            }
        });
        return text_play;

    }

    /**
     * This method takes:
     * @param view which is the gridview cell and changes its backgrpund according to player click.
     */
    private void setCellBackground(View view){
        String user = game.getUserPlayer();
        if(user.equals("X")){
            view.setBackgroundResource(R.drawable.btn_player_x_pressed);

        }else if(user.equals("O")){
            view.setBackgroundResource(R.drawable.btn_player_o_pressed);
        }
    }

    /**
     * This method takes
     * @param pos1 value at first cell
     * @param pos2 value at second cell
     * @param pos3 value at last cell
     * @return concatenated string of the parameters above.
     */
    private String getItemAtPosition(int pos1, int pos2, int pos3){
        String checkWin;
        checkWin = playBoard[pos1] + playBoard[pos2] + playBoard[pos3];
        return checkWin;
    }

    /**
     * This method takes
     * @param position of the user cell selectiona and verifies a win
     * @return true if user wins
     */
    public boolean hasWon(int position){
        String userWin = user+user+user;
        if(position == 0){
            if( userWin.equals(getItemAtPosition(0,1,2))){
                return true;
            }
            else if(userWin.equals(getItemAtPosition(0,3,6))){
                return true;
            }
            else if(userWin.equals(getItemAtPosition(0,4,6))){
                 return true;
            }
            return false;
        }
        if(position == 1){
            if( userWin.equals(getItemAtPosition(1,4,7))){
                return true;
            }
            else if(userWin.equals(getItemAtPosition(0,1,2))) {
                return true;
            }
            return false;
        }
        if(position == 2){
            if( userWin.equals(getItemAtPosition(2,5,8))){
                return true;
            }
            else if(userWin.equals(getItemAtPosition(0,1,2))){
                return true;
            }
            else if(userWin.equals(getItemAtPosition(2,4,6))){
                return true;
            }
            return false;
        }
        if(position == 3){
            if( userWin.equals(getItemAtPosition(3,4,5))){
                return true;
            }
            else if(userWin.equals(getItemAtPosition(0,3,6))){
                return true;
            }
            return false;
        }
        if(position == 4){
            if( userWin.equals(getItemAtPosition(1,4,7))){
                return true;
            }
            else if(userWin.equals(getItemAtPosition(3,4,5))){
                return true;
            }
            return false;
        }
        if(position == 5){
            if( userWin.equals(getItemAtPosition(2,5,6))){
                return true;
            }
            else if(userWin.equals(getItemAtPosition(3,4,5))) {
                return true;
            }
            return false;
        }
        if(position == 6){
            if( userWin.equals(getItemAtPosition(6,7,8))){
                return true;
            }
            else if(userWin.equals(getItemAtPosition(0,3,6))){
                return true;
            }
            else if(userWin.equals(getItemAtPosition(2,4,6))){
                return true;
            }
            return false;
        }
        if(position == 7){
            if( userWin.equals(getItemAtPosition(1,4,7))){
                return true;
            }
            else if(userWin.equals(getItemAtPosition(6,7,8))) {
                return true;
            }
            return false;
        }
        if(position == 8){
            if( userWin.equals(getItemAtPosition(2,5,8))){
                return true;
            }
            else if(userWin.equals(getItemAtPosition(0,4,8))) {
                return true;
            }
            else if(userWin.equals(getItemAtPosition(6,7,8))){
                return true;
            }
            return false;
        }
        return true;

    }

    /**
     * This method takes
     * @param position of the alternate player cell selection and verifies a win
     * @return true if alternate player wins and user loses.
     */
    private boolean hasLost(int position){
        String userLost = altPlayer+altPlayer+altPlayer;
        if(position == 0){
            if( userLost.equals(getItemAtPosition(0,1,2))){
                return true;
            }
            else if(userLost.equals(getItemAtPosition(0,3,6))){
                return true;
            }
            else if(userLost.equals(getItemAtPosition(0,4,6))){
                return true;
            }
            return false;
        }
        if(position == 1){
            if( userLost.equals(getItemAtPosition(1,4,7))){
                return true;
            }
            else if(userLost.equals(getItemAtPosition(0,1,2))) {
                return true;
            }
            return false;
        }
        if(position == 2){
            if( userLost.equals(getItemAtPosition(2,5,8))){
                return true;
            }
            else if(userLost.equals(getItemAtPosition(0,1,2))){
                return true;
            }
            else if(userLost.equals(getItemAtPosition(2,4,6))){
                return true;
            }
            return false;
        }
        if(position == 3){
            if( userLost.equals(getItemAtPosition(3,4,5))){
                return true;
            }
            else if(userLost.equals(getItemAtPosition(0,3,6))){
                return true;
            }
            return false;
        }
        if(position == 4){
            if( userLost.equals(getItemAtPosition(1,4,7))){
                return true;
            }
            else if(userLost.equals(getItemAtPosition(3,4,5))){
                return true;
            }
            return false;
        }
        if(position == 5){
            if( userLost.equals(getItemAtPosition(2,5,6))){
                return true;
            }
            else if(userLost.equals(getItemAtPosition(3,4,5))) {
                return true;
            }
            return false;
        }
        if(position == 6){
            if( userLost.equals(getItemAtPosition(6,7,8))){
                return true;
            }
            else if(userLost.equals(getItemAtPosition(0,3,6))){
                return true;
            }
            else if(userLost.equals(getItemAtPosition(2,4,6))){
                return true;
            }
            return false;
        }
        if(position == 7){
            if( userLost.equals(getItemAtPosition(1,4,7))){
                return true;
            }
            else if(userLost.equals(getItemAtPosition(6,7,8))) {
                return true;
            }
            return false;
        }
        if(position == 8){
            if( userLost.equals(getItemAtPosition(2,5,8))){
                return true;
            }
            else if(userLost.equals(getItemAtPosition(0,4,8))) {
                return true;
            }
            else if(userLost.equals(getItemAtPosition(6,7,8))){
                return true;
            }
            return false;
        }
        return true;

    }


}
