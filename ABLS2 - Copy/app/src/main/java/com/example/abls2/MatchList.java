//Singleton to hold the list of matches for a given team.. regenerates when a new team is selected.
package com.example.abls2;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class MatchList {
    private static MatchList sMatchList;
    private List<Match> mMatches;

    public static MatchList get(Context context){
        if(sMatchList == null){
            sMatchList = new MatchList(context);
        }
        return sMatchList;
    }

    private MatchList(Context context){
        mMatches = new ArrayList<>();
    }

    public void addMatch(Match a){
        mMatches.add(a);
    }

    public List<Match> getMatches(){
        return mMatches;
    }

    public Match getMatch(int id){
        for(Match match : mMatches){
            if (match.getHomeTeam() == id){
                return match;
            }
        }
        for(Match match : mMatches){
            if (match.getAwayTeam()== id){
                return match;
            }
        }
        return null;
    }
}
