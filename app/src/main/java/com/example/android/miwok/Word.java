package com.example.android.miwok;

/**
 * Created by Nicolas Maldonado on 04/03/2017.
 */

public class Word {

    private static final int NO_IMAGE_PROVIDED = -1;
    private String miwokWord;
    private String defaultWord;
    private int audioId;
    private int resourceId = NO_IMAGE_PROVIDED;

    public Word(String defaultTranslation, String miwok, int audioSource) {
        miwokWord = miwok;
        defaultWord = defaultTranslation;
        audioId = audioSource;
    }

    public Word(String defaultTranslation, String miwok, int image, int audioSource) {
        miwokWord = miwok;
        resourceId = image;
        defaultWord = defaultTranslation;
        audioId = audioSource;
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

    public int getAudioId() {
        return audioId;
    }

    public boolean hasImage() {
        return resourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "miwokWord='" + miwokWord + '\'' +
                ", defaultWord='" + defaultWord + '\'' +
                ", audioId=" + audioId +
                ", resourceId=" + resourceId +
                '}';
    }
}
