//singleton to keep track of teams MainPlayer is on.page 159, 160
package com.example.abls2;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class TeamList {
    private static TeamList sTeamList;
    private List<Team> mTeams;

    public static TeamList get(Context context){
        if(sTeamList == null){
            sTeamList = new TeamList(context);
        }
        return sTeamList;
    }
    private TeamList(Context context){

        mTeams = new ArrayList<>();
    }
    public void addTeam(Team c){
        mTeams.add(c);
    }

    public List<Team> getTeams(){
        return mTeams;
    }

    public Team getTeam(int id){
        for(Team team : mTeams){
            if (team.getID() == id){
                return team;
            }
        }
        return null;
    }
}
