package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> numbersArray = new ArrayList<>();
        numbersArray.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        numbersArray.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        numbersArray.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        numbersArray.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        numbersArray.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        numbersArray.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        numbersArray.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbersArray.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbersArray.add(new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        numbersArray.add(new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));


        WordAdapter adapter = new WordAdapter(this, numbersArray, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = numbersArray.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioId());

                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(completionListener);

            }
        });
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

    }
