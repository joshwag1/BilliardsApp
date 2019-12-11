//for team pairing and for use with Gson and API call getMatches

package com.example.abls2;

public class Match {


    /**
     * HomeTeam : 16
     * AwayTeam : 64
     */

    private int HomeTeam;
    private int AwayTeam;

    public Match(int homeTeam, int awayTeam) {
        HomeTeam = homeTeam;
        AwayTeam = awayTeam;
    }

    public int getHomeTeam() {
        return HomeTeam;
    }

    public void setHomeTeam(int HomeTeam) {
        this.HomeTeam = HomeTeam;
    }

    public int getAwayTeam() {
        return AwayTeam;
    }

    public void setAwayTeam(int AwayTeam) {
        this.AwayTeam = AwayTeam;
    }
}
