//Screen 8 Where actual game scoring takes place, recycles every time a new game begins
package com.example.abls2;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class GameActivity extends SingleFragmentActivity {
    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, GameActivity.class);
        return intent;
    }
    @Override
    protected Fragment createFragment(){

        return GameFragment.newInstance();
    }
}
