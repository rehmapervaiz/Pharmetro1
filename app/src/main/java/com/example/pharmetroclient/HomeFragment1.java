package com.example.pharmetroclient;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.example.pharmetroclient.DBqueries.categoryModelList;
import static com.example.pharmetroclient.DBqueries.homePageModelList;
import static com.example.pharmetroclient.DBqueries.loadCatagories;
import static com.example.pharmetroclient.DBqueries.loadFragmentData;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment1 extends Fragment {


    public HomeFragment1() {
        // Required empty public constructor
    }

    private RecyclerView homePageRecyclerView;
    private RecyclerView categoryRecyclerView;

    private CategoryAdapter categoryAdapter;

    private HomePageAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_fragment1, container, false);




        categoryRecyclerView=view.findViewById(R.id.category_recyclerview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(categoryModelList,this.getActivity());
        categoryRecyclerView.setAdapter(categoryAdapter);

        if(categoryModelList.size() == 0){
            loadCatagories(categoryAdapter,getContext());
        }else {
            categoryAdapter.notifyDataSetChanged();
        }

        homePageRecyclerView = view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerView.setLayoutManager(testingLayoutManager);
        adapter = new HomePageAdapter(homePageModelList);
        homePageRecyclerView.setAdapter(adapter);

        if(homePageModelList.size() == 0){
            loadFragmentData(adapter,getContext());
        }else {
            categoryAdapter.notifyDataSetChanged();
        }



        return view;
    }


}
