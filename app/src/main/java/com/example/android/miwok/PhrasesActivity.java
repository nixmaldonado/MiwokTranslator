package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> wordArray = new ArrayList<>();
        wordArray.add(new Word("Where are you going?", "minto wuksus"));
        wordArray.add(new Word("What is your name?", "tinnә oyaase'nә"));
        wordArray.add(new Word("My name is...", "oyaaset..."));
        wordArray.add(new Word("How are you feeling?", "michәksәs?"));
        wordArray.add(new Word("I’m feeling good.", "kuchi achit"));
        wordArray.add(new Word("Are you coming?", "әәnәs'aa?"));
        wordArray.add(new Word("Yes, I’m coming.", "hәә’ әәnәm"));
        wordArray.add(new Word("I’m coming.", "әәnәm"));
        wordArray.add(new Word("Let’s go.", "yoowutis"));
        wordArray.add(new Word("Come here.", "әnni'nem"));


        WordAdapter adapter = new WordAdapter(this, wordArray, R.color.category_phrases);

        GridView gridView = (GridView) findViewById(R.id.list);

        gridView.setAdapter(adapter);

    }
}
