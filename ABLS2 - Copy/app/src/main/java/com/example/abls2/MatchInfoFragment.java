//Screen 7- hosted by MatchInfoActivity
package com.example.abls2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MatchInfoFragment extends Fragment {
    private Button mStartGame;
    private TextView mPlayerA;
    private TextView mPlayerB;
    public static MatchInfoFragment newInstance(){
        Bundle args = new Bundle();

        MatchInfoFragment fragment = new MatchInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        MatchPlay.get(getActivity()).setMatchTotal(MatchPlay.get(getActivity()).getMatchTotal() -1);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_match_info, container, false);
        mStartGame = (Button) v.findViewById(R.id.game_start);
        mPlayerA = (TextView) v.findViewById(R.id.player_a);
        mPlayerB = (TextView) v.findViewById(R.id.player_b);


        mPlayerA.setText("Team Number: " + MatchPlay.get(getActivity()).getTeamA() + " - Member Number: " + MatchPlay.get(getActivity()).getPlayerA().getPlayerNum() +
                " - Player Name: " + MatchPlay.get(getActivity()).getPlayerA().getFirstName() + " " + MatchPlay.get(getActivity()).getPlayerA().getLastName() +
                " - Rank: " + MatchPlay.get(getActivity()).getPlayerA().get_TenBallSkill() + " - Race: "  + MatchPlay.get(getActivity()).getRaceA() + " - Match Score: " + MatchPlay.get(getActivity()).getScoreA() + " - Team Points: "
        + MatchPlay.get(getActivity()).getTeamAScore() + "\n");
        mPlayerB.setText("Team Number: " + MatchPlay.get(getActivity()).getTeamB() + " - Member Number: " + MatchPlay.get(getActivity()).getPlayerB().getPlayerNum() +
                " - Player Name: " + MatchPlay.get(getActivity()).getPlayerB().getFirstName() + " " + MatchPlay.get(getActivity()).getPlayerB().getLastName() +
                " - Rank: " + MatchPlay.get(getActivity()).getPlayerB().get_TenBallSkill() + " - Race: "  + MatchPlay.get(getActivity()).getRaceB() +
                " - Match Score: " + MatchPlay.get(getActivity()).getScoreB() + " - Team Points: "
                + MatchPlay.get(getActivity()).getTeamBScore() + "\n");

        mStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MatchPlay.get(getActivity()).setBothScores(0,0);
                Intent intent = GameActivity.newIntent(getActivity());
                startActivity(intent);

            }
        });
        return v;
    }
}
