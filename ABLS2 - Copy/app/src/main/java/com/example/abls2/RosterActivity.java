//Screen 4.2- allows user to view their team, Also Screen 5.2 recycled to allow user to view other teams roster
package com.example.abls2;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import java.util.concurrent.ExecutionException;

public class RosterActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context packageContext, int teamId){
        Intent intent = new Intent(packageContext, RosterActivity.class);
        intent.putExtra("TEAM_ID", teamId);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        int teamId = (int) getIntent().getSerializableExtra("TEAM_ID");
        String recRoster = "";
        try{
            recRoster = new Background(getApplicationContext()).execute("playerList", Integer.toString(teamId), "").get();
        }catch(ExecutionException | InterruptedException ei){
            ei.printStackTrace();
        }
        return RosterFragment.newInstance(recRoster);
    }
}
