//used for Gson and getRoster call to the API4

package com.example.abls2;

import com.google.gson.annotations.SerializedName;

public class Player2 {

    /**
     * PlayerNum : 3
     * NickName : Danny
     * FirstName : Daniel
     * LastName : Duchak
     * 10BallSkill : 5
     */

    private int PlayerNum;
    private String NickName;
    private String FirstName;
    private String LastName;
    @SerializedName("10BallSkill")
    private int _$10BallSkill;

    public int getPlayerNum() {
        return PlayerNum;
    }

    public void setPlayerNum(int PlayerNum) {
        this.PlayerNum = PlayerNum;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String NickName) {
        this.NickName = NickName;
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

    public int get_TenBallSkill() {
        return _$10BallSkill;
    }

    public void set_TenBallSkill(int _$10BallSkill) {
        this._$10BallSkill = _$10BallSkill;
    }
}
