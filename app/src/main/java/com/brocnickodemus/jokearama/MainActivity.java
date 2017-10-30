package com.brocnickodemus.jokearama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    }
}
