package com.example.android.miwok;

/**
 * Created by Nicolas Maldonado on 04/03/2017.
 */

public class Word {

    private String miwokWord;
    private String defaultWord;

    public Word(String miwok, String defaultTranslation){
        miwokWord = miwok;
        defaultWord = defaultTranslation;
    }

    public String getMiwokWord(){
        return miwokWord;
    }

    public String getDefaultWord(){
        return defaultWord;
    }
}
