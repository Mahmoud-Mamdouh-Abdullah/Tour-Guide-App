package com.mahmoudkhalil.tourguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class RestaurantsFragment extends Fragment {

    private RecyclerView restaurantsRecyclerView;
    private PlaceRecyclerAdapter restaurantsAdapter;
    private List<PlaceModel> restaurantsList;
    private View view;

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_restaurants, container, false);

        init();
        restaurantsAdapter.setOnItemClickListener(new PlaceRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Gson gson = new Gson();
                Intent intent = new Intent(getActivity(), PlaceDetailsActivity.class);
                String placeString = gson.toJson(restaurantsList.get(position));
                intent.putExtra("type", "restaurant");
                intent.putExtra("placeObj", placeString);
                startActivity(intent);
            }
        });

        return view;
    }

    private void init() {
        restaurantsRecyclerView = view.findViewById(R.id.restaurants_recyclerView);
        restaurantsList = new ArrayList<>();
        restaurantsList.add(new PlaceModel(getString(R.string.rest1_name), getString(R.string.rest_desc), getString(R.string.cairo), getString(R.string.rest1_address), getString(R.string.rest1_phone), R.drawable.restaurant_image,4.1f));
        restaurantsList.add(new PlaceModel(getString(R.string.rest2_name), getString(R.string.rest_desc), getString(R.string.rest2_city), getString(R.string.rest2_address), getString(R.string.rest2_phone), R.drawable.restaurant_image,4.0f));
        restaurantsList.add(new PlaceModel(getString(R.string.rest3_name), getString(R.string.rest_desc), getString(R.string.rest2_city), getString(R.string.rest3_address), getString(R.string.rest3_phone), R.drawable.restaurant_image,4.3f));
        restaurantsList.add(new PlaceModel(getString(R.string.rest4_name), getString(R.string.rest_desc), getString(R.string.rest4_city), getString(R.string.rest4_address), getString(R.string.rest4_phone), R.drawable.restaurant_image,4.3f));
        restaurantsList.add(new PlaceModel(getString(R.string.rest5_name), getString(R.string.rest_desc), getString(R.string.rest2_city), getString(R.string.rest5_address), getString(R.string.rest5_phone), R.drawable.restaurant_image,4.2f));
        restaurantsList.add(new PlaceModel(getString(R.string.rest6_name), getString(R.string.rest_desc), getString(R.string.cairo), getString(R.string.rest6_address), getString(R.string.rest6_phone), R.drawable.restaurant_image,4.5f));
        restaurantsList.add(new PlaceModel(getString(R.string.rest7_name), getString(R.string.rest_desc), getString(R.string.rest7_city), getString(R.string.rest7_address), getString(R.string.rest7_phone), R.drawable.restaurant_image,4.6f));

        restaurantsAdapter = new PlaceRecyclerAdapter(restaurantsList, getActivity());

        restaurantsRecyclerView.setAdapter(restaurantsAdapter);
    }
}