package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BattleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle s){
        super.onCreate(s);
        setContentView(R.layout.activity_battle);

        findViewById(R.id.btn_back_battle).setOnClickListener(v-> finish());

        TextView logView = findViewById(R.id.battleLog);
        if(Storage.getInstance().getAllLutemons().size()>=2){
            Lutemon x=Storage.getInstance().getAllLutemons().get(0);
            Lutemon y=Storage.getInstance().getAllLutemons().get(1);
            logView.setText(new Battle(x,y).start());
        } else {
            logView.setText("Need two Lutemons");
        }
    }
}
