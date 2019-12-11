//for teams imported from getTeams function of the API
package com.example.abls2;

public class Team {

    /**
     * ID : 7
     * Division : 2
     * TeamName : Samuel 1
     * TeamNumber : 1
     * TeamPoints : 13
     */

    private int ID;
    private int Division;
    private String TeamName;
    private int TeamNumber;
    private int TeamPoints;
    private int MainPlayer;



    public Team(int ID, int division, String teamName, int teamNumber, int teamPoints, int mainPlayer) {
        this.ID = ID;
        Division = division;
        TeamName = teamName;
        TeamNumber = teamNumber;
        TeamPoints = teamPoints;
        MainPlayer = mainPlayer;
    }

    public Team(){

        ID = -1;
        TeamName = "";
        Division = -1;
        TeamNumber = -1;
        TeamPoints = -1;
        MainPlayer = -1;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDivision() {
        return Division;
    }

    public void setDivision(int Division) {
        this.Division = Division;
    }

    public String getTeamName() {
        return TeamName;
    }

    public int getMainPlayer() {
        return MainPlayer;
    }

    public void setMainPlayer(int mainPlayer) {
        MainPlayer = mainPlayer;
    }

    public void setTeamName(String TeamName) {
        this.TeamName = TeamName;
    }

    public int getTeamNumber() {
        return TeamNumber;
    }

    public void setTeamNumber(int TeamNumber) {
        this.TeamNumber = TeamNumber;
    }

    public int getTeamPoints() {
        return TeamPoints;
    }

    public void setTeamPoints(int TeamPoints) {
        this.TeamPoints = TeamPoints;
    }
}
