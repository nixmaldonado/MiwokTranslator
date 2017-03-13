package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter {

    private int backgroundColor;

    public WordAdapter(Context c, ArrayList<Word> words, int color){
        super(c, 0, words);
        backgroundColor = color;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View contentView = convertView;
        if (contentView == null){
            contentView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        Word currentWord = (Word) getItem(position);

        LinearLayout itemWordHolder = (LinearLayout) contentView.findViewById(R.id.item_word_holder);
        int color = ContextCompat.getColor(getContext(), backgroundColor);
        itemWordHolder.setBackgroundColor(color);

        TextView miwokWordTextView = (TextView) contentView.findViewById(R.id.miwok_text);
        miwokWordTextView.setText(currentWord.getMiwokWord());

        TextView defaultWordTextView = (TextView) contentView.findViewById(R.id.default_text);
        defaultWordTextView.setText(currentWord.getDefaultWord());

        ImageView imageView = (ImageView) contentView.findViewById(R.id.image);
        if (currentWord.hasImage()){
            imageView.setImageResource(currentWord.getResourceId());
            imageView.setVisibility(View.VISIBLE);
        }else{
            imageView.setVisibility(View.GONE);
        }

        return contentView;
    }
}
