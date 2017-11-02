package edu.whut.huanglirong.job1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Aloehuang on 2017/10/13.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("登录");

        final EditText edit_username = (EditText)findViewById(R.id.edit_username);
        final EditText edit_password = (EditText)findViewById(R.id.edit_password);
        Button quit = (Button)findViewById(R.id.btn_quit);
        Button login = (Button)findViewById(R.id.btn_login);
        quit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (edit_username.getText().toString()==null||edit_username.getText().toString().equals("")||!edit_password.getText().toString().equals("123456")){
                    Toast.makeText(LoginActivity.this, "用户名为空或密码错误", Toast.LENGTH_SHORT ).show();
                }
                else {

                    String username = edit_username.getText().toString();
                    Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                    intent.putExtra("uname", username);
                    startActivity(intent);
                }
            }
        });
    }
}
