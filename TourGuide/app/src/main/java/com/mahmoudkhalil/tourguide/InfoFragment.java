package com.mahmoudkhalil.tourguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class InfoFragment extends Fragment {

    private SliderView sliderView;
    private SliderAdapter sliderAdapter;
    private List<Integer> sliderImageResIDsList;

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        sliderView = (SliderView) view.findViewById(R.id.slider_view);
        sliderViewSetUp();

        return view;
    }

    private void sliderViewSetUp() {
        sliderImageResIDsList = new ArrayList<>();
        sliderImageResIDsList.add(R.drawable.pyramids_giza);
        sliderImageResIDsList.add(R.drawable.the_egyptian_museum);
        sliderImageResIDsList.add(R.drawable.cairo_tower);
        sliderImageResIDsList.add(R.drawable.egypt_luxor_karnak_temple);
        sliderAdapter = new SliderAdapter(sliderImageResIDsList);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }
}