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
        historicalList.add(new PlaceModel("Cairo Tower", getString(R.string.cairo_tower_desc),"Cairo", "Zamalek, Cairo Governorate", R.drawable.cairo_tower,4.5f));
        historicalList.add(new PlaceModel("El-Karnak Temple", getString(R.string.karnak_desc),"Luxor","Karnak, Luxor, Luxor Governorate.", R.drawable.egypt_luxor_karnak_temple,4.5f));
        historicalList.add(new PlaceModel("Aswan Dam", getString(R.string.aswan_dam_desc),"Aswan","Manteqet as Sad Al Aali, Qism Aswan, Aswan Governorate.", R.drawable.high_dam,4.5f));
        historicalList.add(new PlaceModel("Giza pyramid", getString(R.string.pyramids_desc),"Giza","Al Haram, Nazlet El-Semman, Al Giza Desert, Giza Governorate", R.drawable.pyramids_giza,4.5f));
        historicalList.add(new PlaceModel("Citadel of Qaitbay", getString(R.string.qaitbay_desc),"Alexandria","As Sayalah Sharq, Qesm Al Gomrok, Alexandria Governorate", R.drawable.kayitbay_castle_alexandria,4.5f));
        historicalList.add(new PlaceModel("Library of Alexandria", getString(R.string.alex_library_desc),"Alexandria","Al Azaritah WA Ash Shatebi, Qism Bab Sharqi, Alexandria Governorate", R.drawable.alex_library,4.5f));
        historicalList.add(new PlaceModel("Saint Catherine's Monastery", getString(R.string.saint_cathrine_desc),"Sinai","Saint Catherine, South Sinai Governorate", R.drawable.saints_kathrine,4.5f));
        historicalList.add(new PlaceModel("Abu Simbel temples", getString(R.string.abu_simple_desc),"Aswan","Abu Simbel, Aswan Governorate", R.drawable.abu_simple,4.5f));

        historicalAdapter = new PlaceRecyclerAdapter(historicalList, getActivity());

        historicalRecyclerView.setAdapter(historicalAdapter);
    }
}