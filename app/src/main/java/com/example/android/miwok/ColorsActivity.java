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
        colorsArray.add(new Word("red", "wetteti", R.drawable.color_red));
        colorsArray.add(new Word("green", "chokkoki", R.drawable.color_green));
        colorsArray.add(new Word("brown", "takaakki", R.drawable.color_brown));
        colorsArray.add(new Word("gray", "topoppi", R.drawable.color_gray));
        colorsArray.add(new Word("black", "kululli", R.drawable.color_black));
        colorsArray.add(new Word("white", "kelelli", R.drawable.color_white));
        colorsArray.add(new Word("dusty yellow", "toppise", R.drawable.color_dusty_yellow));
        colorsArray.add(new Word("mustard yellow", "chiwiite", R.drawable.color_mustard_yellow));


        WordAdapter adapter = new WordAdapter(this, colorsArray);

        GridView gridView = (GridView) findViewById(R.id.list);

        gridView.setAdapter(adapter);

    }
}
