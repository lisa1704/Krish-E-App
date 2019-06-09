package com.example.krishe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.krishe.ui.addnewproduct.AddNewProductFragment;

public class AddNewProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_product_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AddNewProductFragment.newInstance())
                    .commitNow();
        }
    }
}
