package com.example.pharmetroclient;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<CategoryModel>categoryModelList;
    private Context mContext;

    public CategoryAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }
    public CategoryAdapter(List<CategoryModel> categoryModelList,Context context) {
        this.categoryModelList = categoryModelList;
        this.mContext = context;
    }



    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view= LayoutInflater.from(mContext).inflate(R.layout.category_item,parent,false);

        return new ViewHolder(view);
      //   return null;
    }


    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        String icon=categoryModelList.get(position).getCategoryIconLink();
        String name=categoryModelList.get(position).getCategoryName();
        holder.setCategory(name);
        holder.setCategoryIcon(icon);
    }

    @Override
    public int getItemCount() {


        return categoryModelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        private ImageView categoryIcon;
        private TextView categoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryIcon=itemView.findViewById(R.id.category_icon);
            categoryName=itemView.findViewById(R.id.category_name);
        }
        private void setCategoryIcon(String iconUrl){
            if(!iconUrl.equals("null")) {
                Glide.with(itemView.getContext()).load(iconUrl).apply(new RequestOptions()).into(categoryIcon);
            }
        }
        private void setCategory(final String name){
            categoryName.setText(name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent categoryIntent=new Intent(itemView.getContext(),CategoryActivity.class);
                   categoryIntent.putExtra("CategoryName",name);
                   itemView.getContext().startActivity(categoryIntent);

                }
            } );



        }
    }
}
