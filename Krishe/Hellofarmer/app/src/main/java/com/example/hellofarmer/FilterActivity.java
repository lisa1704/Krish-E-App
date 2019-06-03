package com.example.hellofarmer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FilterActivity extends AppCompatActivity {
    private Spinner cspinner,nspinner,pspinner,dspinner,lspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        cspinner = findViewById(R.id.CSpinner);

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
        ArrayAdapter<String> dataAdapter1;
        dataAdapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, categories);

        //Dropdown layout style
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        cspinner.setAdapter(dataAdapter1);

        cspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        nspinner = findViewById(R.id.NSpinner);

        List<String> Name = new ArrayList<>();
        Name.add(0, "Choose Name");
        Name.add("Rice");
        Name.add("Maze");
        Name.add(" ");



        //Style and populate the spinner
        ArrayAdapter<String> dataAdapter2;
        dataAdapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Name);

        //Dropdown layout style
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        nspinner.setAdapter(dataAdapter2);

        nspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Choose Name"))
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
        pspinner = findViewById(R.id.PSpinner);

        List<String> Budget = new ArrayList<>();
        Budget.add(0, "Choose Budget");
        Budget.add("0-50");
        Budget.add("51-100");
        Budget.add("100-200");
        Budget.add("201-300");
        Budget.add("301-400");
        Budget.add("401-500");
        Budget.add("501-600");


        //Style and populate the spinner
        ArrayAdapter<String> dataAdapter3;
        dataAdapter3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Budget);

        //Dropdown layout style
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        pspinner.setAdapter(dataAdapter3);

        pspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Choose Budget"))
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
        lspinner = findViewById(R.id.LSpinner);

        List<String> location = new ArrayList<>();
        location.add(0, "Choose location");
        location.add("Dhaka");
        location.add("Rajshahi");
        location.add("Chittagong");
        location.add("Sylhet");



        //Style and populate the spinner
        ArrayAdapter<String> dataAdapter4;
        dataAdapter4 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, location);

        //Dropdown layout style
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        lspinner.setAdapter(dataAdapter4);

        lspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Choose Location"))
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

    }
}
