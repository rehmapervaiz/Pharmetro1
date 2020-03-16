package com.example.pharmetroclient;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment1 extends Fragment {


    public HomeFragment1() {
        // Required empty public constructor
    }

    private RecyclerView testing;
    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_fragment1, container, false);

        categoryRecyclerView=view.findViewById(R.id.category_recyclerview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);


        final List<CategoryModel>categoryModelList=new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Painkiller"));
        categoryModelList.add(new CategoryModel("link","Vitamins"));
        categoryModelList.add(new CategoryModel("link","Drugs"));
        categoryModelList.add(new CategoryModel("link","Boosters"));
        categoryModelList.add(new CategoryModel("link","Baby care"));
        categoryModelList.add(new CategoryModel("link","First Aid"));
        categoryModelList.add(new CategoryModel("link","Supplements"));

        categoryAdapter= new CategoryAdapter(categoryModelList,getContext());
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();


////////////////////banner slider
         List<SliderModel>sliderModelList=new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.banner2,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.banner6,"#077EA4"));

        sliderModelList.add(new SliderModel(R.drawable.banner,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.banner2,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.banner3jpg,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.banner5,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.banner4jpg,"#077EA4"));

        sliderModelList.add(new SliderModel(R.drawable.banner5,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.banner2,"#077EA4"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#077EA4"));



///////////////////Banner Slider


        //Strip Part

        //Strip Part



        //Horizontal Layout


        List<HorizontalProductScrollModel> horizontalProductScrollModelList=new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med1,"Orthix ","500mg Film-Coated Tablets" ,"Rs. 320"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med2,"Ibuprofen ","200mg" ,"Rs.420"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.700"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med3,"Advil ","200mg" ,"Rs.1120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med4,"VoltrenT ","25mg" ,"Rs.70"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med5,"BioLine ","500mg" ,"Rs.120"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med6,"Omega 3 ","500mg" ,"Rs.700"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med7,"New Chapter ","25mg" ,"Rs.70"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med8,"Collagen ","500mg" ,"Rs.620"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.700"));

        //Horizontal Layout


        /////////////Grid View

        /////////////Grid View


        ////////////Testing

         testing =view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager= new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel>homePageModelList=new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Products that you are looking for!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Hurry Up!",horizontalProductScrollModelList));

        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Products that you are looking for!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Hurry Up!",horizontalProductScrollModelList));

        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Products that you are looking for!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Hurry Up!",horizontalProductScrollModelList));

      //  homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ff0000"));

        //homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000ff0"));

        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ////////////Testing
        return view;
    }


}
