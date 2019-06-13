package com.example.mykrisheapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Seeds extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeds);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public void addMango(View view) {
        startActivity(new Intent(Seeds.this,Sesami.class));
    }

    public void addApple(View view) {
        startActivity(new Intent(Seeds.this,Sunflower.class));
    }
    public void addOrange(View view) {
        startActivity(new Intent(Seeds.this,Lentil.class));;
    }

}


