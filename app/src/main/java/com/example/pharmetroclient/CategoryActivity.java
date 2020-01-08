package com.example.pharmetroclient;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView=findViewById(R.id.category_recyclerview);

    ////////////////////banner slider
        List<SliderModel>sliderModelList=new ArrayList<>();

        sliderModelList.add(new SliderModel(R.drawable.ic_menu_gallery,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_send,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#077EA4"));

        sliderModelList.add(new SliderModel(R.drawable.ic_add_circle_outline_blue_24dp,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_camera,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.logo,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_gallery,"#077EA4"));

        sliderModelList.add(new SliderModel(R.drawable.ic_menu_send,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.ic_add_circle_outline_blue_24dp,"#077EA4"));



//Banner Slider


        //Strip Part

        //Strip Part



        //Horizontal Layout


        List<HorizontalProductScrollModel> horizontalProductScrollModelList=new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg Film-Coated Tablets" ,"Rs. 120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.banner,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_home_blue_24dp,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.120"));


        //Horizontal Layout


        /////////////Grid View

        /////////////Grid View


        ////////////Testing


        LinearLayoutManager testingLayoutManager= new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomePageModel>homePageModelList=new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ff0000"));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000ff0"));





        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        ////////////Testing


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar items here those are search icon, cart icon, notification icon
        int id = item.getItemId();

        if (id == R.id.main_search_icon) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
