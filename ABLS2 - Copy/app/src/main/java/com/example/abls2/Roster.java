//CURRENTLY NOT IN USE.
package com.example.abls2;

import com.google.gson.annotations.SerializedName;

public class Roster {
    /**
     * PlayerNum : 1
     * NickName : Stroker
     * FirstName : Shawn
     * LastName : Gainey
     * 10BallSkill : 6
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

    public int get_$10BallSkill() {
        return _$10BallSkill;
    }

    public void set_$10BallSkill(int _$10BallSkill) {
        this._$10BallSkill = _$10BallSkill;
    }
}
