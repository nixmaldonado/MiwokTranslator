package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> wordArray = new ArrayList<>();
        wordArray.add(new Word("father", "әpә"));
        wordArray.add(new Word("mother", "әṭa"));
        wordArray.add(new Word("son", "angsi"));
        wordArray.add(new Word("daughter", "tune"));
        wordArray.add(new Word("older brother", "taachi"));
        wordArray.add(new Word("younger brother", "chalitti"));
        wordArray.add(new Word("older sister", "teṭe"));
        wordArray.add(new Word("younger sister", "kolliti"));
        wordArray.add(new Word("grandmother", "ama"));
        wordArray.add(new Word("grandfather", "paapa"));


        WordAdapter adapter = new WordAdapter(this, wordArray);

        GridView gridView = (GridView) findViewById(R.id.list);

        gridView.setAdapter(adapter);

    }
}
