package com.example.mykrisheapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Vegetables extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public void addMango(View view) {
        startActivity(new Intent(Vegetables.this,Carrot.class));
    }

    public void addApple(View view) {
        startActivity(new Intent(Vegetables.this,Cabbage.class));
    }
    public void addOrange(View view) {
        startActivity(new Intent(Vegetables.this,Tomato.class));;
    }

}


