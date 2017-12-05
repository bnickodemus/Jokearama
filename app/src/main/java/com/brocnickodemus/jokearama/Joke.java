package com.brocnickodemus.jokearama;

import java.util.UUID;

/**
 * Created by Broc on 10/30/17.
 */

public class Joke {
    private UUID mId;
    private String mTitle;
    private String[] mText;
    private boolean mCompleted;

    public Joke() {
        mId = UUID.randomUUID();
        mCompleted = false;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String[] getText() {
        return mText;
    }

    public void setText(String[] text) {
        mText = text;
    }

    public boolean getCompleted() {
        return mCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        mCompleted = isCompleted;
    }
}
