package com.example.wubingzhang.week9.alarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wubingzhang.week9.R;

public class alarm extends AppCompatActivity {
    Button addAlarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        addAlarm = (Button)findViewById(R.id.addAlarm);
        addAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(alarm.this,chooseTime.class);
                startActivity(intent);
                alarm.this.finish();
            }
        });

    }
}
