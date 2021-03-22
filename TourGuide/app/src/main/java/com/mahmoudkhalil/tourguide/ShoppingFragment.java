package com.mahmoudkhalil.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class ShoppingFragment extends Fragment {

    private RecyclerView shopsRecyclerView;
    private PlaceRecyclerAdapter shopsAdapter;
    private List<PlaceModel> shopsList;
    private View view;
    
    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_shopping, container, false);

        init();

        shopsAdapter.setOnItemClickListener(new PlaceRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Gson gson = new Gson();
                Intent intent = new Intent(getActivity(), PlaceDetailsActivity.class);
                String placeString = gson.toJson(shopsList.get(position));
                intent.putExtra("type", "shop");
                intent.putExtra("placeObj", placeString);
                startActivity(intent);
            }
        });

        return view;
    }

    private void init() {
        shopsRecyclerView = view.findViewById(R.id.shops_recyclerView);
        shopsList = new ArrayList<>();
        shopsList.add(new PlaceModel(getString(R.string.mall1_name), getString(R.string.mall1_desc), getString(R.string.mall1_city), getString(R.string.mall1_address), getString(R.string.mall1_phone), R.drawable.shopping_mall,4.6f));
        shopsList.add(new PlaceModel(getString(R.string.mall2_name), getString(R.string.mall2_desc), getString(R.string.giza), getString(R.string.mall2_address), getString(R.string.mall2_phone), R.drawable.shopping_mall,4.3f));
        shopsList.add(new PlaceModel(getString(R.string.mall3_name), getString(R.string.mall3_desc), getString(R.string.cairo), getString(R.string.mall3_address), getString(R.string.mall3_phone), R.drawable.shopping_mall,3.8f));
        shopsList.add(new PlaceModel(getString(R.string.mall4_name), getString(R.string.mall4_desc), getString(R.string.mall4_city), getString(R.string.mall4_address), getString(R.string.mall4_phone), R.drawable.shopping_mall,4.6f));
        shopsList.add(new PlaceModel(getString(R.string.mall5_name), getString(R.string.mall6_desc), getString(R.string.mall4_city), getString(R.string.mall5_address), getString(R.string.mall5_phone), R.drawable.shopping_mall,4.8f));

        shopsAdapter = new PlaceRecyclerAdapter(shopsList, getActivity());

        shopsRecyclerView.setAdapter(shopsAdapter);
    }
}