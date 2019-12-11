/*
Screen 1
start- asks user for email then checks user email for existence in the DB..
if it exists it sends them to the password screen storing the user information to this point
if it doesn't exist it gives them 5 tries before locking them out.. (need to implement the last part)
 */

package com.example.abls2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

public class Start extends AppCompatActivity{


    Button mLoginBtn;
    EditText mTxtEmail;
    EditText mTxtPassword;
    TextView mTxtTest;
    String type = "nameLogin";
    String date = "2019-11-23";
    Player player1 = new Player(-1,"", "", "");
    Team[] teamArray;
    Match[] matchArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_login);

        //bind the variables to buttons
        mLoginBtn = (Button) findViewById(R.id.buttonRoster);
        mTxtEmail = (EditText) findViewById(R.id.emailText);
        mTxtPassword = (EditText) findViewById(R.id.passwordText);
        mTxtTest = (TextView) findViewById(R.id.textGreeting);

        //Set listening event for next button
        mLoginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //remove after testing!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                String email = "sntayman@gmail.com";//mTxtEmail.getText().toString();
                String password = "testing";//mTxtPassword.getText().toString();

                //Get Player Data
                try{
                    String recData = new Background(getApplicationContext()).execute(type, email, password).get();
                    if(recData.equals("<br />")){
                        Toast.makeText(getApplicationContext(),"The email you've entered was not found in the database.", Toast.LENGTH_SHORT).show();
                    }else {
                        Gson gson = new Gson();
                        player1 = gson.fromJson(recData, Player.class);
                        player1.setEmail(email);
                    }

                }catch(ExecutionException | InterruptedException ei){
                    ei.printStackTrace();
                }
                //set main player
                MainPlayer.get(getApplicationContext()).addDetails(player1.getPlayerNum(), player1.getFirstName(), player1.getLastName(), player1.getEmail());


                //Get Player Team Data
                try{

                    String recTeamData = new Background(getApplicationContext()).execute("team", Integer.toString(player1.getPlayerNum()), date).get();
                    try{
                        Gson gson = new Gson();
                        teamArray = gson.fromJson(recTeamData, Team[].class);
                    }catch(Exception e){
                        Toast.makeText(getApplicationContext(), "Something went wrong with the team data pull", Toast.LENGTH_SHORT).show();
                    }


                }catch(ExecutionException | InterruptedException ei){
                    ei.printStackTrace();
                }

                for(int i = 0; i < teamArray.length; i++){
                    TeamList.get(getApplicationContext()).addTeam(teamArray[i]);//addTeam(teamArray[i]);
                }




                //Get Player Match Data
                try{

                    String recMatchData = new Background(getApplicationContext()).execute("match", Integer.toString(player1.getPlayerNum()), date).get();
                    try{
                        Gson gson = new Gson();
                        matchArray = gson.fromJson(recMatchData, Match[].class);
                    }catch(Exception e){
                        Toast.makeText(getApplicationContext(), "Something went wrong with the match data pull", Toast.LENGTH_SHORT).show();
                    }


                }catch(ExecutionException | InterruptedException ei){
                    ei.printStackTrace();
                }
                for(int i = 0; i < matchArray.length; i++){
                    MatchList.get(getApplicationContext()).addMatch(matchArray[i]);//addTeam(teamArray[i]);
                }

                //call to pw
                if(player1.getPlayerNum() > 0){
                    Intent intent = new Intent(Start.this, TeamListActivity.class);
                    intent.putExtra("playerSent", player1);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),"Try another.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
