package com.example.pharmetroclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridView gridView;


   // just trying to commit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deals of the day");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view);
        gridView = findViewById(R.id.grid_view);

        int layout_code = getIntent().getIntExtra("layout_code",-1);

        if(layout_code==0) {
            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);


            List<WishListModel> wishListModelList = new ArrayList<>();
            wishListModelList.add(new WishListModel(R.drawable.panadol, "panaadol", 1, "3", 145, "Rs. 234/-", "Rs. 654/-", "cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.panadol, "panaadol", 0, "3", 145, "Rs. 234/-", "Rs. 654/-", "cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.panadol, "panaadol", 2, "3", 145, "Rs. 234/-", "Rs. 654/-", "cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.panadol, "panaadol", 4, "3", 145, "Rs. 234/-", "Rs. 654/-", "cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.panadol, "panaadol", 1, "3", 145, "Rs. 234/-", "Rs. 654/-", "cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.panadol, "panaadol", 1, "3", 145, "Rs. 234/-", "Rs. 654/-", "cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.panadol, "panaadol", 0, "3", 145, "Rs. 234/-", "Rs. 654/-", "cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.panadol, "panaadol", 2, "3", 145, "Rs. 234/-", "Rs. 654/-", "cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.panadol, "panaadol", 4, "3", 145, "Rs. 234/-", "Rs. 654/-", "cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.panadol, "panaadol", 1, "3", 145, "Rs. 234/-", "Rs. 654/-", "cash on delivery"));


            WishListAdapter adapter = new WishListAdapter(wishListModelList, false);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else if(layout_code==1) {

            gridView.setVisibility(View.VISIBLE);
            List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med1, "Orthix ", "500mg Film-Coated Tablets", "Rs. 320"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med2, "Ibuprofen ", "200mg", "Rs.420"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol, "Panadol ", "500mg", "Rs.700"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med3, "Advil ", "200mg", "Rs.1120"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med4, "VoltrenT ", "25mg", "Rs.70"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med5, "BioLine ", "500mg", "Rs.120"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med6, "Omega 3 ", "500mg", "Rs.700"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med7, "New Chapter ", "25mg", "Rs.70"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med8, "Collagen ", "500mg", "Rs.620"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol, "Panadol ", "500mg", "Rs.700"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med1, "Orthix ", "500mg Film-Coated Tablets", "Rs. 320"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med2, "Ibuprofen ", "200mg", "Rs.420"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol, "Panadol ", "500mg", "Rs.700"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med3, "Advil ", "200mg", "Rs.1120"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med4, "VoltrenT ", "25mg", "Rs.70"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med5, "BioLine ", "500mg", "Rs.120"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med6, "Omega 3 ", "500mg", "Rs.700"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med7, "New Chapter ", "25mg", "Rs.70"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med8, "Collagen ", "500mg", "Rs.620"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol, "Panadol ", "500mg", "Rs.700"));


            GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProductScrollModelList);
            gridView.setAdapter(gridProductLayoutAdapter);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
