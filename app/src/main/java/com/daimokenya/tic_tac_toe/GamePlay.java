package com.daimokenya.tic_tac_toe;


/**
 * Created by hitch_sex on 3/30/18.
 */

public class GamePlay {
    /**
     * GamePlay will be used to render the data
     * Game @param playerX, playerO as the opponents and also contains a board
     * either 3box-board or 5box-board
     */
    private String userPlayer;
    private String altPlayer;


    GamePlay(){
        //initial constructor of the class
        this.userPlayer = null;
        this.altPlayer = null;
    }

    public GamePlay(String userPlayer, String altPlayer){
        this.userPlayer = userPlayer;
        this.altPlayer=altPlayer;
    }
    /**
     * This method gets the player which the user has selected
     * It takes input @param userPlayer and returns the string represented by the user
     */
    void setUserPlayer(String user) {

        if (user.equals("X")) {
            this.userPlayer = "X";
            this.altPlayer = "O";
        } else if (user.equals("O")) {
            this.userPlayer = "O";
            this.altPlayer = "X";
        }
    }


    /***
     * This method gets the user Player String
     * @return userPlayer
     */
    String getUserPlayer(){
        try {
            return userPlayer;
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        return userPlayer;
    }
    /***
     * This method gets the alternate Player String
     * @return altPlayer
     */
    String getAltPlayer(){
        return altPlayer;
    }


    /**
     * This method is used to allow the user to change player when he/she is playing alone
     */
    void hasNextPlayer(){
        if(userPlayer.equals("X")) {
            userPlayer = "O";
        }else if(userPlayer.equals("O")){
            userPlayer = "X";
        }
    }

}
