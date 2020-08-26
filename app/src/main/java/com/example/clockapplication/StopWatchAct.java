package com.example.clockapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class StopWatchAct extends AppCompatActivity {

    //declaring all the required variables with their data types.
    private Chronometer timer;
    private long pauseOffset;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        timer = findViewById(R.id.chronometer);
        timer.setFormat("Time: %s");
        timer.setBase(SystemClock.elapsedRealtime());
    }

    //this method assists in execution of the chronometer.
    public void beginChronometer(View v){
        if(!running) {
            timer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            timer.start();
            running = true;
        }
    }

    //this method plays the role in making the chronometer pause.
    public void pauseChronometer(View v){
        if(running) {
            timer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - timer.getBase();
            running = false;
        }
    }

    //resetting the time is done by the execution of this method.
    public void resetChronometer(View v){
        timer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }

    //finally, this method returns back to the home screen.
    public void goBack(View v){
        System.exit(0);
    }
}