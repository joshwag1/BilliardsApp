//Screen 4.3 - allows user to view all matches for the night
package com.example.abls2;

import androidx.fragment.app.Fragment;
import java.util.concurrent.ExecutionException;

public class MatchListActivity extends SingleFragmentActivity {
    String matches;

    @Override
    protected Fragment createFragment(){
        try{
            matches = new Background(getApplicationContext()).execute("matches", Integer.toString(MainPlayer.get(getApplicationContext()).getMainPlayer().getPlayerNum()), "").get();

        }catch(ExecutionException | InterruptedException ei){
            ei.printStackTrace();
        }
        return new MatchListFragment();
    }
}