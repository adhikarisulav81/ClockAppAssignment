package com.example.clockapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomeAct extends AppCompatActivity {

    Button btnstopWatch, btnTimer, btnAlarm, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnstopWatch = findViewById(R.id.btnstopWatch);
        btnTimer = findViewById(R.id.btnTimer);
        btnAlarm = findViewById(R.id.btnAlarm);
        btnExit = findViewById(R.id.btnExit);

        //executes if btnstopwatch is clicked
        btnstopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeAct.this, StopWatchAct.class);     //for stopwatch
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeAct.this, TimerAct.class);       //for countdown timer
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeAct.this, AlarmAct.class);       //for alarm
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                   //exit process
                System.exit(0);
            }
        });

        //setting current date and time
        TextView tvCurrentTime = findViewById(R.id.tvCurrentTime);

        Calendar calendar = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE , dd-MMM-yyyy , hh:mm:ss a");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        tvCurrentTime.setText(dateTime);
    }
}