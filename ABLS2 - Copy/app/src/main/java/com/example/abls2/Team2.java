//for teams imported from getRoster function of the API

package com.example.abls2;

public class Team2 {

    /**
     * TeamID : 7
     * DivisionID : 2
     * TeamName : Samuel 1
     * TeamNum : 1
     * TeamPoints : 13
     */

    private int TeamID;
    private int DivisionID;
    private String TeamName;
    private int TeamNum;
    private int TeamPoints;

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int TeamID) {
        this.TeamID = TeamID;
    }

    public int getDivisionID() {
        return DivisionID;
    }

    public void setDivisionID(int DivisionID) {
        this.DivisionID = DivisionID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String TeamName) {
        this.TeamName = TeamName;
    }

    public int getTeamNum() {
        return TeamNum;
    }

    public void setTeamNum(int TeamNum) {
        this.TeamNum = TeamNum;
    }

    public int getTeamPoints() {
        return TeamPoints;
    }

    public void setTeamPoints(int TeamPoints) {
        this.TeamPoints = TeamPoints;
    }
}
