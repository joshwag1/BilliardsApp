//Screen 4.1 hosted by ScoreActivity
package com.example.abls2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;


public class ScoreFragment extends Fragment {
    private static final String ARG_TEAM_ID = "team_id";
    private static final String ARG_TEAM_ID_2 = "other_team_id";
    private static final String TEAM_ONE_ROSTER = "team_one_roster";
    private static final String TEAM_TWO_ROSTER = "team_two_roster";
    int teamTwoId;
    private Team mTeam;//**
    private String teamOneRoster;
    private String teamTwoRoster;
    private TextView mName;
    private Button mViewRosterBtn;
    private Button mStartMatch;





    public static ScoreFragment newInstance(int teamId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_TEAM_ID, teamId);
        ScoreFragment fragment = new ScoreFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public static ScoreFragment newInstance2(int teamId, int teamTwoId, String teamOne, String teamTwo){
        Bundle args = new Bundle();
        args.putSerializable(ARG_TEAM_ID, teamId);
        args.putSerializable(ARG_TEAM_ID_2, teamTwoId);
        args.putSerializable(TEAM_ONE_ROSTER, teamOne);
        args.putSerializable(TEAM_TWO_ROSTER, teamTwo);
        ScoreFragment fragment = new ScoreFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        int teamId = (int) getArguments().getSerializable(ARG_TEAM_ID);
        teamTwoId = (int) getArguments().getSerializable(ARG_TEAM_ID_2);
        teamOneRoster = (String) getArguments().getSerializable(TEAM_ONE_ROSTER);
        teamTwoRoster = (String) getArguments().getSerializable(TEAM_TWO_ROSTER);
        mTeam = TeamList.get(getActivity()).getTeam(teamId);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_score, container, false);
        MatchPlay matchPlay = MatchPlay.get(getActivity());//start Match

        mName = (TextView) v.findViewById(R.id.team_name);
        mViewRosterBtn = (Button) v.findViewById(R.id.view_roster);
        mStartMatch = (Button) v.findViewById(R.id.start_match);



        mName.setText("Team " + mTeam.getTeamName() + " - Team ID: " + mTeam.getID() + " - Points: " + mTeam.getTeamPoints());
        mViewRosterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = RosterActivity.newIntent(getActivity(), teamTwoId);//mTeam.getID());
                startActivity(intent);

            }
        });
        mStartMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //pair players and start a game
                MatchPlay.get(getActivity()).setBothTeamScores(0,0);
                Intent intent = ChoosePlayerAListActivity.newIntent(getActivity());
                startActivity(intent);
            }
        });
        return v;
    }

}
