//Screen 3- hosted by TeamActivity
package com.example.abls2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class TeamFragment extends Fragment {
    private static final String ARG_TEAM_ID = "team_id";
    private Team mTeam;
    private Button mViewTeamBtn;
    private Button mViewRosterBtn;
    private Button mKeepScore;
    private Button mViewMatch;
    private TextView mTextID;
    private TextView mName;

    public static TeamFragment newInstance(int teamId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_TEAM_ID, teamId);

        TeamFragment fragment = new TeamFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        int teamId = (int) getArguments().getSerializable(ARG_TEAM_ID);
        mTeam = TeamList.get(getActivity()).getTeam(teamId);
    }
    
    //inflate the fragments view by calling LayoutInflater.inflate() and pass in the layout resrouce id, pass in false because we will add in the activity's code.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        //retrieving the extra and fetching the team.
        View v = inflater.inflate(R.layout.fragment_team, container, false);
        
        //wiring the buttons from fragment_team.xml
        mViewRosterBtn = (Button) v.findViewById(R.id.view_roster);
        mTextID = (TextView) v.findViewById(R.id.team_id);
        mName = (TextView) v.findViewById(R.id.team_name);
        mKeepScore = (Button) v.findViewById(R.id.keep_score);
        mViewMatch = (Button) v.findViewById(R.id.view_matches);

        mName.setText("Team " + mTeam.getTeamName() + " - Team ID: " + mTeam.getID() + " - Points: " + mTeam.getTeamPoints());

        mViewRosterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = RosterActivity.newIntent(getActivity(), mTeam.getID());
                startActivity(intent);

            }
        });

        mKeepScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ScoreActivity.newIntent(getActivity(), mTeam.getID());
                startActivity(intent);
            }
        });
        mViewMatch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), MatchListActivity.class);
                startActivity(intent);
            }

        });


        
        return v;
    }
}
