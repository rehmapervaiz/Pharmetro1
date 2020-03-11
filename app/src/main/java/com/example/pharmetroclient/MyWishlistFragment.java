package com.example.pharmetroclient;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyWishlistFragment extends Fragment {


    public MyWishlistFragment() {
        // Required empty public constructor
    }


    private RecyclerView wishlistRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_wishlist, container, false);

        wishlistRecyclerView = view.findViewById(R.id.my_wishlist_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecyclerView.setLayoutManager(linearLayoutManager);

        List<WishListModel> wishListModelList = new ArrayList<>();
        wishListModelList.add(new WishListModel(R.drawable.panadol,"panaadol",1,"3",145,"Rs. 234/-","Rs. 654/-","cash on delivery"));
        wishListModelList.add(new WishListModel(R.drawable.panadol,"panaadol",0,"3",145,"Rs. 234/-","Rs. 654/-","cash on delivery"));
        wishListModelList.add(new WishListModel(R.drawable.panadol,"panaadol",2,"3",145,"Rs. 234/-","Rs. 654/-","cash on delivery"));
        wishListModelList.add(new WishListModel(R.drawable.panadol,"panaadol",4,"3",145,"Rs. 234/-","Rs. 654/-","cash on delivery"));
        wishListModelList.add(new WishListModel(R.drawable.panadol,"panaadol",1,"3",145,"Rs. 234/-","Rs. 654/-","cash on delivery"));

        WishListAdapter wishListAdapter = new WishListAdapter(wishListModelList);
        wishlistRecyclerView.setAdapter(wishListAdapter);
        wishListAdapter.notifyDataSetChanged();

        return view;
    }

}
