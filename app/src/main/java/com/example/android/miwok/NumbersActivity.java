package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<Word> numbersArray = new ArrayList<Word>();
        numbersArray.add(new Word("one", "lutti"));
        numbersArray.add(new Word("two", "otiiko"));
        numbersArray.add(new Word("three", "tolookosu"));
        numbersArray.add(new Word("four", "oyyisa"));
        numbersArray.add(new Word("five", "massokka"));
        numbersArray.add(new Word("six", "temmokka"));
        numbersArray.add(new Word("seven", "kenekaku"));
        numbersArray.add(new Word("eight", "kawinta"));
        numbersArray.add(new Word("nine", "wo’e"));
        numbersArray.add(new Word("ten", "na’aacha"));


        WordAdapter adapter = new WordAdapter(this, numbersArray);

        GridView gridView = (GridView) findViewById(R.id.list);

        gridView.setAdapter(adapter);

    }

    }
