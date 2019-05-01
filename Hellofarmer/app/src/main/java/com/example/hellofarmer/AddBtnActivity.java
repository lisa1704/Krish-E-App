package com.example.hellofarmer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AddBtnActivity extends AppCompatActivity {

    private Button addPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_btn);
        addPro=(Button)findViewById(R.id.product);
        addPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openprodactivity();
            }
        });

    };
    public void openprodactivity()
    {
        Intent intent=new Intent(this,addNewProductActivity.class);
        startActivity(intent);

    }


}

