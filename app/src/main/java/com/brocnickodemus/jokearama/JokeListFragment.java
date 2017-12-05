package com.brocnickodemus.jokearama;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Broc on 10/30/17.
 */

public class JokeListFragment extends Fragment {
    static final int REQUEST_CODE = 1;  // The request code

    private RecyclerView mJokeRecyclerView;
    private JokeAdapter mJokeAdapter;

    private class JokeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Joke mJoke;
        private TextView mTitleTextView;
        private TextView mTextTextView;

        public JokeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_joke, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.joke_title);
        }

        public void bind(Joke joke) {
            mJoke = joke;
            mTitleTextView.setText(mJoke.getTitle().toString() + String.valueOf(mJoke.getCompleted()));
            if (mJoke.getCompleted())
                mTitleTextView.setBackgroundColor(Color.GRAY);
        }

        @Override
        public void onClick(View view) {
            Intent intent = JokeActivity.newIntent(getActivity(), mJoke.getId());
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    private class JokeAdapter extends RecyclerView.Adapter<JokeHolder> {

        private List<Joke> mJokes;

        public JokeAdapter(List<Joke> jokes) {
            mJokes = jokes;
        }

        @Override
        public JokeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new JokeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(JokeHolder holder, int position) {
            Joke joke = mJokes.get(position);
            holder.bind(joke);
        }

        @Override
        public int getItemCount() {
            return mJokes.size();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke_list, container, false);

        mJokeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mJokeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateNumJokes() {
        JokeStorage jokeStorage = JokeStorage.get(getActivity());
        int jokeCount = jokeStorage.getJokes().size();
        //int jokesCompleted = jokeStorage.getCompleted();
        //String numJokesSubtitle = String.format(getString(R.string.num_jokes_subtitle), jokeCount, jokesCompleted);
        //AppCompatActivity activity = (AppCompatActivity) getActivity();
        //activity.getSupportActionBar().setSubtitle(numJokesSubtitle);
    }

    private void updateUI() {
        JokeStorage jokeStorage = JokeStorage.get(getActivity());
        List<Joke> jokes = jokeStorage.getJokes();

        if (mJokeAdapter == null) {
            mJokeAdapter = new JokeAdapter(jokes);
            mJokeRecyclerView.setAdapter(mJokeAdapter);
        } else {
            mJokeAdapter.notifyDataSetChanged();
        }
        updateNumJokes();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
}
