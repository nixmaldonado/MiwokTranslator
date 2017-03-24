package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {

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
    private AudioManager audioManager;
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    public FamilyFragment() {
        // Required empty public constructor
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

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

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

        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        WordAdapter adapter = new WordAdapter(getActivity(), wordArray, R.color.category_family);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = wordArray.get(position);
                releaseMediaPlayer();
                int result = audioManager.requestAudioFocus(audioFocusListener, AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mediaPlayer = MediaPlayer.create(getActivity(), word.getAudioId());

                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(completionListener);
                }

            }
        });


        return rootView;
    }

}
