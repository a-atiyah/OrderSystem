package com.a.atiyah.ordersystem.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.a.atiyah.ordersystem.R;
import com.a.atiyah.ordersystem.room.model.Food;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{

    Context mContext;
    List<Food> mFoodList;

    public FoodAdapter(Context mContext, List<Food> mFoodList) {
        this.mContext = mContext;
        this.mFoodList = mFoodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = mFoodList.get(position);
        holder.tvTitle.setText(food.getTitle());
        holder.tvDescription.setText(food.getDescription());
        holder.tvPrice.setText(food.getPrise());
        String imgName = food.getImgName();
        holder.ivFood.setImageResource(mContext.getResources()
                .getIdentifier(imgName, "drawable", mContext.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }


    static class FoodViewHolder extends RecyclerView.ViewHolder{

        ImageView ivFood;
        TextView tvTitle, tvDescription, tvPrice;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFood = itemView.findViewById(R.id.iv_food);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_desc);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
