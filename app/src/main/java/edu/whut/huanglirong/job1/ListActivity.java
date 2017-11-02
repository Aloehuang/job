package edu.whut.huanglirong.job1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aloehuang on 2017/10/16.
 */

public class ListActivity extends AppCompatActivity{

    private List<Song> songList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
//        展示从登录界面传送过来的带下划线的用户名
        TextView txt_welcome = (TextView) findViewById(R.id.txt_welcome);
        SpannableString content = new SpannableString(this.getIntent().getStringExtra("uname"));
        content.setSpan(new UnderlineSpan(), 0, this.getIntent().getStringExtra("uname").length(), 0);
        txt_welcome.setText(content);
//        返回按钮的处理
        Button btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
//        ListView的处理
        initSongs();
        SongAdapter adapter =new SongAdapter(ListActivity.this, R.layout.song_item, songList);
        ListView listView = (ListView)findViewById(R.id.list_song);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = songList.get(position);
                Toast.makeText(ListActivity.this, song.getSong_name(), Toast.LENGTH_SHORT).show();
            }
        });
    }
//    歌曲列表初始化
    private void initSongs(){
        for(int i=0; i<2; i++) {
            Song cd = new Song("成都", "赵雷", R.drawable.cd);
            songList.add(cd);
            Song lla = new Song("莉莉安", "宋东野", R.drawable.lla);
            songList.add(lla);
            Song nsn = new Song("南山南", "马頔", R.drawable.nsn);
            songList.add(nsn);
            Song qmnlg = new Song("奇妙能力歌", "陈粒", R.drawable.qmnlg);
            songList.add(qmnlg);
        }
    }
}
