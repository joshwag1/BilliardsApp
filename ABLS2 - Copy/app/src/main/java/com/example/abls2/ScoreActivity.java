//Screen 4.1- give two options: view other players roster or start match.
package com.example.abls2;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

public class ScoreActivity extends SingleFragmentActivity{
    Player2[] teamOneObject;
    Player2[] teamTwoObject;



    public static Intent newIntent(Context packageContext, int teamId){
        Intent intent = new Intent(packageContext, ScoreActivity.class);
        intent.putExtra("TEAM_ID", teamId);
        return intent;
    }
    @Override
    protected Fragment createFragment(){


        String teamOneString = "";
        Team2[] teamTwoArray = null;
        Team teamOne = null;
        Team teamTwo = new Team();
        String teamTwoString = "";
        String divisionRosterString = "";
        Match mMatch;
        int teamId = (int) getIntent().getSerializableExtra("TEAM_ID");
        int teamTwoId = -1;

        //find team id in list of matches and get lists of both teams then pair them up and start the match.-----------------------------------------------------
        try{

            teamOneString = new Background(getApplicationContext()).execute("playerList", Integer.toString(teamId), "").get();
        }catch(ExecutionException | InterruptedException ei){
            ei.printStackTrace();
        }

        //get others teams division------------------------------------------------------------------------------------------------------------------------------
        teamOne = TeamList.get(getApplicationContext()).getTeam(teamId);

        try{
            int  test = teamOne.getDivision();
            String test2 = Integer.toString(test);
            divisionRosterString = new Background(getApplicationContext()).execute("roster", test2, "").get();
            try{
                Gson gson = new Gson();
                teamTwoArray = gson.fromJson(divisionRosterString, Team2[].class);
            }catch(Exception e){
                Toast.makeText(getApplicationContext(), "Something went wrong with Json build", Toast.LENGTH_SHORT).show();
            }
        }catch(ExecutionException | InterruptedException ei){
            Toast.makeText(getApplicationContext(), "Something went wrong with the getting the divisions roster.", Toast.LENGTH_SHORT).show();
            ei.printStackTrace();
        }

        //search MatchList for teams twos id---------------------------------------------------------------------------------------------------------------------
        mMatch = MatchList.get(getApplicationContext()).getMatch(teamId);//getTeam(teamId);

        if(mMatch.getHomeTeam() == teamId){
            teamTwoId = mMatch.getAwayTeam();//TeamList.get(getApplicationContext()).getTeam(mMatch).getAwayTeam());//if primary team is home team
        }else if(mMatch.getAwayTeam() == teamId){

            MatchPlay.get(getApplicationContext()).setHometeam(false);//set home team-----------------------------------------------------------------------------
            teamTwoId = mMatch.getHomeTeam();
        }else{
            Toast.makeText(getApplicationContext(), "No match found", Toast.LENGTH_SHORT).show();
        }



        //save other team------------------------------------------------------------------------------------------------------------------------------------------
        for(int i = 0; i < teamTwoArray.length; i++){
            int saveTeam = teamTwoArray[i].getTeamID();

            if (teamTwoId == saveTeam){
                teamTwo.setTeamName(teamTwoArray[i].getTeamName());//teamTwoArray[i].getTeamName());
                teamTwo.setDivision(teamTwoArray[i].getDivisionID());
                teamTwo.setID(teamTwoArray[i].getTeamID());
                teamTwo.setTeamNumber(teamTwoArray[i].getTeamNum());
                teamTwo.setTeamPoints(teamTwoArray[i].getTeamPoints());
                break;

            }

        }
        try{
            teamTwoString = new Background(getApplicationContext()).execute("playerList", Integer.toString(teamTwo.getID()), "").get();


        }catch(ExecutionException | InterruptedException ei){
            ei.printStackTrace();
        }

        //adding teams to match------------------------------------------------------------------------------------------------------------------------------------
        String teamUnoString = teamOneString.replaceAll("\\}\\{","\\},\\{");
        teamUnoString = "[" + teamUnoString + "]";
        String teamDosString = teamTwoString.replaceAll("\\}\\{", "\\},\\{");
        teamDosString = "[" + teamDosString + "]";
        try{
            Gson gson = new Gson();
            teamOneObject = gson.fromJson(teamUnoString, Player2[].class);
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Something went wrong with the match data pull: 1", Toast.LENGTH_SHORT).show();
        }
        try{
            Gson gson = new Gson();
            teamTwoObject = gson.fromJson(teamDosString, Player2[].class);

        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Something went wrong with the match data pull: 2", Toast.LENGTH_SHORT).show();
        }

        for(int i = 0; i < teamOneObject.length; i++){
            MatchPlay.get(getApplicationContext()).addPlayerTeamOne(teamOneObject[i]);
        }
        for(int i = 0; i < teamTwoObject.length;i++){
            MatchPlay.get(getApplicationContext()).addPlayerTeamTwo(teamTwoObject[i]);
        }

        MatchPlay.get(getApplicationContext()).setTeamA(teamId);
        MatchPlay.get(getApplicationContext()).setTeamB(teamTwo.getID());
        if(MatchPlay.get(getApplicationContext()).getTeamTwoUnused().size()<MatchPlay.get(getApplicationContext()).getTeamOneUnused().size()){
            MatchPlay.get(getApplicationContext()).setMatchTotal(MatchPlay.get(getApplicationContext()).getTeamTwoUnused().size());
        }else{
            MatchPlay.get(getApplicationContext()).setMatchTotal(MatchPlay.get(getApplicationContext()).getTeamOneUnused().size()) ;
        }

        return ScoreFragment.newInstance2(teamId, teamTwo.getID(), teamOneString, teamTwoString);

    }
}
