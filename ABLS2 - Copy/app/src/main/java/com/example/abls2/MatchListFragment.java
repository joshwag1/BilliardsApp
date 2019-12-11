//Screen 4.3 hosted by MatchListActivity
package com.example.abls2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MatchListFragment extends Fragment {
    private RecyclerView mMatchRecyclerView;
    private MatchAdapter mAdapter;
    private static final String MATCHES = "matches";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_match_list, container, false);
        mMatchRecyclerView = (RecyclerView) view.findViewById(R.id.match_recycler_view);
        mMatchRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private void updateUI(){
        MatchList matchlist = MatchList.get(getActivity());
        List<Match> matches = matchlist.getMatches();
        mAdapter = new MatchAdapter(matches);
        mMatchRecyclerView.setAdapter(mAdapter);
    }
    //defining the viewholder
    private class MatchHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Match mMatch;
        private TextView mMatchTeam;
        private TextView mMatchTeamHome;

        public MatchHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_match, parent, false));
            itemView.setOnClickListener(this);

            mMatchTeamHome = (TextView) itemView.findViewById(R.id.match_name);
            mMatchTeam = (TextView) itemView.findViewById(R.id.match_points);
        }
        @Override
        public void onClick(View view){

        }
        public void bind(Match match){
            mMatch = match;
            mMatchTeamHome.setText("Home Team ID:" + match.getHomeTeam());
            mMatchTeam.setText("Away Team ID:" + match.getAwayTeam());


        }
    }
    //defining the adapter
    private class MatchAdapter extends RecyclerView.Adapter<MatchHolder> {
        private List<Match> mMatches;

        public MatchAdapter(List<Match> matches) {
            mMatches = matches;
        }

        @Override
        public MatchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new MatchHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(MatchHolder holder, int position) {
            Match match = mMatches.get(position);
            holder.bind(match);
        }

        @Override
        public int getItemCount() {
            return mMatches.size();
        }
    }
    public void returnResult(){
        getActivity().setResult(Activity.RESULT_OK, null);
    }
}
