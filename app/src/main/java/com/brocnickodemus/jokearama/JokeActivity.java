package com.brocnickodemus.jokearama;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Broc on 10/30/17.
 */

public class JokeActivity extends AppCompatActivity{
    private Joke mJoke;

    private TextView mKnockTextView;
    private TextView mWhosThereTextView;
    private TextView mResponseTextView;
    private TextView mResponseWhoTextView;
    private TextView mAnswerTextView;

    private static final String EXTRA_JOKE_ID = "com.brocnickodemus.criminalintent.joke_id";
    //bundle args

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.joke);

        /*
        mJoke = JokeLab.get(this).getJoke();
        String[] text = mJoke.getText();

        mKnockTextView.setText(text[0].toString());
        mWhosThereTextView.setText(text[0].toString());
        mResponseTextView.setText(text[0].toString());
        mResponseWhoTextView.setText(text[0].toString());
        mAnswerTextView.setText(text[0].toString());
        */
    }

    public static Intent newIntent(Context packageContext, UUID jokeId) {
        Intent intent = new Intent(packageContext, JokeActivity.class);
        intent.putExtra(EXTRA_JOKE_ID, jokeId);
        return intent;
    }

}
