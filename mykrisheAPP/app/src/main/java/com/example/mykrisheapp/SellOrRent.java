package com.example.mykrisheapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SellOrRent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_or_rent);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public void addMachine(View view) {
        startActivity(new Intent(SellOrRent.this,MyShop.class));
    }

    public void addCard(View view) {
        startActivity(new Intent(SellOrRent.this,MyShop.class));
    }
}
