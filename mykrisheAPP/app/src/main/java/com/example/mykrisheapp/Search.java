package com.example.mykrisheapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Search extends AppCompatActivity {
    private Button SearchBtn;
    private EditText inputText;
    private RecyclerView searchList;
private  String SearchInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        inputText =findViewById(R.id.search_product);
        SearchBtn=findViewById(R.id.search_button);
        searchList =findViewById(R.id.search_list);
        searchList.setLayoutManager(new LinearLayoutManager(Search.this));
SearchBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        SearchInput=inputText.getText().toString();
        onStart();

    }
});
    }

    @Override
    protected void onStart() {
        super.onStart();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Products");
        //FirebaseRecyclerOptions<GenericProductModel> options= new FirebaseRecyclerOptions.Builder<Products>().setQuery().
    }
}
