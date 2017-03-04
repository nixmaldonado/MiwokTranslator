package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter {

    public WordAdapter(Context c, ArrayList<Word> words){
        super(c, 0, words);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View contentView = convertView;
        if (contentView == null){
            contentView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        Word currentWord = (Word) getItem(position);

        TextView miwokWordTextView = (TextView) contentView.findViewById(R.id.miwok_text);
        miwokWordTextView.setText(currentWord.getMiwokWord());

        TextView defaultWordTextView = (TextView) contentView.findViewById(R.id.default_text);
        defaultWordTextView.setText(currentWord.getDefaultWord());

        return contentView;
    }
}
