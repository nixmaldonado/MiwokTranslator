package com.example.android.miwok;

/**
 * Created by Nicolas Maldonado on 04/03/2017.
 */

public class Word {

    private String miwokWord;
    private String defaultWord;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int resourceId = NO_IMAGE_PROVIDED;

    public Word(String defaultTranslation, String miwok) {
        miwokWord = miwok;
        defaultWord = defaultTranslation;
    }

    public Word(String defaultTranslation, String miwok, int image) {
        miwokWord = miwok;
        resourceId = image;
        defaultWord = defaultTranslation;
    }

    public String getMiwokWord() {
        return miwokWord;
    }

    public String getDefaultWord() {
        return defaultWord;
    }

    public int getResourceId() {
        return resourceId;
    }

    public boolean hasImage() {
        return resourceId != NO_IMAGE_PROVIDED;
    }
}
