//Screen 4.2 & 5.2 hosted by RosterActivity
package com.example.abls2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;


public class RosterFragment extends Fragment {

    private static final String ARG_TEAM_ID = "team_id";
    private Team mTeam;
    private TextView mRoster;
    private String rosterString = "";


    public static RosterFragment newInstances(int teamId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_TEAM_ID, teamId);
        RosterFragment fragment = new RosterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //bundle up the arguments
    public static RosterFragment newInstance(String teamRoster){
        Bundle args = new Bundle();
        args.putSerializable(ARG_TEAM_ID, teamRoster);
        RosterFragment fragment = new RosterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        String teamId = (String) getArguments().getSerializable(ARG_TEAM_ID);
        rosterString = teamId;
        //mTeam = TeamList.get(getActivity()).getTeam(teamId);

    }

    //inflate the frag
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_roster, container, false);
        mRoster = (TextView) v.findViewById(R.id.textRoster);
        //Parsing the roster string fragment to look pretty on screen
        rosterString = rosterString.replaceAll("\\}", "\n\n");
        rosterString = rosterString.replaceAll("\\{", "");
        rosterString = rosterString.replaceAll("\"", "");
        rosterString = rosterString.replaceAll(",LastName:", " ");
        rosterString = rosterString.replaceAll("First", "");
        rosterString = rosterString.replaceAll("10BallSkill", "10 Ball Skill");
        rosterString = rosterString.replaceAll(",", ", ");
        rosterString = rosterString.replaceAll("NickName:,", "No NickName,");
        rosterString = rosterString.replaceAll("PlayerNum", "Player Number");
        rosterString = rosterString.replaceAll(":", ": ");
        mRoster.setText(rosterString);
        return v;
    }
}
