package com.example.quizy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<ModelClass> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(new ModelClass("1.Where was the electricity supply first introduced in India", "Mumbai","Dehradun","Darjeeling","Chennai","Darjeeling"));
        list.add(new ModelClass("2.Fire temple is the place of worship of which of the following religion?", "Taosim","Shintoism","Judaism","Zoroastranism","Zoroastranism"));
        list.add(new ModelClass("3.Film and TV institute of India is located at","Pune","Pimpri","Perambur","Rajkot","Pune"));
        list.add(new ModelClass("4.Epsom (England) is the place associated with","Shooting","Snooker","Horse racing","Polo","Horse racing"));
        list.add(new ModelClass("5.Which of the following musical instruments is played by Amjad Ali Khan?","Guitar","Veena","Tabla","Sarod","Sarod"));
        list.add(new ModelClass("6.Dr. V. Kurien is famous in the field of ","Atomic power","Dairy Development","Economic reforms","Poultry farms","Dairy Development"));
        list.add(new ModelClass("7.The ‘Lady with the Lamp’ was the name given to?","Vijayalakshmi Pandit","Queen Elizabeth"," Florence Nightingale","Princess Diana","Florence Nightingale"));
        list.add(new ModelClass("8.The biggest part of the brain is","Spinal Cord","Cerebellum","Cerebrum","Brain Stem","Cerebrum"));
        list.add(new ModelClass("9.At room temperature, which is the only metal that is in liquid form?","Iron","Aluminum","Mercury","Silver","Silver"));
        list.add(new ModelClass("10.India launched Chandrayan3 which landed safely on which part of moon","South","East","West","North","South"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,DashboardActivity.class);
                startActivity(intent);

            }
        },1500);
    }
}