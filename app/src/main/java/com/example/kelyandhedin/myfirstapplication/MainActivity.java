package com.example.kelyandhedin.myfirstapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int distance = 0; //distance parcouru par le joueur
    private int distance_menace = -50;  //distance parcouru par la menace
    public static final int MIN_DIST = 3;
    public static final int MAX_DIST = 8;

    private int distance = 0;
    private int distance_menace = -50;
    private String text_distance;
    private String text_ecart;
    private int etat_fatigue = 0;   //fatigue du joueur
    private int fatigue = 10;       //de combien augmente la fatigue
    private int etat_soif = 0;      //soif du joueur
    private int soif = 7;           //de combien augmente la soif
    private int etat_eau = 100;     //quantité d'eau du joueur
    private int pillule = 3;        // nombre de pillule du joueur
    private int pillule_effet = 0;  //numéro de l'effet de la pillule
    private int ecart = 50;         // écart entre la menace et le
    private Random r = new Random();

    private ProgressBar progressBarEcart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarEcart = findViewById(R.id.progressBarEcart);
    }


 /*     Intent intent= new Intent(this,Main2Activity.class);
        startActivity(intent);

        Button button = (Button) view;
        button.setText("Ok !!!");


       if (view.getId() == R.id.button10){

       } permet de savoir quel bouton à été appuyer

       */

    public void DangerColor(View view , int ecart) { //fonction qui color la barre en fonction de l'écart entre le joueur et la menace

        ProgressBar progressBarEcart = findViewById(R.id.progressBarEcart);

        Drawable progressDrawable = progressBarEcart.getProgressDrawable().mutate();

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

    }

    public void Action(View view) { //fonction d'action pour marcher,boire,se reposer ou prendre une pillule

        ProgressBar progressBarEcart = findViewById(R.id.progressBarEcart);

        Drawable progressDrawable = progressBarEcart.getProgressDrawable().mutate();

        int min_dist = 3;   //un peu de hasard quand la personne marche
        int max_dist = 8;

        int min_menace = 5;
        int max_menace = 8;

        int i1 = getRandomIntBetwween(MIN_DIST, MAX_DIST);
        int i2 = getRandomIntBetwween(min_menace, max_menace);//r.nextInt(max_menace - min_menace + 1) + min_dist;

        if (view.getId() == R.id.bouton_marcher){   //si bouton appué est le bouton marcher

            if (etat_fatigue <= 100) {

                distance += i1;
                etat_fatigue += fatigue;
                etat_soif += soif;
                distance_menace += i2;
                ecart = distance - distance_menace;

                ProgressBar progressBarDistance = findViewById(R.id.progressBarDistance);
                progressBarDistance.setProgress(distance);

                ProgressBar progressBarFatigue = findViewById(R.id.progressBarFatigue);
                progressBarFatigue.setProgress(etat_fatigue);

                ProgressBar progressBarSoif = findViewById(R.id.progressBarSoif);
                progressBarSoif.setProgress(etat_soif);


                progressBarEcart.setProgress(100 - (2 * ecart));

                DangerColor(view, ecart);

                TextView textViewDistance = findViewById(R.id.TextDistance);    //affichage distance
                text_distance = distance + "/120 km";
                textViewDistance.setText(text_distance);

                TextView textView2 = findViewById(R.id.ecart_menace);   //affichage de l''écart
                text_ecart = (distance - distance_menace) + "km";
                textView2.setText(text_ecart);
            }else{
                //bruit, animation ou message
            }

        }

        if (view.getId() == R.id.bouton_repos){ //si bouton appué est le bouton se reposer

            distance_menace += 8;
            etat_fatigue += (-12);
            ecart= distance-distance_menace;

            ProgressBar progressBarFatigue = findViewById(R.id.progressBarFatigue);
            progressBarFatigue.setProgress(etat_fatigue);

            ProgressBar progressBarSoif = findViewById(R.id.progressBarSoif);
            progressBarSoif.setProgress(etat_soif);

            progressBarEcart.setProgress(100-(2*ecart));

            DangerColor(view,ecart);

            TextView textView = findViewById(R.id.ecart_menace);    //affichage de l''écart
            text_ecart = (distance-distance_menace)+"km";
            textView.setText(text_ecart);

        }

        if (view.getId() == R.id.bouton_boire){ //si bouton appué est le bouton boire

            if (etat_eau > 0) {

                distance_menace += 3;
                etat_eau += (-15);
                etat_soif += (-10);
                ecart = distance - distance_menace;

                ProgressBar progessBarEau = findViewById(R.id.progressBarEau);
                progessBarEau.setProgress(etat_eau);

                ProgressBar progressBarSoif = findViewById(R.id.progressBarSoif);
                progressBarSoif.setProgress(etat_soif);

                progressBarEcart.setProgress(100 - (2 * ecart));

                DangerColor(view, ecart);

                TextView textView = findViewById(R.id.ecart_menace);    //affichage de l''écart
                text_ecart = (distance - distance_menace) + "km";
                textView.setText(text_ecart);
            }else{
                //bruit, animation ou message
            }

        }

        if (view.getId() == R.id.bouton_drogue){    //si bouton appué est le bouton pillule

            if (pillule > 0) {

                pillule_effet +=1;
                distance_menace += 3;
                ecart = distance - distance_menace;

                ProgressBar progressBarPillule = findViewById(R.id.progressBarPillule);
                progressBarPillule.setProgress(pillule);

                progressBarEcart.setProgress(100 - (2 * ecart));

                DangerColor(view, ecart);

                TextView textView = findViewById(R.id.ecart_menace);    //affichage de l''écart
                text_ecart = (distance - distance_menace) + "km";
                textView.setText(text_ecart);

            }else{
                //bruit, animation ou message
            }

        }

        if(ecart <= 0 || etat_soif >= 100){     //savoir si la menace à rattraper le joueur ou si il est mort de soif
            Intent intent= new Intent(this,Main2Activity.class);
            startActivity(intent);
            //GAME OVER
        }


    }

    private int getRandomIntBetwween(int min_dist, int max_dist) {

        return r.nextInt(max_dist - min_dist + 1) + min_dist;
    }


}
