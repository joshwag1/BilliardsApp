//Screen 8-hosted by gameactivity
package com.example.abls2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment {
    Button mBtnHome;
    Button mBtnAway;
    Button mBtnOne;
    Button mBtnTwo;
    Button mBtnThree;
    Button mBtnFour;
    Button mBtnFive;
    Button mBtnSix;
    Button mBtnSeven;
    Button mBtnEight;
    Button mBtnNine;
    Button mBtnTen;
    Button mBtnSafety;
    Button mBtnTimeout;
    Button mBtnEndgame;
    Button mBtnReset;
    TextView mTextInning;
    TextView mTextScore;
    TextView mGameScore;
    TextView mTeamScore;
    int turn = 1;
    int innings = 0;
    int homeBallsMade = 0;
    int awayBallsMade = 0;
    boolean homeTimeout = true;
    boolean awayTimeout = true;
    boolean homeWin = true;
    int homeSafety = 0;
    int awaySafety = 0;
    Player2 winner;
    Player2 loser;
    Game currGame = new Game();
    public static GameFragment newInstance(){
        Bundle args = new Bundle();

        GameFragment fragment = new GameFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_game, container, false);
        mBtnHome = (Button) v.findViewById(R.id.btnHomePlayer);
        mBtnAway = (Button) v.findViewById(R.id.btnAwayPlayer);
        mBtnOne = (Button) v.findViewById(R.id.btn1);
        mBtnTwo = (Button) v.findViewById(R.id.btn2);
        mBtnThree = (Button) v.findViewById(R.id.btn3);
        mBtnFour = (Button) v.findViewById(R.id.btn4);
        mBtnFive = (Button) v.findViewById(R.id.btn5);
        mBtnSix = (Button) v.findViewById(R.id.btn6);
        mBtnSeven = (Button) v.findViewById(R.id.btn7);
        mBtnEight = (Button) v.findViewById(R.id.btn8);
        mBtnNine = (Button) v.findViewById(R.id.btn9);
        mBtnTen = (Button) v.findViewById(R.id.btn10);
        mBtnSafety = (Button) v.findViewById(R.id.btnSafety);
        mBtnTimeout = (Button) v.findViewById(R.id.btnTimeout);
        mBtnEndgame = (Button) v.findViewById(R.id.btnEndgame);
        mBtnReset = (Button) v.findViewById(R.id.btnReset);
        mTextInning = (TextView) v.findViewById(R.id.textInning);
        mTextScore = (TextView) v.findViewById(R.id.textScore);
        mGameScore = (TextView) v.findViewById(R.id.textGameScore);
        mTeamScore = (TextView) v.findViewById(R.id.textTeamScore);


        mTextInning.setText("Inning: " + innings);

        //To ensure home player is the first name listed
        if(MatchPlay.get(getActivity()).isHometeam()){
            mBtnHome.setText(MatchPlay.get(getActivity()).getPlayerA().getFirstName());
            mBtnAway.setText(MatchPlay.get(getActivity()).getPlayerB().getFirstName());
            mGameScore.setText("Home Games Won: " + MatchPlay.get(getActivity()).getScoreA() + " - Away Games Won: " + MatchPlay.get(getActivity()).getScoreB());
            mTeamScore.setText("Home Matches Won: " + MatchPlay.get(getActivity()).getTeamAScore() + " - Away Matches Won: " + MatchPlay.get(getActivity()).getTeamBScore());
        }else{
            mBtnHome.setText(MatchPlay.get(getActivity()).getPlayerB().getFirstName());
            mBtnAway.setText(MatchPlay.get(getActivity()).getPlayerA().getFirstName());
            mGameScore.setText("Home Games Won: " + MatchPlay.get(getActivity()).getScoreB()+ " - Away Games Won: " + MatchPlay.get(getActivity()).getScoreA());
            mTeamScore.setText("Home Matches Won: " + MatchPlay.get(getActivity()).getTeamBScore() + " - Away Matches Won: " + MatchPlay.get(getActivity()).getTeamAScore());
        }

        mTextScore.setText("Home Balls Made: " + homeBallsMade +" - Away Balls Made: " + awayBallsMade);

        mBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnHome.setEnabled(false);
                mBtnAway.setEnabled(true);
                turn++;
                if(turn%2 == 0){
                    innings++;
                }
                mTextInning.setText("Inning: " + innings);
            }
        });

        mBtnAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mBtnHome.setEnabled(true);
                mBtnAway.setEnabled(false);
                turn++;
                if(turn%2 == 0){
                    innings++;
                }
                mTextInning.setText("Inning: " + innings);

            }
        });

        mBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnOne.setEnabled(false);
                if(mBtnHome.isEnabled()==false){
                    //mBtnOne.setEnabled(false);
                    homeBallsMade++;
                }
                if(mBtnAway.isEnabled()==false){
                    awayBallsMade++;
                }
                mTextScore.setText("Home Balls Made: " + homeBallsMade +" - Away Balls Made: " + awayBallsMade);

            }
        });

        mBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnTwo.setEnabled(false);
                if(mBtnHome.isEnabled()==false){

                    homeBallsMade++;
                }
                if(mBtnAway.isEnabled()==false){

                    awayBallsMade++;
                }
                mTextScore.setText("Home Balls Made: " + homeBallsMade +" - Away Balls Made: " + awayBallsMade);

            }


        });

        mBtnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnThree.setEnabled(false);
                if(mBtnHome.isEnabled()==false){

                    homeBallsMade++;
                }
                if(mBtnAway.isEnabled()==false){

                    awayBallsMade++;
                }
                mTextScore.setText("Home Balls Made: " + homeBallsMade +" - Away Balls Made: " + awayBallsMade);

            }
        });

        mBtnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnFour.setEnabled(false);
                if(mBtnHome.isEnabled()==false){

                    homeBallsMade++;
                }
                if(mBtnAway.isEnabled()==false){

                    awayBallsMade++;
                }
                mTextScore.setText("Home Balls Made: " + homeBallsMade +" - Away Balls Made: " + awayBallsMade);

            }
        });

        mBtnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnFive.setEnabled(false);
                if(mBtnHome.isEnabled()==false){

                    homeBallsMade++;
                }
                if(mBtnAway.isEnabled()==false){

                    awayBallsMade++;
                }
                mTextScore.setText("Home Balls Made: " + homeBallsMade +" - Away Balls Made: " + awayBallsMade);

            }
        });

        mBtnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnSix.setEnabled(false);
                if(mBtnHome.isEnabled()==false){

                    homeBallsMade++;
                }
                if(mBtnAway.isEnabled()==false){

                    awayBallsMade++;
                }
                mTextScore.setText("Home Balls Made: " + homeBallsMade +" - Away Balls Made: " + awayBallsMade);

            }
        });

        mBtnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnSeven.setEnabled(false);
                if(mBtnHome.isEnabled()==false){

                    homeBallsMade++;
                }
                if(mBtnAway.isEnabled()==false){

                    awayBallsMade++;
                }
                mTextScore.setText("Home Balls Made: " + homeBallsMade +" - Away Balls Made: " + awayBallsMade);

            }
        });

        mBtnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnEight.setEnabled(false);
                if(mBtnHome.isEnabled()==false){

                    homeBallsMade++;
                }
                if(mBtnAway.isEnabled()==false){

                    awayBallsMade++;
                }
                mTextScore.setText("Home Balls Made: " + homeBallsMade +" - Away Balls Made: " + awayBallsMade);

            }
        });

        mBtnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnNine.setEnabled(false);
                if(mBtnHome.isEnabled()==false){

                    homeBallsMade++;
                }
                if(mBtnAway.isEnabled()==false){

                    awayBallsMade++;
                }
                mTextScore.setText("Home Balls Made: " + homeBallsMade +" - Away Balls Made: " + awayBallsMade);

            }
        });

        mBtnTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnTen.setEnabled(false);
                if(mBtnHome.isEnabled()==false){
                    winner = MatchPlay.get(getActivity()).getPlayerB();
                    loser = MatchPlay.get(getActivity()).getPlayerA();

                    homeBallsMade++;
                }
                if(mBtnAway.isEnabled()==false){
                    winner = MatchPlay.get(getActivity()).getPlayerA();
                    loser = MatchPlay.get(getActivity()).getPlayerB();
                    homeWin = false;
                    awayBallsMade++;
                }
                mTextScore.setText("Home Balls Made: " + homeBallsMade +" - Away Balls Made: " + awayBallsMade);

            }
        });

        mBtnSafety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mBtnHome.isEnabled()==false){

                    homeSafety++;
                }
                if(mBtnAway.isEnabled()==false){

                    awaySafety++;
                }


            }
        });

        mBtnTimeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBtnHome.isEnabled()==false){

                    if(homeTimeout){
                        Toast.makeText(getActivity(), "Timeout Taken", Toast.LENGTH_SHORT).show();
                        homeTimeout = false;
                    }else{
                        Toast.makeText(getActivity(), "No Timeouts Left", Toast.LENGTH_SHORT).show();
                    }
                }
                if(mBtnAway.isEnabled()==false){

                    if(awayTimeout){
                        Toast.makeText(getActivity(), "Timeout Taken", Toast.LENGTH_SHORT).show();
                        awayTimeout = false;
                    }else{
                        Toast.makeText(getActivity(), "No Timeouts Left", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        mBtnEndgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(winner == null){
                    Toast.makeText(getActivity(), "No Player has made the ten ball.", Toast.LENGTH_SHORT).show();
                }else {
                    currGame.setAwaySafeties(awaySafety);
                    currGame.setHomeSafeties(homeSafety);
                    currGame.setBallsMadeAway(awayBallsMade);
                    currGame.setBallsMadeHome(homeBallsMade);
                    currGame.setInnings(innings);
                    currGame.setWinner(winner);
                    currGame.setLoser(loser);
                    MatchPlay.get(getActivity()).addGame(currGame);
                    if((homeWin) && (MatchPlay.get(getActivity()).isHometeam()) || (!homeWin && MatchPlay.get(getActivity()).isHometeam()==false)){
                        MatchPlay.get(getActivity()).setScoreA(MatchPlay.get(getActivity()).getScoreA()+1);

                    }else{
                        MatchPlay.get(getActivity()).setScoreB(MatchPlay.get(getActivity()).getScoreB()+1);

                    }
                    //tests to verify winners
                    //Toast.makeText(getActivity(), "Main team Score: " + (MatchPlay.get(getActivity()).getScoreA()), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getActivity(), "Player won:" + (MatchPlay.get(getActivity()).getGame(0).getWinner().getFirstName()), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getActivity(), "Player a: " + (MatchPlay.get(getActivity()).getPlayerA().getFirstName()), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getActivity(), "Player b: " + (MatchPlay.get(getActivity()).getPlayerB().getFirstName()), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getActivity(), "Team a #: " + (MatchPlay.get(getActivity()).getTeamA()), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getActivity(), "winner:" + winner.getFirstName(), Toast.LENGTH_SHORT).show();
                    if(MatchPlay.get(getActivity()).getRaceA() <= MatchPlay.get(getActivity()).get(getActivity()).getScoreA()) {
                        Toast.makeText(getActivity(), (MatchPlay.get(getActivity()).getPlayerA().getFirstName()) + " wins.", Toast.LENGTH_SHORT).show();
                        MatchPlay.get(getActivity()).setTeamAScore(MatchPlay.get(getActivity()).getTeamAScore() + 1);
                        if(MatchPlay.get(getActivity()).getMatchTotal()>0) {
                            Toast.makeText(getActivity(), "Match over. Prepare to select a player for next match", Toast.LENGTH_SHORT).show();

                            Intent intent = ChoosePlayerAListActivity.newIntent(getActivity());
                            startActivity(intent);
                        }else{
                            Toast.makeText(getActivity(), "Team Match over. Score is: Your Team: " + MatchPlay.get(getActivity()).getTeamAScore()
                                    + " - Theirs: " + MatchPlay.get(getActivity()).getTeamBScore(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(getActivity(), "Results have been sent to Database. Select another team...", Toast.LENGTH_SHORT);
                            Intent intent = new Intent(getActivity(), TeamListActivity.class);
                            intent.putExtra("playerSent", MainPlayer.get(getActivity()).getMainPlayer());
                            startActivity(intent);
                        }


                    }else if(MatchPlay.get(getActivity()).getRaceB() <= MatchPlay.get(getActivity()).get(getActivity()).getScoreB()) {
                        Toast.makeText(getActivity(), (MatchPlay.get(getActivity()).getPlayerB().getFirstName()) + " wins.", Toast.LENGTH_SHORT).show();
                        MatchPlay.get(getActivity()).setTeamBScore(MatchPlay.get(getActivity()).getTeamBScore() + 1);
                        if(MatchPlay.get(getActivity()).getMatchTotal()>0) {
                            Toast.makeText(getActivity(), "Match over. Prepare to select a player for next match", Toast.LENGTH_SHORT).show();

                            Intent intent = ChoosePlayerAListActivity.newIntent(getActivity());
                            startActivity(intent);
                        }else{
                            Toast.makeText(getActivity(), "Team Match over. Score is: Your Team: " + MatchPlay.get(getActivity()).getTeamAScore()
                                    + " - Theirs: " + MatchPlay.get(getActivity()).getTeamBScore(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), TeamListActivity.class);
                            intent.putExtra("playerSent", MainPlayer.get(getActivity()).getMainPlayer());
                            startActivity(intent);
                        }
                    }else{
                        Intent intent = GameActivity.newIntent(getActivity());
                        startActivity(intent);
                    }
                }


            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                turn = 1;
                innings = 0;
                homeBallsMade = 0;
                awayBallsMade = 0;
                homeTimeout = true;
                awayTimeout = true;
                homeSafety = 0;
                awaySafety = 0;
                mBtnHome.setEnabled(true);
                mBtnAway.setEnabled(true);
                mBtnOne.setEnabled(true);
                mBtnTwo.setEnabled(true);
                mBtnThree.setEnabled(true);
                mBtnFour.setEnabled(true);
                mBtnFive.setEnabled(true);
                mBtnSix.setEnabled(true);
                mBtnSeven.setEnabled(true);
                mBtnEight.setEnabled(true);
                mBtnNine.setEnabled(true);
                mBtnTen.setEnabled(true);
                mTextScore.setText("Home Balls Made: " + homeBallsMade +" - Away Balls Made: " + awayBallsMade);
                mTextInning.setText("Inning: " + innings);

            }
        });

        return v;
    }
}
