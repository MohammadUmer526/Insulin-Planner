package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        CardView user_Info = findViewById(R.id.usr_Info);
        CardView diet_Chart = findViewById(R.id.diet_Chart);
        CardView e_Book = findViewById(R.id.e_Book);
        CardView previous_Report = findViewById(R.id.prv_Rprt);
        CardView check_Cal = findViewById(R.id.chk_Cal);
    }
}
