//Screen 6 allows away team to select a player, also recycled everytime a new away player needs to be selected.
package com.example.abls2;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class ChoosePlayerBListActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, ChoosePlayerBListActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new ChoosePlayerBListFragment();
    }
}
