package com.example.clockapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlarmAct extends AppCompatActivity {

    EditText hrEditText, minEditText;
    Button btnAlarmSet, btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        hrEditText = findViewById(R.id.hrEditText);
        minEditText = findViewById(R.id.minEditText);
        btnAlarmSet = findViewById(R.id.btnAlarmSet);
        btnGoBack =  findViewById(R.id.btnGoBack);

        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        btnAlarmSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hrEditText.getText().toString().isEmpty()) {
                    hrEditText.setError("Fill the TextView!!");
                }else if (minEditText.getText().toString().isEmpty()) {
                    minEditText.setError("Please! Fill Both the TextView.");
                }else {
                    int hour = Integer.parseInt(hrEditText.getText().toString());
                    int min = Integer.parseInt(minEditText.getText().toString());

                    closeKeyboard();

                    // implementing intent functionality
                    Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
                    intent.putExtra(AlarmClock.EXTRA_MINUTES, min);
                    if (hour <= 24 && min <= 60) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Please!! Enter the Valid Input.", Toast.LENGTH_SHORT).show();
                        hrEditText.setText("");
                        minEditText.setText("");
                    }
                }
            }
        });
    }

    private void closeKeyboard(){
        View view = this.getCurrentFocus();
        if (view !=null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}