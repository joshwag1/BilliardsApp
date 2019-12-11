//Screen 3- after player has selected their team - they can view their roster, matches, or go to score keeping.
package com.example.abls2;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;


public class TeamActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context packageContext, int teamId){
        Intent intent = new Intent(packageContext, TeamActivity.class);
        intent.putExtra("TEAM_ID", teamId);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        int teamId = (int) getIntent().getSerializableExtra("TEAM_ID");
        return TeamFragment.newInstance(teamId);
    }
}
