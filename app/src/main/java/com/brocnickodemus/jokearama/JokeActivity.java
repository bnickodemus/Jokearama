package com.brocnickodemus.jokearama;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Broc on 10/30/17.
 */

public class JokeActivity extends AppCompatActivity {

    private static final String EXTRA_JOKE_ID = "com.brocnickodemus.jokearama.joke_id";

    public Joke mJoke; // private
    private TextView mKnockTextView;
    private TextView mWhosThereTextView;
    private TextView mResponseTextView;
    private TextView mResponseWhoTextView;
    private TextView mAnswerTextView;
    int numTimesClicked = 0;

    // add joke id to the intent extra
    public static Intent newIntent(Context packageContext, UUID jokeId) {
        Intent intent = new Intent(packageContext, JokeActivity.class);
        intent.putExtra(EXTRA_JOKE_ID, jokeId);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke);

        UUID jokeId = (UUID) getIntent().getSerializableExtra(EXTRA_JOKE_ID);
        mJoke = JokeStorage.get(this).getJoke(jokeId);

        mKnockTextView = (TextView) findViewById(R.id.knock);
        mWhosThereTextView = (TextView) findViewById(R.id.whos_there);
        mResponseTextView = (TextView) findViewById(R.id.response);
        mResponseWhoTextView = (TextView) findViewById(R.id.response_who);
        mAnswerTextView = (TextView) findViewById(R.id.answer);
        //mKnockTextView.setText(mJoke.getTitle().toString());

        View view = (View) this.findViewById(android.R.id.content);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] text = mJoke.getText();

                switch(numTimesClicked) {
                    case (0):
                        mKnockTextView.setText(text[0].toString());
                        break;
                    case (1):
                        mWhosThereTextView.setText(text[1].toString());
                        break;
                    case (2):
                        mResponseTextView.setText(text[2].toString());
                        break;
                    case (3):
                        mResponseWhoTextView.setText(text[3].toString());
                        break;
                    default:
                        mAnswerTextView.setText(text[4].toString());
                }
                numTimesClicked++;
            }
        });
    }

}

