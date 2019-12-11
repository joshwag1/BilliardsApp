//singleton to keep track of pairings and match results..
package com.example.abls2;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class MatchPlay {
    private static MatchPlay sMatchPlay;
    private List<Player2> mTeamOneUnused;//remaining unused players on team 1
    private List<Player2> mTeamTwoUnused;//remaining unused players on team 2
    private List<Player2> mTeamOneUsed;//used players on team 1
    private List<Player2> mTeamTwoUsed;//used players on team 2
    private List<Game> mMatchGames;
    private boolean mHometeam = true;//if main players team is home = true, otherwise false.
    private Player2 mPlayerA;
    private Player2 mPlayerB;
    private int teamA;//total matches won
    private int teamB;
    private int scoreA;// score of player a
    private int scoreB;//score of player b
    private int teamAScore;
    private int teamBScore;
    private int homeTeam;//id of hometeam
    private int matchTotal;

    public static MatchPlay get(Context context){
        if(sMatchPlay == null){
            sMatchPlay = new MatchPlay(context);
        }
        return sMatchPlay;
    }
    private MatchPlay(Context context){
        mTeamOneUnused = new ArrayList<>();
        mTeamOneUsed = new ArrayList<>();
        mTeamTwoUnused = new ArrayList<>();
        mTeamTwoUsed = new ArrayList<>();
        mMatchGames = new ArrayList<>();

    }
    public void setHometeam(boolean areWe){
        mHometeam = areWe;
    }

    public boolean isHometeam() {
        return mHometeam;
    }

    public void addPlayerTeamOne(Player2 c){
        mTeamOneUnused.add(c);
    }
    public void addPlayerTeamTwo(Player2 c){
        mTeamTwoUnused.add(c);
    }

    public void usePlayerTeamOne(Player2 c){
        //move player from unused to used.
        mTeamOneUnused.remove(c);
        mPlayerA = c;
        mTeamOneUsed.add(c);
        mPlayerA = c;
    }
    public void usePlayerTeamTwo(Player2 c){
        mTeamTwoUnused.remove(c);
        mPlayerB = c;
        mTeamTwoUsed.add(c);
    }
    public void addGame(Game c){
        mMatchGames.add(c);
    }
    public Game getGame(int index){
        return mMatchGames.get(index);

        }
    public List<Player2> getTeamOneUnused(){
        if(mTeamOneUnused.isEmpty()){
            mTeamOneUnused = mTeamOneUsed;
            mTeamOneUsed.clear();
        }
        return mTeamOneUnused;
    }
    public List<Player2> getTeamTwoUnused(){
        if(mTeamTwoUnused.isEmpty()){
            mTeamTwoUnused = mTeamOneUsed;
            mTeamTwoUsed.clear();
        }
        return mTeamTwoUnused;
    }

    public static MatchPlay getMatchPlay() {
        return sMatchPlay;
    }

    public static void setMatchPlay(MatchPlay matchPlay) {
        sMatchPlay = matchPlay;
    }

    public int getTeamA() {
        return teamA;
    }

    public void setTeamA(int teamA) {
        this.teamA = teamA;
    }

    public int getTeamB() {
        return teamB;
    }

    public void setTeamB(int teamB) {
        if(mHometeam){
            this.teamB=teamB;
        }else{
            this.teamA=teamB;
        }
    }

    public Player2 getPlayerA() {
        return mPlayerA;
    }

    public void setPlayerA(Player2 playerA) {
        mPlayerA = playerA;
    }

    public Player2 getPlayerB() {
        return mPlayerB;
    }

    public void setPlayerB(Player2 playerB) {
        mPlayerB = playerB;
    }

    public int getRaceA(){
        int race = mPlayerA.get_TenBallSkill() - 1;
        if(race < 2) {
            race = 2;
        }
        return race;
    }

    public int getRaceB(){
        int race = mPlayerB.get_TenBallSkill() - 1;
        if(race < 2)
            race = 2;
        return race;
    }

    public void setTeamOneUnused(List<Player2> teamOneUnused) {
        mTeamOneUnused = teamOneUnused;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public void setBothScores(int scoreA, int scoreB){
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    public int getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public int getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    public void setBothTeamScores(int a, int b){
        this.teamAScore = a;
        this.teamBScore = b;
    }
    public int getGameNumber(){
        return (scoreA + scoreB);
    }

    public int getMatchTotal() {
        return matchTotal;
    }

    public void setMatchTotal(int matchTotal) {
        this.matchTotal = matchTotal;
    }
}
