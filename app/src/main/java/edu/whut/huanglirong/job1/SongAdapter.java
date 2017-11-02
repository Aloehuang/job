package edu.whut.huanglirong.job1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Aloehuang on 2017/10/17.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    private int song_coverID;

    public SongAdapter(Context context, int song_coverID, List<Song> objects){
        super(context,song_coverID,objects);
        this.song_coverID = song_coverID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Song song = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(song_coverID, parent, false);
        ImageView song_cover = (ImageView)view.findViewById(R.id.song_cover);
        TextView song_name = (TextView)view.findViewById(R.id.song_name);
        TextView singer_name = (TextView)view.findViewById(R.id.singer_name);
        song_cover.setImageResource(song.getSong_coverID());
        song_name.setText(song.getSong_name());
        singer_name.setText(song.getSinger_name());
        return view;
    }
}
