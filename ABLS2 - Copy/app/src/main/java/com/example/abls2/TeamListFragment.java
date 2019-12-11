//Screen 2- hosted by TeamListActivity
package com.example.abls2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TeamListFragment extends Fragment {
    private RecyclerView mTeamRecyclerView;
    private TeamAdapter mAdapter;//setting the adapter to connect to recycle view



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_team_list, container, false);
        mTeamRecyclerView = (RecyclerView) view.findViewById(R.id.team_recycler_view);
        mTeamRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        updateUI();

        return view;


    }

    private void updateUI(){
        TeamList teamList = TeamList.get(getActivity());
        List<Team> teams = teamList.getTeams();
        mAdapter = new TeamAdapter(teams);
        mTeamRecyclerView.setAdapter(mAdapter);
    }

    //defining the viewholder
    private class TeamHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Team mTeam;
        private TextView mTeamNameTextView;
        private TextView mTeamPointsTextView;

        public TeamHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_team, parent, false));
            itemView.setOnClickListener(this);

            mTeamNameTextView = (TextView) itemView.findViewById(R.id.team_name2);
            mTeamPointsTextView = (TextView) itemView.findViewById(R.id.team_points2);

        }

        @Override
        public void onClick(View view){

            Intent intent = TeamActivity.newIntent(getActivity(), mTeam.getID());
            startActivity(intent);
        }

        //called each time a new Team should be displayed in your Crimeholder.
        public void bind(Team team){
            mTeam = team;
            mTeamNameTextView.setText("Name: " + mTeam.getTeamName());
            mTeamPointsTextView.setText("Team Points:" + mTeam.getTeamPoints() + "   -   " + "Team Number: " + mTeam.getTeamNumber());
        }
    }
    //defining the adapter
    private class TeamAdapter extends RecyclerView.Adapter<TeamHolder>{
        private List<Team> mTeams;
        public TeamAdapter(List<Team> teams){
            mTeams = teams;
        }
        @Override
        public TeamHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new TeamHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(TeamHolder holder, int position){
            Team team = mTeams.get(position);
            holder.bind(team);

        }
        @Override
        public int getItemCount(){
            return mTeams.size();
        }
    }
    public void returnResult(){
        getActivity().setResult(Activity.RESULT_OK, null);
    }
}
