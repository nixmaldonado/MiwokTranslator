package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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
        final ArrayList<Word> wordArray = new ArrayList<>();
        wordArray.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        wordArray.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        wordArray.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        wordArray.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        wordArray.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        wordArray.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        wordArray.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        wordArray.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        wordArray.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        wordArray.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));


        WordAdapter adapter = new WordAdapter(this, wordArray, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = wordArray.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioId());

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
