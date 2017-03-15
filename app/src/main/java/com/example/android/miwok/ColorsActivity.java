package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    AudioManager.OnAudioFocusChangeListener audioFocusListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            } else if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            }
        }
    };
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    private AudioManager audioManager;

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
        audioManager.abandonAudioFocus(audioFocusListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> colorsArray = new ArrayList<>();
        colorsArray.add(new Word("red", "wetteti", R.drawable.color_red, R.raw.color_red));
        colorsArray.add(new Word("green", "chokkoki", R.drawable.color_green, R.raw.color_green));
        colorsArray.add(new Word("brown", "takaakki", R.drawable.color_brown, R.raw.color_brown));
        colorsArray.add(new Word("gray", "topoppi", R.drawable.color_gray, R.raw.color_gray));
        colorsArray.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        colorsArray.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        colorsArray.add(new Word("dusty yellow", "toppise", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorsArray.add(new Word("mustard yellow", "chiwiite", R.drawable.color_mustard_yellow, R.raw.color_dusty_yellow));

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        WordAdapter adapter = new WordAdapter(this, colorsArray, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = colorsArray.get(position);
                releaseMediaPlayer();
                int result = audioManager.requestAudioFocus(audioFocusListener, AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioId());

                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(completionListener);
                }
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
