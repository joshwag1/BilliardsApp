//holds information for a single game to return to db
package com.example.abls2;

public class Game {
    int innings;//total innings
    Player2 winner;
    Player2 loser;
    int ballsMadeHome;
    int ballsMadeAway;
    int homeSafeties;
    int awaySafeties;

    public int getHomeSafeties() {
        return homeSafeties;
    }

    public void setHomeSafeties(int homeSafeties) {
        this.homeSafeties = homeSafeties;
    }

    public int getAwaySafeties() {
        return awaySafeties;
    }

    public void setAwaySafeties(int awaySafeties) {
        this.awaySafeties = awaySafeties;
    }



    public int getInnings() {
        return innings;
    }

    public void setInnings(int innings) {
        this.innings = innings;
    }

    public Player2 getWinner() {
        return winner;
    }

    public void setWinner(Player2 winner) {
        this.winner = winner;
    }

    public Player2 getLoser() {
        return loser;
    }

    public void setLoser(Player2 loser) {
        this.loser = loser;
    }

    public int getBallsMadeHome() {
        return ballsMadeHome;
    }

    public void setBallsMadeHome(int ballsMadeHome) {
        this.ballsMadeHome = ballsMadeHome;
    }

    public int getBallsMadeAway() {
        return ballsMadeAway;
    }

    public void setBallsMadeAway(int ballsMadeAway) {
        this.ballsMadeAway = ballsMadeAway;
    }
}
