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


public class HistoricalFragment extends Fragment {

    private RecyclerView historicalRecyclerView;
    private PlaceRecyclerAdapter historicalAdapter;
    private List<PlaceModel> historicalList;
    private View view;
    public HistoricalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_historical, container, false);

        init();

        historicalAdapter.setOnItemClickListener(new PlaceRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Gson gson = new Gson();
                Intent intent = new Intent(getActivity(), PlaceDetailsActivity.class);
                String placeString = gson.toJson(historicalList.get(position));
                intent.putExtra("type", "historical");
                intent.putExtra("placeObj", placeString);
                startActivity(intent);
            }
        });

        return view;
    }

    private void init() {
        historicalRecyclerView = view.findViewById(R.id.historical_recyclerView);
        historicalList = new ArrayList<>();
        historicalList.add(new PlaceModel(getString(R.string.cairo_tower), getString(R.string.cairo_tower_desc),getString(R.string.cairo), getString(R.string.cairo_tower_address), R.drawable.cairo_tower,4.5f));
        historicalList.add(new PlaceModel(getString(R.string.el_karnak), getString(R.string.karnak_desc),getString(R.string.luxor),getString(R.string.karnak_address), R.drawable.egypt_luxor_karnak_temple,4.5f));
        historicalList.add(new PlaceModel(getString(R.string.aswan_dam), getString(R.string.aswan_dam_desc),getString(R.string.aswan),getString(R.string.aswan_dam_address), R.drawable.high_dam,4.5f));
        historicalList.add(new PlaceModel(getString(R.string.giza_pyramids), getString(R.string.pyramids_desc),getString(R.string.giza),getString(R.string.pyramids_address), R.drawable.pyramids_giza,4.5f));
        historicalList.add(new PlaceModel(getString(R.string.qaitbay), getString(R.string.qaitbay_desc),getString(R.string.alex),getString(R.string.qaitbay_address), R.drawable.kayitbay_castle_alexandria,4.5f));
        historicalList.add(new PlaceModel(getString(R.string.library_alex), getString(R.string.alex_library_desc),getString(R.string.alex),getString(R.string.alex_library_address), R.drawable.alex_library,4.5f));
        historicalList.add(new PlaceModel(getString(R.string.saint_cathrine), getString(R.string.saint_cathrine_desc),getString(R.string.sinai),getString(R.string.saint_cathrine_address), R.drawable.saints_kathrine,4.5f));
        historicalList.add(new PlaceModel(getString(R.string.abu_simble), getString(R.string.abu_simple_desc),getString(R.string.aswan),getString(R.string.abu_simple_address), R.drawable.abu_simple,4.5f));

        historicalAdapter = new PlaceRecyclerAdapter(historicalList, getActivity());

        historicalRecyclerView.setAdapter(historicalAdapter);
    }
}