//Screen 5: allows home team to select a player to play a match, also recycled every time a new home team player needs to be selected for a new player match
package com.example.abls2;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class ChoosePlayerAListActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, ChoosePlayerAListActivity.class);
        return intent;
    }
    @Override
    protected Fragment createFragment(){ return new ChoosePlayerAListFragment(); }
}
