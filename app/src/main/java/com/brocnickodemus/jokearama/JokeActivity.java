package com.brocnickodemus.jokearama;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by Broc on 10/30/17.
 */

public class JokeActivity extends SingleFragmentActivity {

    private static final String EXTRA_JOKE_ID = "com.brocnickodemus.jokearama.joke_id";

    public static Intent newIntent(Context packageContext, UUID jokeId) {
        Intent intent = new Intent(packageContext, JokeActivity.class);
        intent.putExtra(EXTRA_JOKE_ID, jokeId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID jokeId = (UUID) getIntent().getSerializableExtra(EXTRA_JOKE_ID);
        return JokeFragment.newInstance(jokeId);
    }
}

