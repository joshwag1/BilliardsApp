//used for login and Gson with call to API function login
package com.example.abls2;

import java.io.Serializable;


public class Player implements Serializable {


    /**
     * PlayerNum : 2
     * FirstName : Samuel
     * LastName : Tayman
     */

    private int PlayerNum;
    private String FirstName;
    private String LastName;
    private String email;


    public Player(int playerNum, String firstName, String lastName, String email) {
        PlayerNum = playerNum;
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
    }

    public Player(){
        PlayerNum =-1;
        FirstName = "None";
        LastName = "None";
        email = "None";

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPlayerNum() {
        return PlayerNum;
    }

    public void setPlayerNum(int PlayerNum) {
        this.PlayerNum = PlayerNum;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
}
