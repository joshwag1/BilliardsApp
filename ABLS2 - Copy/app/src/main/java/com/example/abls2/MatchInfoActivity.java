//Screen 7 allows a players a chance to verify the match information
package com.example.abls2;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class MatchInfoActivity extends SingleFragmentActivity {
    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, MatchInfoActivity.class);
        return intent;
    }
    @Override
    protected Fragment createFragment(){

        return MatchInfoFragment.newInstance();
    }
}
