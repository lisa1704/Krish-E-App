package com.example.mykrisheapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawer;
    private FirebaseAuth firebaseAuth;
    NavigationView navigationView;
    GridLayout mainGrid;
    com.airbnb.lottie.LottieAnimationView notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        notification=findViewById(R.id.notifintro);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        CardView selloerentcardview = (CardView) findViewById(R.id.SellorRent);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NotificationActivity.class);

                startActivity(intent);

            }
        });

        selloerentcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,SellOrRent.class);

                startActivity(intent);

            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
       // setToggleEvent(mainGrid);
    }




        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.myprofile:
                    startActivity(new Intent(this, Profile.class));
                    break;
                case R.id.granery:
                    startActivity(new Intent(this, MyShop.class));
                    break;
                case R.id.notify:
                    startActivity(new Intent(this, NotificationActivity.class));
                    break;
                case R.id.Shoppingcart:
                    startActivity(new Intent(this, Cart.class));
                    break;
                case R.id.Wishlist:
                    startActivity(new Intent(this, Wishlist.class));
                    break;
                case R.id.logout:
                    logout();

                    break;

            }

            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    private void logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(this, LoginActivity.class));
    }


        @Override
        public void onBackPressed() {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }



    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(MainActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(MainActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid

        //You can see , all child item is CardView , so we just cast object to CardView

        CardView rentcardView = (CardView) findViewById(R.id.RentSearch);
        CardView fruitcardView = (CardView) findViewById(R.id.fruitsearch);
        CardView spicecardView = (CardView) findViewById(R.id.spicesearch);
        CardView vegetablecardView = (CardView) findViewById(R.id.vegetablesearch);
        CardView fertilizerscardView = (CardView) findViewById(R.id.fertilizersearch);
        CardView cropcardView = (CardView) findViewById(R.id.cropsearch);
        CardView seedcardView = (CardView) findViewById(R.id.seedsearch);


        rentcardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,RentMachinery.class);

                startActivity(intent);

            }
        });
        cropcardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Crops.class);

                startActivity(intent);

            }
        });
        fruitcardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Fruits.class);

                startActivity(intent);
            }
        });
        spicecardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Spice.class);

                startActivity(intent);
            }
        });
        vegetablecardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Vegetables.class);

                startActivity(intent);
            }
        });
        fertilizerscardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Fertilizer.class);

                startActivity(intent);
            }
        });
        seedcardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Seeds.class);

                startActivity(intent);
            }
        });

    }



}

