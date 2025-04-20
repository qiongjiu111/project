package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final Storage storage = Storage.getInstance();
    private LutemonAdapter adapter;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);

        adapter = new LutemonAdapter(new ArrayList<>(storage.getAllLutemons()));
        RecyclerView rv = findViewById(R.id.rvLutemons);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        findViewById(R.id.btn_create).setOnClickListener(v -> {
            EditText input = new EditText(this);
            input.setHint("Enter name");
            new AlertDialog.Builder(this)
                    .setTitle("Lutemon Name")
                    .setView(input)
                    .setPositiveButton("Next", (d, w) -> {
                        String name = input.getText().toString().trim();
                        String[] colors = {"White","Green","Pink","Orange","Black"};
                        new AlertDialog.Builder(this)
                                .setTitle("Choose Color")
                                .setItems(colors, (di, wi) -> {
                                    Lutemon l;
                                    switch(colors[wi]) {
                                        case "Green":  l = new GreenLutemon(name);  break;
                                        case "Pink":   l = new PinkLutemon(name);   break;
                                        case "Orange": l = new OrangeLutemon(name); break;
                                        case "Black":  l = new BlackLutemon(name);  break;
                                        default:       l = new WhiteLutemon(name);  break;
                                    }
                                    storage.addLutemon(l);
                                    refreshList();
                                }).show();
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });

        findViewById(R.id.btn_train).setOnClickListener(v ->
                startActivity(new Intent(this, TrainingActivity.class))
        );
        findViewById(R.id.btn_battle).setOnClickListener(v ->
                startActivity(new Intent(this, BattleActivity.class))
        );
        findViewById(R.id.btn_heal_all).setOnClickListener(v -> {
            for (Lutemon l : storage.getAllLutemons()) l.heal();
            refreshList();
        });
        findViewById(R.id.btn_refresh).setOnClickListener(v -> refreshList());
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshList();
    }

    private void refreshList() {
        adapter.updateData(new ArrayList<>(storage.getAllLutemons()));
    }
}
