package com.brocnickodemus.jokearama;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Broc on 10/30/17.
 */

public class JokeStorage {

    private static JokeStorage sJokeStorage;
    private List<Joke> mJokes;

    public static JokeStorage get(Context context) {
        if (sJokeStorage == null) {
            sJokeStorage = new JokeStorage(context);
        }
        return sJokeStorage;
    }

    private JokeStorage(Context context) {
        mJokes = new ArrayList<Joke>();
        String[] text = new String[5];
        text[0] = "Knock knock. ";
        text[1] = "Who's there? ";
        text[2] = "Kotlin. ";
        text[3] = "Kotlin who? ";
        text[4] = "Kotlin the language, you fool!";

        for (int i = 0; i < 100; i++) {
            Joke joke = new Joke();
            joke.setTitle("Joke " + i);
            joke.setText(text);
            mJokes.add(joke);
        }
    }

    public List<Joke> getJokes() {
        return mJokes;
    }

    public Joke getJoke(UUID id) {
        for (Joke joke : mJokes) {
            if (joke.getId().equals(id)) {
                return joke;
            }
        }
        return null;
    }
}
