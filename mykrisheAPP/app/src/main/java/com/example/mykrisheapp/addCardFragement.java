package com.example.mykrisheapp;

/**
 * Created by kshitij on 16/1/18.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jaredrummler.materialspinner.MaterialSpinner;


public class addCardFragement extends Fragment implements View.OnClickListener {

    private DatabaseReference mDatabaseReference;
    private TextInputEditText cardName;
    private TextInputEditText cardimage;
    private TextInputEditText carddesc;
    private TextInputEditText cardprice;
    private Button bSubmit;
    private TextInputEditText productid;
    private String category;
    private MaterialSpinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.card_fragment,container,false);

        cardName = v.findViewById(R.id.tiet_movie_name);
        cardimage = v.findViewById(R.id.tiet_movie_logo);
        cardprice = v.findViewById(R.id.price);
        carddesc = v.findViewById(R.id.description);
        productid = v.findViewById(R.id.productid);
        bSubmit = v.findViewById(R.id.b_submit);
        category = "Rice";
        spinner = v.findViewById(R.id.categoryspinner);
        spinner.setItems("Power tiller","Corn","Mango","Orange","Rice","Wheat","Chilli","Safron","Compost","Cowdung","Power Tiller","Tractor","Sprayer","Sesami","Sunflower","Lentil","Carrot","Cabbage","Tomato");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                category = item;
            }
        });

        //initializing database reference
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        bSubmit.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.b_submit:
                if(!isEmpty(productid) && !isEmpty(cardName) && !isEmpty(cardimage) && !isEmpty(cardprice) && !isEmpty(carddesc)){
                    myNewCard(Integer.parseInt(productid.getText().toString()), cardName.getText().toString().trim(),cardimage.getText().toString(),carddesc.getText().toString(), Float.parseFloat(cardprice.getText().toString()));
                }else{
                    if(isEmpty(cardName)){
                        Toast.makeText(getContext(), "Please enter a name!", Toast.LENGTH_SHORT).show();
                    }else if(isEmpty(productid)){
                        Toast.makeText(getContext(), "Please enter Location", Toast.LENGTH_SHORT).show();
                    }else if(isEmpty(cardimage)){
                        Toast.makeText(getContext(), "Please specify a url for the image", Toast.LENGTH_SHORT).show();
                    }else if(isEmpty(cardprice)){
                        Toast.makeText(getContext(), "Please enter a price !", Toast.LENGTH_SHORT).show();
                    }else if(isEmpty(carddesc)){
                        Toast.makeText(getContext(), "Please enter description", Toast.LENGTH_SHORT).show();
                    }
                }
                //to remove current fragment
                getActivity().onBackPressed();
                break;
        }
    }

    private void myNewCard(int pid, String name, String image, String desc, float price) {
        //Creating a movie object with user defined variables
        AddCardsModel movie = new AddCardsModel(pid,name,image,desc,price);
        //referring to movies node and setting the values from movie object to that machid
        mDatabaseReference.child("Products").child(category).push().setValue(movie);
    }

    //check if edittext is empty
    private boolean isEmpty(TextInputEditText textInputEditText) {
        if (textInputEditText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }
}