package com.example.mykrisheapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Fruits extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public void addMango(View view) {
        startActivity(new Intent(Fruits.this,Mango.class));
    }

    public void addApple(View view) {
        startActivity(new Intent(Fruits.this,Apple.class));
    }
    public void addOrange(View view) {
        startActivity(new Intent(Fruits.this,Orange.class));;
    }

}


