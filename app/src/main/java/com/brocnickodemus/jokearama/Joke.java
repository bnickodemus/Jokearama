package com.brocnickodemus.jokearama;

import java.util.UUID;

/**
 * Created by Broc on 10/30/17.
 */

public class Joke {
    private UUID mId;
    private String mTitle;
    private String[] mText;

    public Joke() {
        mId = UUID.randomUUID();
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
}
