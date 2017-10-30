package com.brocnickodemus.jokearama;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;
import java.util.UUID;

/**
 * Created by Broc on 10/30/17.
 */

public class JokeActivity {
    private List<Joke> mJokes;

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, JokeActivity.class);
        return intent;
    }

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_joke);
    }*/
}
