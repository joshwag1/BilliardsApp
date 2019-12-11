//Singleton to hold main players information for the db at the end
package com.example.abls2;

import android.content.Context;

public class MainPlayer {
    private static MainPlayer sMainPlayer;
    private Player mMainPlayer;



    public static MainPlayer get(Context context){
        if (sMainPlayer == null){
            sMainPlayer = new MainPlayer(context);
        }
        return sMainPlayer;
    }

    private MainPlayer(Context context){
        mMainPlayer = new Player();

    }

    public void addDetails(int number, String fname, String lname, String email){
        mMainPlayer.setEmail(email);
        mMainPlayer.setFirstName(fname);
        mMainPlayer.setLastName(lname);
        mMainPlayer.setPlayerNum(number);
    }

    public Player getMainPlayer(){
        return mMainPlayer;
    }
}
