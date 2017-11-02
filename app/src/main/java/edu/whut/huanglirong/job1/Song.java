package edu.whut.huanglirong.job1;


/**
 * Created by Aloehuang on 2017/10/16.
 */

public class Song {
    private String song_name;
    private String singer_name;
    private int song_coverID;

    public Song(String song_name, String singer_name, int song_coverID){
        this.song_name = song_name;
        this.singer_name = singer_name;
        this.song_coverID = song_coverID;
    }

    public String getSong_name(){
        return song_name;
    }

    public String getSinger_name(){
        return singer_name;
    }

    public int getSong_coverID(){
        return song_coverID;
    }
}
