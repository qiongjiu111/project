package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TrainingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle s){
        super.onCreate(s);
        setContentView(R.layout.activity_train);

        LinearLayout layout = findViewById(R.id.layoutTrain);
        layout.removeAllViews();
        for(Lutemon l:Storage.getInstance().getAllLutemons()){
            Button btn = new Button(this);
            btn.setText("Train "+l.getName());
            btn.setOnClickListener(v-> {
                l.train();
                finish();
            });
            layout.addView(btn);

            TextView tv = new TextView(this);
            tv.setText(l.getStats());
            layout.addView(tv);
        }
    }
}
