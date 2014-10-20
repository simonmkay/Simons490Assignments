package com.wesleyreisz.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wesleyreisz.mymusic.model.Song;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Simon Kay on 10/18/2014.
 */
public class SongAdapter extends ArrayAdapter<Song> {
    private SimpleDateForm df = new SimpleDateFormat("MMM, d, yyyy (EEE)");
    private Context mContext;
    private List<Songs> mEntries;

    public SongAdapter(Context context, int textViewResourceId, java.util.List<Song> entries) {
        super(context, textViewResourceId, entries);
        mContext = context;
        mEntries = (List<Songs>) entries;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_for_each_song, parent, false);

        }

        final Song song = mEntries.get(position);

        TextView textViewTitle = (TextView)view.findViewById((R.id.textViewSongTitle));
        textViewTitle.setText(song.getName());

        TextView textViewAlbum = (TextView)view.findViewById((R.id.textViewSongArtist));
        textViewAlbum.setText(song.getAlbum());

        TextView textViewPublishDate = (TextView)view.findViewById(R.id.textViewSongDate);
        textViewPublishDate.setText(df.format(song.getSongPublishedDate()));

        return view;
    }
}
