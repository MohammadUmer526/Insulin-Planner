package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_Lgn, btn_UsrSgn, btn_DctSgn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Lgn = (Button) findViewById(R.id.btn_Login);
        btn_DctSgn = (Button) findViewById(R.id.btn_dctSgnUp);
        btn_UsrSgn = (Button) findViewById(R.id.btn_usrSgnUp);

//        Intent to Log IN

        btn_Lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usr_Lgn = new Intent(MainActivity.this, UserLogIn.class);
                startActivity(usr_Lgn);
            }
        });

//        Intent to User Sign Up

        btn_UsrSgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usr_Sgn = new Intent(MainActivity.this, UserSignUp.class);
                startActivity(usr_Sgn);

            }
        });

        // Intent to Doctor Sign Up

        btn_DctSgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dct_Sgn = new Intent(MainActivity.this, DocSignUp.class);
                startActivity(dct_Sgn);


            }
        });

    }
}
