package com.example.mykrisheapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RentMachinery extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_machinery);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public void addPower(View view) {
        startActivity(new Intent(RentMachinery.this,PowerTiller.class));
    }

    public void addtractor(View view) {
        startActivity(new Intent(RentMachinery.this,Tractor.class));
    }
    public void addsprayer(View view) {
        startActivity(new Intent(RentMachinery.this,Sprayer.class));
    }
}


