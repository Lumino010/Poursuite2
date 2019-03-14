package com.example.kelyandhedin.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    //String strName= getIntent().getExtras().getString("END");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String newString= " ";
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
            } else {
                newString = extras.getString("END","you loose");
            }
        }



        TextView textViewEND = findViewById(R.id.textViewEND);   //affichage de l''écart
        String text_fin = newString ;
        textViewEND.setText(text_fin);
    }


    public void RetourMenu(View view) {
        Intent intent = new Intent(this,StartActivity.class);
        startActivity(intent);

    }
}
