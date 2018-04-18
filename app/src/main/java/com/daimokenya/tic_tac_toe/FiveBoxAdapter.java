package com.daimokenya.tic_tac_toe;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class FiveBoxAdapter extends BaseAdapter {
    private Context context;
    private String[] playBoard = new String[25];
    private String user, altPlayer;

    GamePlay game = new GamePlay(user, altPlayer);
    FiveBoxAdapter(Context applicationContext, String user, String altPlayer) {
        this.context = applicationContext;
        this.user = user;
        this.altPlayer = altPlayer;
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
     * @param position
     * @param view
     * to determine whether the cell clicked has already been selected and cannot be reused.
     * It also handles selecting the next play when the user plays on the board.
     */

    private void playGame(int position, View view){
        if(playBoard[position]==null) {
            playBoard[position] = game.getUserPlayer();
            setCellBackground(view);
            game.hasNextPlayer();
        }else {
            Toast toastPlayer = Toast.makeText(context, "cell not null", Toast.LENGTH_SHORT);
            toastPlayer.show();
        }
    }
//    public boolean hasWon(String[] playBoard){
//        if(playBoard[0].equals(playBoard[1].equals(playBoard[2]))){
//            Toast toastPlayer = Toast.makeText(context, "Game won", Toast.LENGTH_SHORT);
//            toastPlayer.show();
//            return true;
//        }
//        else if(playBoard[0].equals(playBoard[3].equals(playBoard[8]))){
//            return true;
//        }
//        else if(playBoard[0].equals(playBoard[4].equals(playBoard[6]))){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

    /**
     * This method takes
     * @param view
     * To change the background of the view's border according to the right player set.
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

}
