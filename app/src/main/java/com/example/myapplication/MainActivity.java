package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_UsrLgn, btn_DctLgn, btn_UsrSgn, btn_DctSgn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_UsrLgn = (Button) findViewById(R.id.btn_usrLogin);
        btn_DctLgn = (Button) findViewById(R.id.btn_dctLogin);
        btn_DctSgn = (Button) findViewById(R.id.btn_dctSgnUp);
        btn_UsrSgn = (Button) findViewById(R.id.btn_usrSgnUp);

        btn_UsrLgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usr_Lgn = new Intent(MainActivity.this, UserLogIn.class);
                startActivity(usr_Lgn);
            }
        });

    }
}
