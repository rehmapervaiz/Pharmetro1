package com.example.pharmetroclient;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
    private FirebaseFirestore firebaseFirestore;
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

        //////////////////////////////
        /*categoryModelList = new ArrayList<CategoryModel>();
        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);


        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("CATEGORIES").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                categoryModelList.add(new CategoryModel(documentSnapshot.get("icon").toString(),documentSnapshot.get("").toString()));
                            }
                            categoryAdapter.notifyDataSetChanged();

                        }else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
*/

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




        //Strip Part

        //Strip Part



        //Horizontal Layout


        //List<HorizontalProductScrollModel> horizontalProductScrollModelList=new ArrayList<>();
        //horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med1,"Orthix ","500mg Film-Coated Tablets" ,"Rs. 320"));
        //horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med2,"Ibuprofen ","200mg" ,"Rs.420"));
        //horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.700"));
        //horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med3,"Advil ","200mg" ,"Rs.1120"));
        //horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med4,"VoltrenT ","25mg" ,"Rs.70"));
        //horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med5,"BioLine ","500mg" ,"Rs.120"));
        //horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med6,"Omega 3 ","500mg" ,"Rs.700"));
        //horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med7,"New Chapter ","25mg" ,"Rs.70"));
        //horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.med8,"Collagen ","500mg" ,"Rs.620"));
        //horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.panadol,"Panadol ","500mg" ,"Rs.700"));

        //Horizontal Layout


        /////////////Grid View

        /////////////Grid View


        ////////////Testing

        homePageRecyclerView =view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager= new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerView.setLayoutManager(testingLayoutManager);
        final List<HomePageModel>homePageModelList=new ArrayList<>();
        adapter=new HomePageAdapter(homePageModelList);
        homePageRecyclerView.setAdapter(adapter);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("CATEGORIES").document("HOME").collection("TOP_DEALS").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                if((long)documentSnapshot.get("view_type")==0){
                                    List<SliderModel> sliderModelList = new ArrayList<>();
                                    long no_of_banners =(long) documentSnapshot.get("no_of_banners");
                                    for(long x = 1; x < no_of_banners + 1; x++){
                                        sliderModelList.add(new SliderModel(documentSnapshot.get("banner_"+x).toString(),documentSnapshot.get("banner_"+x+"_background").toString()));
                                    }
                                    homePageModelList.add(new HomePageModel(0,sliderModelList));

                                }else if((long)documentSnapshot.get("view_type")==1){
                                    homePageModelList.add(new HomePageModel(1,documentSnapshot.get("strip_ad_banner").toString(),documentSnapshot.get("background").toString()));

                                }else if((long)documentSnapshot.get("view_type")==2){

                                }else if((long)documentSnapshot.get("view_type")==3){

                                }
                            }
                            adapter.notifyDataSetChanged();

                        }else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(),"Firebase is not connected",Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        ////////////Testing
        return view;
    }


}
//blahhhhhh