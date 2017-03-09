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
        wordArray.add(new Word("father", "әpә",R.drawable.family_father));
        wordArray.add(new Word("mother", "әṭa", R.drawable.family_mother));
        wordArray.add(new Word("son", "angsi", R.drawable.family_son));
        wordArray.add(new Word("daughter", "tune", R.drawable.family_daughter));
        wordArray.add(new Word("older brother", "taachi", R.drawable.family_older_brother));
        wordArray.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother));
        wordArray.add(new Word("older sister", "teṭe", R.drawable.family_older_sister));
        wordArray.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister));
        wordArray.add(new Word("grandmother", "ama", R.drawable.family_grandmother));
        wordArray.add(new Word("grandfather", "paapa", R.drawable.family_grandfather));


        WordAdapter adapter = new WordAdapter(this, wordArray);

        GridView gridView = (GridView) findViewById(R.id.list);

        gridView.setAdapter(adapter);

    }
}
