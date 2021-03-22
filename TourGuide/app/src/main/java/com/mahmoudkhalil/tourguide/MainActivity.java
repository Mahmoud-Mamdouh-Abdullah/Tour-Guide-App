package com.mahmoudkhalil.tourguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private FrameLayout contentFrameLayout;
    private String placeType;

    private static final float END_SCALE = 0.7f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeType = getIntent().getStringExtra("type");
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        contentFrameLayout = (FrameLayout) findViewById(R.id.fragment_container);

        setSupportActionBar(toolbar);

        initNavigationDrawer();

        openRightFragment();
    }

    private void openRightFragment() {
        if (placeType == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new InfoFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_info);
            getSupportActionBar().setTitle(R.string.about_egypt_header);
        } else {
            if (placeType.equals("historical")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HistoricalFragment()).commit();
                navigationView.setCheckedItem(R.id.nav_places);
                getSupportActionBar().setTitle(R.string.historical_header);
            } else if (placeType.equals("restaurant")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RestaurantsFragment()).commit();
                navigationView.setCheckedItem(R.id.nav_restaurants);
                getSupportActionBar().setTitle(R.string.rest_header);
            } else if (placeType.equals("shop")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ShoppingFragment()).commit();
                navigationView.setCheckedItem(R.id.nav_shopping);
                getSupportActionBar().setTitle(R.string.shops_header);
            }
        }
    }

    private void initNavigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.colorAccent));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {

            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentFrameLayout.setScaleX(offsetScale);

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentFrameLayout.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentFrameLayout.setTranslationX(xTranslation);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.END))
            drawerLayout.closeDrawer(GravityCompat.END);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_places:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HistoricalFragment()).commit();
                getSupportActionBar().setTitle(R.string.historical_header);
                break;
            case R.id.nav_restaurants:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RestaurantsFragment()).commit();
                getSupportActionBar().setTitle(R.string.rest_header);
                break;
            case R.id.nav_shopping:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ShoppingFragment()).commit();
                getSupportActionBar().setTitle(R.string.shops_header);
                break;
            case R.id.nav_info:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InfoFragment()).commit();
                getSupportActionBar().setTitle(R.string.about_egypt_header);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}