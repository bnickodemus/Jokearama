package com.brocnickodemus.jokearama;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

/**
 * Created by Broc on 10/30/17.
 */

public class JokeActivity extends AppCompatActivity{
    private List<Joke> mJokes;

    private static final String EXTRA_JOKE_ID = "com.brocnickodemus.criminalintent.joke_id";

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.fragment_joke);

        mJokes = JokeLab.get(this).getJokes();

        /*FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        JokeFragment fragment = new JokeFragment();
        fragmentTransaction.add(R.id.fragment_joke, fragment);
        fragmentTransaction.commit();*/
    }

    public static Intent newIntent(Context packageContext, UUID jokeId) {
        Intent intent = new Intent(packageContext, JokeActivity.class);
        intent.putExtra(EXTRA_JOKE_ID, jokeId);
        return intent;
    }

}
