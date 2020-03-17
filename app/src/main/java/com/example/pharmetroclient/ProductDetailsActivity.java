package com.example.pharmetroclient;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.pharmetroclient.MainActivity.showCart;

public class ProductDetailsActivity extends AppCompatActivity {

    private ViewPager productImagesViewPager;
    private TabLayout viewpagerIndicator;
    private Button couponRedeemBtn;

    /////////////COUPON DIALOG////////////////////////////////

    public static TextView couponTitle;
    public static TextView couponBody;
    public static TextView couponExpiryDate;
    private static RecyclerView couponsRecyclerView;
    private static LinearLayout selectedCoupon;





    /////////////COUPON DIALOG////////////////////////////////

    private FloatingActionButton addToWishlisttBtn;
    private static boolean ALREADY_ADDED_TO_WISHLIST = false;
    private ViewPager productDetailsViewpager;
    private TabLayout productDetailsTablayout;

    /////////////////// Rating layout

    private  LinearLayout rateNowContainer;
    /////////////////// Rating layout
    private Button buyNowBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productImagesViewPager = findViewById(R.id.product_images_viewpager);
        viewpagerIndicator = findViewById(R.id.viewpager_indicator);
        addToWishlisttBtn = findViewById(R.id.add_to_wishlist_btn);
        productDetailsViewpager=findViewById(R.id.product_details_viewpager);
        productDetailsTablayout=findViewById(R.id.product_details_tablayout);
        buyNowBtn = findViewById(R.id.buy_now_btn);
        couponRedeemBtn=findViewById(R.id.coupon_redemption_btn);

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.panadol);
        productImages.add(R.drawable.logo);
        productImages.add(R.drawable.logo1);
        productImages.add(R.drawable.banner);
        productImages.add(R.drawable.panadol);

        ProductImagesAdapter productImagesAdapter = new ProductImagesAdapter(productImages);
        productImagesViewPager.setAdapter(productImagesAdapter);

        viewpagerIndicator.setupWithViewPager(productImagesViewPager, true);

        addToWishlisttBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ALREADY_ADDED_TO_WISHLIST) {
                    ALREADY_ADDED_TO_WISHLIST = false;
                    addToWishlisttBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                } else {
                    ALREADY_ADDED_TO_WISHLIST = true;
                    addToWishlisttBtn.setSupportImageTintList(getResources().getColorStateList(R.color.colorPrimary));
                }
            }
        });



        productDetailsViewpager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(),productDetailsTablayout.getTabCount()));
        productDetailsViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTablayout));
        productDetailsTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsViewpager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        /////////////////// Rating layout
        rateNowContainer=findViewById(R.id.rate_now_container);
        for(int x=0;x<rateNowContainer.getChildCount();x++){
            final int starPosition=x;
            rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     setRating(starPosition);
                }
            });
        }
        /////////////////// Rating layout

        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent = new Intent(ProductDetailsActivity.this,DeliveryActivity.class);
                startActivity(deliveryIntent);
            }
        });


        ///////////////////COUPON DIALOG////////////////////

        final Dialog checkCouponPriceDialog=new Dialog(ProductDetailsActivity.this);
        checkCouponPriceDialog.setContentView(R.layout.coupon_redeem_dialog);
        checkCouponPriceDialog.setCancelable(true);
        checkCouponPriceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);


        ImageView toggleRecyclerView=checkCouponPriceDialog.findViewById(R.id.toggle_recyclerview);
        couponsRecyclerView=checkCouponPriceDialog.findViewById(R.id.coupons_recyclerView);
        selectedCoupon=checkCouponPriceDialog.findViewById(R.id.selected_coupon);

        couponTitle=checkCouponPriceDialog.findViewById(R.id.coupen_title);
        couponBody=checkCouponPriceDialog.findViewById(R.id.coupen_body);
        couponExpiryDate=checkCouponPriceDialog.findViewById(R.id.coupen_validity);

        TextView originalPrice=checkCouponPriceDialog.findViewById(R.id.original_price);
        TextView discountedPrice=checkCouponPriceDialog.findViewById(R.id.discounted_price);

        LinearLayoutManager layoutManager=new LinearLayoutManager(ProductDetailsActivity.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        couponsRecyclerView.setLayoutManager(layoutManager);


        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("Cashback","till 4th,June 2020","GET 20% Cahback on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Discount","till 4th,June 2020","GET 20% Cahback on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Buy 1 get 1 Free","till 4th,June 2020","GET 20% Cahback on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Cashback","till 4th,June 2020","GET 20% Cahback on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Discount","till 4th,June 2020","GET 20% Cahback on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Buy 1 get 1 Free","till 4th,June 2020","GET 20% Cahback on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Cashback","till 4th,June 2020","GET 20% Cahback on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Discount","till 4th,June 2020","GET 20% Cahback on any product above Rs.200/- and below Rs.3000/-."));
        rewardModelList.add(new RewardModel("Buy 1 get 1 Free","till 4th,June 2020","GET 20% Cahback on any product above Rs.200/- and below Rs.3000/-."));


        MyRewardsAdapter myRewardsAdapter = new MyRewardsAdapter(rewardModelList,true);
        couponsRecyclerView.setAdapter((myRewardsAdapter));
        myRewardsAdapter.notifyDataSetChanged();

        toggleRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialogRecyclerView();


            }
        });
//////////////////////COUPON DIALOG////////////////////

        couponRedeemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                checkCouponPriceDialog.show();
            }
        });
    }


    public static void showDialogRecyclerView(){
        if(couponsRecyclerView.getVisibility()==View.GONE){

            couponsRecyclerView.setVisibility(View.VISIBLE);
            selectedCoupon.setVisibility(View.GONE);
        }else{
            couponsRecyclerView.setVisibility(View.GONE);
            selectedCoupon.setVisibility(View.VISIBLE);

        }

    }
    private void setRating(int starPosition) {
        for(int x=0;x<rateNowContainer.getChildCount();x++){
            ImageView starButton=(ImageView)rateNowContainer.getChildAt(x);
            starButton.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if(x<=starPosition){
                starButton.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar items here those are search icon, cart icon, notification icon
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        } else if (id == R.id.main_search_icon) {
            return true;
        } else if (id == R.id.main_cart_icon) {
            Intent cartIntent = new Intent(ProductDetailsActivity.this,MainActivity.class);
            showCart = true;
            startActivity(cartIntent);
           // startActivity(new Intent(ProductDetailsActivity.this, OrderDetailsActivity.class));
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

}
