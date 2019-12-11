//Screen 2 - Lists all teams the signed in player is apart of.
package com.example.abls2;


import androidx.fragment.app.Fragment;

public class TeamListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new TeamListFragment();
    }
}
