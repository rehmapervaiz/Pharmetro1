package com.example.pharmetroclient;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.pharmetroclient.DBqueries.categoryModelList;
import static com.example.pharmetroclient.DBqueries.lists;
import static com.example.pharmetroclient.DBqueries.loadCatagories;
import static com.example.pharmetroclient.DBqueries.loadFragmentData;
import static com.example.pharmetroclient.DBqueries.loadedCategoriesNames;


import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;
    private HomePageAdapter adapter;
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



        //Strip Part

        //Strip Part



        //Horizontal Layout


        List<HorizontalProductScrollModel> horizontalProductScrollModelList=new ArrayList<>();
    /*    horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg Film-Coated Tablets" ,"Rs. 120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.banner,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.ic_home_blue_24dp,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.120"));
*/

        //Horizontal Layout


        /////////////Grid View

        /////////////Grid View


        ////////////Testing


        LinearLayoutManager testingLayoutManager= new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);



        int listPosition = 0;

       for(int x=0 ; x < loadedCategoriesNames.size() ; x++ )
       {
           if(loadedCategoriesNames.get(x).equals(title.toUpperCase())){
               listPosition = x;

           }
       }
       if(listPosition == 0){
           loadedCategoriesNames.add(title.toUpperCase());
           lists.add(new ArrayList<HomePageModel>());
           adapter = new HomePageAdapter(lists.get(loadedCategoriesNames.size() - 1));
           loadFragmentData(adapter, this, loadedCategoriesNames.size() - 1,title);
       }
       else{
           adapter = new HomePageAdapter(lists.get(listPosition));
       }

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
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        else if (id == R.id.main_search_icon) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
