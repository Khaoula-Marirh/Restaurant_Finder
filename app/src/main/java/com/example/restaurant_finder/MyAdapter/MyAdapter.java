package com.example.restaurant_finder.MyAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_finder.R;
import com.example.restaurant_finder.model.Magasin;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RestaurantViewHolder>{
    private List<Magasin> magasins;
    public MyAdapter(List<Magasin> magasins){
        this.magasins=magasins;
    }
    @NonNull
    @Override
    public MyAdapter.RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_magasin_item,parent,false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.RestaurantViewHolder holder, int position) {
        Magasin magasin = magasins.get(position);
        holder.nomTextView.setText(magasin.getRestaurants());
        holder.adresseTextView.setText(magasin.getAdress());
        holder.telephoneTextView.setText(magasin.getPhone());
    }

    @Override
    public int getItemCount() {
        return magasins.size();
    }

    // Add this method to update the data in the adapter
    public void setMagasins(List<Magasin> magasins) {
        this.magasins = magasins;
        notifyDataSetChanged();
    }




    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        TextView nomTextView,adresseTextView,telephoneTextView;
        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            nomTextView = itemView.findViewById(R.id.nomTextView);
            adresseTextView = itemView.findViewById(R.id.adresseTextView);
            telephoneTextView = itemView.findViewById(R.id.telephoneTextView);
        }
    }
}