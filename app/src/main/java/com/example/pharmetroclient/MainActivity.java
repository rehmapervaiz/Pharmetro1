package com.example.pharmetroclient;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT = 1;
    private static final int ORDERS_FRAGMENT = 2;
    private static final int WISHLIST_FRAGMENT = 3;

    private FrameLayout frameLayout;
    private ImageView actionBarLogo;
    private static int currentFragment = -1;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        actionBarLogo = findViewById(R.id.actionbar_logo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); /*basically title jo likha how ata hai applicaton ka wo remove kiya hai */

        //FloatingActionButton fab = findViewById(R.id.fab);
       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
       DrawerLayout drawer = findViewById(R.id.drawer_layout);
       // ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,"Open Navigation Drawer","Close Navigation Drawer");
        //drawer.addDrawerListener(toggle);
        //toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.getMenu().getItem(0).setChecked(true);

        frameLayout=findViewById(R.id.main_frame_layout);
        setFragment(new HomeFragment1(),HOME_FRAGMENT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(currentFragment == HOME_FRAGMENT){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getMenuInflater().inflate(R.menu.main,menu);
        }
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       //Handle action bar items here those are search icon, cart icon, notification icon
        int id =item.getItemId();

        if(id==R.id.main_search_icon){
            return  true;
        }else if (id==R.id.main_notification_icon){
            return true;
        }else if(id==R.id.main_cart_icon){
            gotoFragment("MY CART",new MyCartFragment(),CART_FRAGMENT);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void gotoFragment(String title,Fragment fragment,int fragmentNo) {
        actionBarLogo.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        invalidateOptionsMenu();
        setFragment(fragment, fragmentNo);
        if (fragmentNo == CART_FRAGMENT) {
            navigationView.getMenu().getItem(3).setChecked(true);
        }

    }

    public boolean onNavigationItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.nav_my_pharmacy){
            actionBarLogo.setVisibility(View.VISIBLE);
            invalidateOptionsMenu();
            setFragment(new HomeFragment1(),HOME_FRAGMENT);
        }
        else if(id==R.id.nav_my_orders){
            gotoFragment("MY ORDERS",new MyOrdersFragment(),ORDERS_FRAGMENT);
        }else if(id==R.id.nav_my_rewards){

        }else if(id==R.id.nav_my_cart){
            gotoFragment("MY CART",new MyCartFragment(),CART_FRAGMENT);

        }else if(id==R.id.nav_my_wishlist){

            gotoFragment("MY WISHLIST", new MyWishlistFragment(),WISHLIST_FRAGMENT);
        }else if(id==R.id.nav_my_account){

        }else if(id==R.id.nav_sign_out){
            return true;
        }

        DrawerLayout drawer=findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void setFragment(Fragment fragment,int fragmentNo) {
        if (fragmentNo != currentFragment) {
            currentFragment = fragmentNo;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(frameLayout.getId(), fragment);
            fragmentTransaction.commit();
        }
    }

}

