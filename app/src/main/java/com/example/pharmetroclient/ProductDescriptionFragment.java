package com.example.pharmetroclient;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;



/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDescriptionFragment extends Fragment {


    public ProductDescriptionFragment() {
        // Required empty public constructor
    }

    private TextView desciptionBody;
  //  public static String productDescription;

    public String body;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product_description, container, false);
        desciptionBody=view.findViewById ( R.id.tv_product_description );
     //   if(tabPosition==0){
       //     desciptionBody.setText ( productDescription );
       // }else{
        //    desciptionBody.setText ( productOtherDetails );
        //}

       // desciptionBody.setText ( productDescription );


        desciptionBody.setText ( body   );

        return view;
    }

}
