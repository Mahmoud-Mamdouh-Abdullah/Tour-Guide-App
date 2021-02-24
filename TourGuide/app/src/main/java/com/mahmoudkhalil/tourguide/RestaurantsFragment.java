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
        restaurantsList.add(new PlaceModel("Egyptian Nights", "Originally constructed as a visitor’s palace, Cairo Marriott Hotel & Omar Khayyam Casino has provided guests the royal treatment for decades. Modern guestrooms offer luxury bedding, free Wi-Fi and 24-hour room service. Many have balconies with garden, city or Nile views. Luxury hotel suites feature generous layouts, kitchenettes and fireplaces. perks like free breakfast, afternoon tea and dessert. Enjoy on-site amenities including a 24-hour gym, outdoor lap pool, a spa and an elegant casino. Several of our 14 dining options are set in our lush gardens. Wedding and conference planners appreciate our hotel's versatile and unique event venues and proximity to some of the world’s most famous sites, including the Pyramids, Sphinx and Cairo Tower. Be transported to the Egypt of 1869 when you step into the lobby of our 5-star luxury hotel in downtown Cairo.", "Cairo", "Cairo Marriott Hotel - 16 Saray El, Gezira St, Zamalek, Cairo Governorate", "02 27283000", R.drawable.restaurant_image,4.1f));
        restaurantsList.add(new PlaceModel("Abou El Sid Restaurant", "Originally constructed as a visitor’s palace, Cairo Marriott Hotel & Omar Khayyam Casino has provided guests the royal treatment for decades. Modern guestrooms offer luxury bedding, free Wi-Fi and 24-hour room service. Many have balconies with garden, city or Nile views. Luxury hotel suites feature generous layouts, kitchenettes and fireplaces. perks like free breakfast, afternoon tea and dessert. Enjoy on-site amenities including a 24-hour gym, outdoor lap pool, a spa and an elegant casino. Several of our 14 dining options are set in our lush gardens. Wedding and conference planners appreciate our hotel's versatile and unique event venues and proximity to some of the world’s most famous sites, including the Pyramids, Sphinx and Cairo Tower. Be transported to the Egypt of 1869 when you step into the lobby of our 5-star luxury hotel in downtown Cairo.", "El Zamalek, Cairo Governorate", "Address: 157 26th of July Corridor, St, El Zamalek, Cairo Governorate", "02 27359640", R.drawable.restaurant_image,4.0f));
        restaurantsList.add(new PlaceModel("Zööba", "Originally constructed as a visitor’s palace, Cairo Marriott Hotel & Omar Khayyam Casino has provided guests the royal treatment for decades. Modern guestrooms offer luxury bedding, free Wi-Fi and 24-hour room service. Many have balconies with garden, city or Nile views. Luxury hotel suites feature generous layouts, kitchenettes and fireplaces. perks like free breakfast, afternoon tea and dessert. Enjoy on-site amenities including a 24-hour gym, outdoor lap pool, a spa and an elegant casino. Several of our 14 dining options are set in our lush gardens. Wedding and conference planners appreciate our hotel's versatile and unique event venues and proximity to some of the world’s most famous sites, including the Pyramids, Sphinx and Cairo Tower. Be transported to the Egypt of 1869 when you step into the lobby of our 5-star luxury hotel in downtown Cairo.", "Zamalek, Giza Governorate", "16 26 July St, Al Gabalayah, Zamalek, Giza Governorate", "02 27359640", R.drawable.restaurant_image,4.3f));
        restaurantsList.add(new PlaceModel("Attia Egyptian Street Food", "Originally constructed as a visitor’s palace, Cairo Marriott Hotel & Omar Khayyam Casino has provided guests the royal treatment for decades. Modern guestrooms offer luxury bedding, free Wi-Fi and 24-hour room service. Many have balconies with garden, city or Nile views. Luxury hotel suites feature generous layouts, kitchenettes and fireplaces. perks like free breakfast, afternoon tea and dessert. Enjoy on-site amenities including a 24-hour gym, outdoor lap pool, a spa and an elegant casino. Several of our 14 dining options are set in our lush gardens. Wedding and conference planners appreciate our hotel's versatile and unique event venues and proximity to some of the world’s most famous sites, including the Pyramids, Sphinx and Cairo Tower. Be transported to the Egypt of 1869 when you step into the lobby of our 5-star luxury hotel in downtown Cairo.", "Elsahel, Cairo Governorate", "2005 Nile Corniche, Asad, Elsahel, Cairo Governorate", "0115 097 0000", R.drawable.restaurant_image,4.3f));
        restaurantsList.add(new PlaceModel("3Almashy Egypt", "Originally constructed as a visitor’s palace, Cairo Marriott Hotel & Omar Khayyam Casino has provided guests the royal treatment for decades. Modern guestrooms offer luxury bedding, free Wi-Fi and 24-hour room service. Many have balconies with garden, city or Nile views. Luxury hotel suites feature generous layouts, kitchenettes and fireplaces. perks like free breakfast, afternoon tea and dessert. Enjoy on-site amenities including a 24-hour gym, outdoor lap pool, a spa and an elegant casino. Several of our 14 dining options are set in our lush gardens. Wedding and conference planners appreciate our hotel's versatile and unique event venues and proximity to some of the world’s most famous sites, including the Pyramids, Sphinx and Cairo Tower. Be transported to the Egypt of 1869 when you step into the lobby of our 5-star luxury hotel in downtown Cairo.", "Zamalek, Cairo Governorate", "12 Brazil St, Mohammed Mazhar, Zamalek, Cairo Governorate", "0109 187 7662", R.drawable.restaurant_image,4.2f));
        restaurantsList.add(new PlaceModel("Crimson Cair", "Originally constructed as a visitor’s palace, Cairo Marriott Hotel & Omar Khayyam Casino has provided guests the royal treatment for decades. Modern guestrooms offer luxury bedding, free Wi-Fi and 24-hour room service. Many have balconies with garden, city or Nile views. Luxury hotel suites feature generous layouts, kitchenettes and fireplaces. perks like free breakfast, afternoon tea and dessert. Enjoy on-site amenities including a 24-hour gym, outdoor lap pool, a spa and an elegant casino. Several of our 14 dining options are set in our lush gardens. Wedding and conference planners appreciate our hotel's versatile and unique event venues and proximity to some of the world’s most famous sites, including the Pyramids, Sphinx and Cairo Tower. Be transported to the Egypt of 1869 when you step into the lobby of our 5-star luxury hotel in downtown Cairo.", "Cairo", "St. (former Montazah St, 16 Kamal Al Tawil, Zamalek, Cairo Governorate", "0127 505 5555", R.drawable.restaurant_image,4.5f));
        restaurantsList.add(new PlaceModel("Saigon Restaurant & Lounge", "Originally constructed as a visitor’s palace, Cairo Marriott Hotel & Omar Khayyam Casino has provided guests the royal treatment for decades. Modern guestrooms offer luxury bedding, free Wi-Fi and 24-hour room service. Many have balconies with garden, city or Nile views. Luxury hotel suites feature generous layouts, kitchenettes and fireplaces. perks like free breakfast, afternoon tea and dessert. Enjoy on-site amenities including a 24-hour gym, outdoor lap pool, a spa and an elegant casino. Several of our 14 dining options are set in our lush gardens. Wedding and conference planners appreciate our hotel's versatile and unique event venues and proximity to some of the world’s most famous sites, including the Pyramids, Sphinx and Cairo Tower. Be transported to the Egypt of 1869 when you step into the lobby of our 5-star luxury hotel in downtown Cairo.", "Ramlet Beaulac, Cairo Governorate", "Fairmont Nile City, Nile City Towers - 2005 B, Corniche El Nil, Ramlet Beaulac, Cairo Governorate", "02 24619494", R.drawable.restaurant_image,4.6f));

        restaurantsAdapter = new PlaceRecyclerAdapter(restaurantsList, getActivity());

        restaurantsRecyclerView.setAdapter(restaurantsAdapter);
    }
}