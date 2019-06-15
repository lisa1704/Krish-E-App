package com.example.hellofarmer;


import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Product> MainImageUploadInfoList;

    public RecyclerViewAdapter(Context context, List<Product> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Product proddeal = MainImageUploadInfoList.get(position);

        holder.ProductName.setText(proddeal.getPname());

        holder.ProductPrice.setText(proddeal.getPrice());



        //Loading image from Glide library.
        Picasso.get().load(proddeal.getImage()).into(holder.productImage);

    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView ProductName;
        public TextView ProductPrice;
        public ImageView productImage;
String photoURLL;
        public ViewHolder(View itemView) {

            super(itemView);

            ProductName = (TextView) itemView.findViewById(R.id.ShowStudentNameTextView);

            ProductPrice = (TextView) itemView.findViewById(R.id.ShowStudentNumberTextView);
            productImage=(ImageView)itemView.findViewById(R.id.MImg);
        }
    }
}