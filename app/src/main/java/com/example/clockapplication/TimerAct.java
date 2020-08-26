package com.example.clockapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TimerAct extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button btnBack;

    public void select(View view) {
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        //implementing try and catch exception.
        try {
            int time = Integer.parseInt(editText.getText().toString());
            editText.setText("");

            closeKeyboard();    //calling closeKeyboard function.

            final int milliSecond = time * 1000;
            //value is required in millisecond. First lets convert value/time to millisecond.
            new CountDownTimer(milliSecond, 100){  //since 1sec = 1000 millisecond.

                @Override
                public void onTick(long millisUntilFinished) {
                    textView.setText(millisUntilFinished / 1000 +" second_to_go");
                }

                @Override
                public void onFinish() {
                    textView.setText("Done!!");
                }
            }.start();
        }catch (NumberFormatException e){
            Toast.makeText(this, "Please!! Enter the valid input.",Toast.LENGTH_LONG).show();
            editText.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    private void closeKeyboard(){   //function for closing the virtual keyboard.
        View view = this.getCurrentFocus();
        if (view !=null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}