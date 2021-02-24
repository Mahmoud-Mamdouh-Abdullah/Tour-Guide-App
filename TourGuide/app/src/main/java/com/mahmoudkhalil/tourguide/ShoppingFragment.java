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
        shopsList.add(new PlaceModel("Cairo Festival City Mall", "Spacious retail complex with international chain stores, a cinema & a \"dancing fountain\" attraction.", "New Cairo، Cairo Governorate", "108.04 km، Cairo Festival City Mall, Cairo Festival City, Ring Road, New Cairo، Cairo Governorate", "02 26186000", R.drawable.shopping_mall,4.6f));
        shopsList.add(new PlaceModel("The First Mall", "Glamorous mall at the Four Seasons Hotel featuring luxury boutiques & a French restaurant.", "Giza", "35 Giza Street - Inside Four Seasons Hotel, Giza District", "02 35717803", R.drawable.shopping_mall,4.3f));
        shopsList.add(new PlaceModel("Ramses Mall", "Basic, old-school mall with stores for clothing, accessories & souvenirs, casual dining & a cinema.", "Cairo", "Sahel Al Ghelel, Sharkas, Bulaq, Cairo Governorate", "02 25752025", R.drawable.shopping_mall,3.8f));
        shopsList.add(new PlaceModel("Mall of Egypt", "Mall of Egypt is a shopping mall in Cairo, Egypt, owned and operated by the Majid Al Futtaim Group, located on Wahat Road. The mall houses major department stores, fashion, lifestyle, sports, electronics, home furnishing outlets", "6th of October", "El Wahat Rd, First 6th of October, Giza Governorate", "02 36120084", R.drawable.shopping_mall,4.6f));
        shopsList.add(new PlaceModel("Arab Mall", "Huge shopping complex with brand-name stores, a food court, movie theater & fountain display.", "6th of October", "Al Giza Desert, Giza Governorate", "02 38260200", R.drawable.shopping_mall,4.8f));

        shopsAdapter = new PlaceRecyclerAdapter(shopsList, getActivity());

        shopsRecyclerView.setAdapter(shopsAdapter);
    }
}