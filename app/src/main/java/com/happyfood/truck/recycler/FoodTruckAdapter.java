package com.happyfood.truck.recycler;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.happyfood.truck.R;
import com.happyfood.truck.utils.CircleGlide;

import java.util.List;

/**
 * Created by SergiSantana for www.happyfoodtrucks.com
 */

public class FoodTruckAdapter extends RecyclerView.Adapter<FoodTruckAdapter.MyViewHolder> {

    private List<ItemFoodTruck> items;
    private Context context;
    private boolean active;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView  namefood, info, instaweb, img, kindfood, event ;
        public RatingBar ratingBar;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);

            namefood = (TextView) view.findViewById(R.id.tv_recipe_name);
            info = (TextView) view.findViewById(R.id.tv_desc);
            instaweb = (TextView) view.findViewById(R.id.tv_author);
            kindfood = (TextView) view.findViewById(R.id.tv_pieces);
            event = (TextView) view.findViewById(R.id.tv_date);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            imageView = (ImageView) view.findViewById(R.id.iv_recipe);
        }


    }


    public FoodTruckAdapter(List<ItemFoodTruck> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemFoodTruck itemFoodTruck = items.get(position);
        holder.namefood.setText(itemFoodTruck.getNamefood());
        holder.info.setText(itemFoodTruck.getInfo());
        holder.instaweb.setText(itemFoodTruck.getInstaweb());
        holder.img.setText(itemFoodTruck.getImg());
        holder.kindfood.setText(itemFoodTruck.getKindfood());
        holder.event.setText(itemFoodTruck.getEvent());

        holder.ratingBar.setRating(itemFoodTruck.getRating());
        Glide.with(context)
                .load(Uri.parse(itemFoodTruck.getImg()))
                .transform(new CircleGlide(context))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}