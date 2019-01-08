package com.example.kelyandhedin.myfirstapplication;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int distance = 0;
    private int distance_menace = -50;
    private String text_distance;
    private String text_ecart;
    private int fatigue = 0;
    private int soif = 0;
    private int eau = 100;
    private int ecart = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


 /*     Intent intent= new Intent(this,Main2Activity.class);
        startActivity(intent);

        Button button = (Button) view;
        button.setText("Ok !!!");


       if (view.getId() == R.id.button10){

       } permet de savoir quel bouton à été appuyer

       */

    public void Action(View view) {

        ProgressBar progressBarEcart = findViewById(R.id.progressBarEcart);

        Drawable progressDrawable = progressBarEcart.getProgressDrawable().mutate();

        int min_dist = 3;
        int max_dist = 8;

        int min_menace = 5;
        int max_menace = 8;

        Random r = new Random();
        int i1 = r.nextInt(max_dist - min_dist + 1) + min_dist;

        Random s = new Random();
        int i2 = s.nextInt(max_menace - min_menace + 1) + min_dist;


        if (view.getId() == R.id.bouton_marcher){

            distance += i1;
            fatigue += 10;
            soif += 10;
            distance_menace += i2;
            ecart= distance-distance_menace;

            ProgressBar progressBarDistance = findViewById(R.id.progressBarDistance);
            progressBarDistance.setProgress(distance);

            ProgressBar progressBarFatigue = findViewById(R.id.progressBarFatigue);
            progressBarFatigue.setProgress(fatigue);

            ProgressBar progressBarSoif = findViewById(R.id.progressBarSoif);
            progressBarSoif.setProgress(soif);


            progressBarEcart.setProgress(100-(2*ecart));

            if (ecart <= 15){

                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progressBarEcart.setProgressDrawable(progressDrawable);

            }else if (ecart <= 30 && ecart >= 16){

                progressDrawable.setColorFilter(Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
                progressBarEcart.setProgressDrawable(progressDrawable);

            }else if (ecart >= 31){

                progressDrawable.setColorFilter(Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
                progressBarEcart.setProgressDrawable(progressDrawable);

            }

            TextView textViewDistance = findViewById(R.id.TextDistance);
            text_distance = distance+"/120 km";
            textViewDistance.setText(text_distance);

            TextView textView2 = findViewById(R.id.ecart_menace);
            text_ecart = (distance-distance_menace)+"km";
            textView2.setText(text_ecart);

        }

        if (view.getId() == R.id.bouton_repos){

            distance_menace += 8;
            fatigue += (-10);
            soif += 20;
            ecart= distance-distance_menace;

            ProgressBar progressBarFatigue = findViewById(R.id.progressBarFatigue);
            progressBarFatigue.setProgress(fatigue);

            ProgressBar progressBarSoif = findViewById(R.id.progressBarSoif);
            progressBarSoif.setProgress(soif);

            progressBarEcart.setProgress(100-(2*ecart));

            if (ecart <= 15){

                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progressBarEcart.setProgressDrawable(progressDrawable);

            }else if (ecart <= 30 && ecart >= 16){

                progressDrawable.setColorFilter(Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
                progressBarEcart.setProgressDrawable(progressDrawable);

            }else if (ecart >= 31){

                progressDrawable.setColorFilter(Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
                progressBarEcart.setProgressDrawable(progressDrawable);

            }

            TextView textView = findViewById(R.id.ecart_menace);
            text_ecart = (distance-distance_menace)+"km";
            textView.setText(text_ecart);

        }

        if (view.getId() == R.id.bouton_boire){

            distance_menace += 3;
            eau += (-15);
            soif += (-10);
            ecart= distance-distance_menace;

            ProgressBar progessBarEau = findViewById(R.id.progressBarEau);
            progessBarEau.setProgress(eau);

            ProgressBar progressBarSoif = findViewById(R.id.progressBarSoif);
            progressBarSoif.setProgress(soif);

            progressBarEcart.setProgress(100-(2*ecart));

            if (ecart <= 15){

                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progressBarEcart.setProgressDrawable(progressDrawable);

            }else if (ecart <= 30 && ecart >= 16){

            progressDrawable.setColorFilter(Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
            progressBarEcart.setProgressDrawable(progressDrawable);

            }else if (ecart >= 31){

                progressDrawable.setColorFilter(Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
                progressBarEcart.setProgressDrawable(progressDrawable);

            }

            TextView textView = findViewById(R.id.ecart_menace);
            text_ecart = (distance-distance_menace)+"km";
            textView.setText(text_ecart);

        }


    }



}
