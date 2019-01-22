package com.example.kelyandhedin.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);
    }

    public void start(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
