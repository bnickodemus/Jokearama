package com.brocnickodemus.jokearama;

import android.support.v4.app.Fragment;

/**
 * Created by Broc on 12/4/17.
 */

public class JokeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new JokeListFragment();
    }
}
