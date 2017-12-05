package com.brocnickodemus.jokearama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Broc on 12/4/17.
 */

public class JokeFragment extends Fragment {
    private static final String ARG_JOKE_ID = "joke_id"; // public

    public Joke mJoke; // private
    private TextView mKnockTextView;

    public static JokeFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_JOKE_ID, crimeId);

        JokeFragment fragment = new JokeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_JOKE_ID);
        mJoke = JokeStorage.get(getActivity()).getJoke(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.joke, container, false);

        mKnockTextView = (TextView) v.findViewById(R.id.knock);
        mKnockTextView.setText(mJoke.getTitle().toString());

        return v;
    }
}
