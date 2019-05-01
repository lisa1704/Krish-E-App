package com.example.hellofarmer;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.support.annotation.NonNull;

import android.support.v4.view.GravityCompat;



import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

private ImageButton searchbtn ,addBtn;
    private DrawerLayout drawer;
    NavigationView navigationView;
    private FirebaseAuth firebaseAuth;
    private Spinner spinCategory,spinprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        firebaseAuth = FirebaseAuth.getInstance();

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        searchbtn=(ImageButton)findViewById(R.id.search);
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openToDoactivity();
            }
        });
        addBtn=(ImageButton)findViewById(R.id.AddBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openaddBtnActivity();
            }
        });

        spinCategory = findViewById(R.id.cSpin);

        List<String> categories = new ArrayList<>();
        categories.add(0, "Choose Category");
        categories.add("Crops");
        categories.add("Oil");
        categories.add("Seed");
        categories.add("fertilizer");
        categories.add("fruit");
        categories.add("Vegetable");
        categories.add("Spice");


        //Style and populate the spinner
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, categories);

        //Dropdown layout style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        spinCategory.setAdapter(dataAdapter);

        spinCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Choose Category"))
                {
                    //do nothing
                }
                else
                {
                    //on selecting a spinner item
                    String item = parent.getItemAtPosition(position).toString();

                    //show selected spinner item
                    Toast.makeText(parent.getContext(), "Selected: " +item, Toast.LENGTH_SHORT).show();


                    //anything else you want to do on item selection do here
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // TODO Auto-generated method stub
            }
        });

        spinprice = findViewById(R.id.Pspin);

        List<String> price = new ArrayList<>();
        price.add(0, "Choose Price_range");
        price.add("100");
        price.add("200");
        price.add("300");
        price.add("400");
        price.add("500");
        price.add("600");
        price.add("1000");


        //Style and populate the spinner
        ArrayAdapter<String> dataAdapter2;
        dataAdapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, price);

        //Dropdown layout style
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        spinprice.setAdapter(dataAdapter2);

        spinprice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Choose Price_ramge"))
                {
                    //do nothing
                }
                else
                {
                    //on selecting a spinner item
                    String item = parent.getItemAtPosition(position).toString();

                    //show selected spinner item
                    Toast.makeText(parent.getContext(), "Selected: " +item, Toast.LENGTH_SHORT).show();

                    //anything else you want to do on item selection do here
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // TODO Auto-generated method stub
            }
        });
    };

   public void openToDoactivity()
   {
       Intent intent=new Intent(this,ToDoActivity.class);
       startActivity(intent);

   }
   public void openaddBtnActivity()
   {
       Intent intent=new Intent(this,AddBtnActivity.class);
       startActivity(intent);
   }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.myprofile:
                startActivity(new Intent(this, HomeActivity.class));
                break;
            case R.id.granery:
                startActivity(new Intent(this, MyGranaryActivity.class));
                break;
            case R.id.garage:
                startActivity(new Intent(this, MyGranaryActivity.class));
                break;
            case R.id.Shoppingcart:
                startActivity(new Intent(this, HomeActivity.class));
                break;
            case R.id.RentedMachinery:
                startActivity(new Intent(this, HomeActivity.class));
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
    }


