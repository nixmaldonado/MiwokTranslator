package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> colorsArray = new ArrayList<>();
        colorsArray.add(new Word("red", "wetteti"));
        colorsArray.add(new Word("green", "chokkoki"));
        colorsArray.add(new Word("brown", "takaakki"));
        colorsArray.add(new Word("gray", "topoppi"));
        colorsArray.add(new Word("black", "kululli"));
        colorsArray.add(new Word("white", "kelelli"));
        colorsArray.add(new Word("dusty yellow", "toppise"));
        colorsArray.add(new Word("mustard yellow", "chiwiite"));


        WordAdapter adapter = new WordAdapter(this, colorsArray);

        GridView gridView = (GridView) findViewById(R.id.list);

        gridView.setAdapter(adapter);

    }
}
