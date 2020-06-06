package com.example.pharmetroclient;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.pharmetroclient.DBqueries.categoryModelList;
import static com.example.pharmetroclient.DBqueries.lists;
import static com.example.pharmetroclient.DBqueries.loadCatagories;
import static com.example.pharmetroclient.DBqueries.loadFragmentData;
import static com.example.pharmetroclient.DBqueries.loadedCategoriesNames;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment1 extends Fragment {


    public HomeFragment1() {
        // Required empty public constructor
    }

    public static SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView homePageRecyclerView;
    private List<HomePageModel> homePageModelFakeList = new ArrayList<>();

    private RecyclerView categoryRecyclerView;

    private List<CategoryModel> categoryModelFakeList = new ArrayList<>();
    private CategoryAdapter categoryAdapter;

    private HomePageAdapter adapter;

    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo;

    private ImageView noInternetConnection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_fragment1, container, false);
        swipeRefreshLayout = view.findViewById(R.id.refresh_layout);
        noInternetConnection = view.findViewById(R.id.no_internet_connection);

        homePageRecyclerView = view.findViewById(R.id.home_page_recyclerview);
        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerView.setLayoutManager(testingLayoutManager);



///Categories fake list
        categoryModelFakeList.add(new CategoryModel("null",""));
        categoryModelFakeList.add(new CategoryModel("",""));
        categoryModelFakeList.add(new CategoryModel("",""));
        categoryModelFakeList.add(new CategoryModel("",""));
        categoryModelFakeList.add(new CategoryModel("",""));
        categoryModelFakeList.add(new CategoryModel("",""));
        categoryModelFakeList.add(new CategoryModel("",""));
        categoryModelFakeList.add(new CategoryModel("",""));
        categoryModelFakeList.add(new CategoryModel("",""));
        categoryModelFakeList.add(new CategoryModel("",""));
///Categories fake list

///Home page fake list
        List<SliderModel> sliderModelFakeList = new ArrayList<>();
        sliderModelFakeList.add(new SliderModel("null","#dfdfdf"));
        sliderModelFakeList.add(new SliderModel("null","#dfdfdf"));
        sliderModelFakeList.add(new SliderModel("null","#dfdfdf"));
        sliderModelFakeList.add(new SliderModel("null","#dfdfdf"));
        sliderModelFakeList.add(new SliderModel("null","#dfdfdf"));


        List<HorizontalProductScrollModel> horizontalProductScrollModelFakeList=new ArrayList<>();
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("","","" ,"",""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("","","" ,"",""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("","","" ,"",""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("","","" ,"",""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("","","" ,"",""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("","","" ,"",""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("","","" ,"",""));


        homePageModelFakeList.add(new HomePageModel(0,sliderModelFakeList));
        homePageModelFakeList.add(new HomePageModel(1,"","#dfdfdf"));
        homePageModelFakeList.add(new HomePageModel(2,"","#dfdfdf",horizontalProductScrollModelFakeList,new ArrayList<WishListModel>()));
        homePageModelFakeList.add(new HomePageModel(3,"","#dfdfdf",horizontalProductScrollModelFakeList));


///Home page fake list


        categoryAdapter = new CategoryAdapter(categoryModelFakeList, this.getActivity());
        adapter = new HomePageAdapter(homePageModelFakeList);



        if (categoryModelList.size() == 0) {
            loadCatagories(categoryRecyclerView, getContext());
        } else {
            categoryAdapter = new CategoryAdapter(categoryModelList);
            categoryAdapter.notifyDataSetChanged();
        }
        categoryRecyclerView.setAdapter(categoryAdapter);



        if (lists.size() == 0) {
            loadedCategoriesNames.add("HOME");
            lists.add(new ArrayList<HomePageModel>());
            loadFragmentData(homePageRecyclerView, getContext(), 0,"Home");
        } else {
            adapter = new HomePageAdapter(lists.get(0));
            adapter.notifyDataSetChanged();
        }
        homePageRecyclerView.setAdapter(adapter);



        ///refresh layout

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);

                categoryModelList.clear();
                lists.clear();
                loadedCategoriesNames.clear();
                if(networkInfo != null && networkInfo.isConnected() == true){
                    noInternetConnection.setVisibility(View.GONE);
                    categoryAdapter = new CategoryAdapter(categoryModelFakeList);
                    adapter = new HomePageAdapter(homePageModelFakeList);
                    categoryRecyclerView.setAdapter(categoryAdapter);
                    homePageRecyclerView.setAdapter(adapter);
                    loadCatagories(categoryRecyclerView,getContext());

                    loadedCategoriesNames.add("HOME");
                    lists.add(new ArrayList<HomePageModel>());
                    loadFragmentData(homePageRecyclerView, getContext(), 0,"Home");


                }else {
                    Glide.with(getContext()).load(R.drawable.no_internet_connection).into(noInternetConnection);
                    noInternetConnection.setVisibility(View.VISIBLE);

                }
            }
        });
        ///refresh layout



        return view;
    }


}
