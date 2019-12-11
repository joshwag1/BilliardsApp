//Screen 6 hosted by ChoosePlayerBListActivity
package com.example.abls2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChoosePlayerBListFragment extends Fragment {
    private RecyclerView mPlayerRecyclerView;
    private PlayerAdapter mAdapter;
    private TextView mGreeting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_player_list, container, false);
        mPlayerRecyclerView = (RecyclerView) view.findViewById(R.id.player_recycler_view);
        mPlayerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mGreeting = (TextView) view.findViewById(R.id.textGreeting);
        updateUI();
        return view;
    }
    private void updateUI(){
        //add list of players here...
        MatchPlay matchPlay = MatchPlay.get(getActivity());
        List<Player2> players;// = matchPlay.getTeamTwoUnused();//replace
        if(matchPlay.isHometeam()){
            players = matchPlay.getTeamTwoUnused();
        }else{
            players = matchPlay.getTeamOneUnused();
        }
        mGreeting.setText("Away Team Select a Player:");
        mAdapter = new PlayerAdapter(players);
        mPlayerRecyclerView.setAdapter(mAdapter);
    }

    //defining viewholder
    private class PlayerHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Player2 mPlayer;
        private TextView mPlayerNameTextView;
        private TextView mPlayerRankTextView;


        public PlayerHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_player, parent, false));
            itemView.setOnClickListener(this);

            mPlayerNameTextView = (TextView) itemView.findViewById(R.id.player_name);
            mPlayerRankTextView = (TextView) itemView.findViewById(R.id.player_rank);

        }

        @Override
        public void onClick(View view){
            if(MatchPlay.get(getActivity()).isHometeam()) {
                MatchPlay.get(getActivity()).usePlayerTeamTwo(mPlayer);

            }else {
                MatchPlay.get(getActivity()).usePlayerTeamOne(mPlayer);
            }
            MatchPlay.get(getActivity()).setScoreB(0);

            //set intents
            Intent intent = MatchInfoActivity.newIntent(getActivity());
            startActivity(intent);

        }

        public void bind(Player2 player){
            mPlayer = player;
            mPlayerNameTextView.setText("Name: " + mPlayer.getFirstName() + " " + mPlayer.getLastName());
            mPlayerRankTextView.setText("Rank: " + mPlayer.get_TenBallSkill());
        }
    }

    //defining the adapter
    private class PlayerAdapter extends RecyclerView.Adapter<PlayerHolder>{
        private List<Player2> mPlayers;
        public PlayerAdapter(List<Player2> players){ mPlayers = players; }
        @Override
        public PlayerHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new PlayerHolder(layoutInflater,parent);
        }
        @Override
        public void onBindViewHolder(PlayerHolder holder, int position){
            Player2 player = mPlayers.get(position);
            holder.bind(player);
        }
        @Override
        public int getItemCount(){
            return mPlayers.size();
        }
    }
    public void returnResult(){
        getActivity().setResult(Activity.RESULT_OK, null);
    }
}