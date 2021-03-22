package com.mahmoudkhalil.tourguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder> {

    private List<Integer> imagesIDs;

    public SliderAdapter(List<Integer> imagesIDs) {
        this.imagesIDs = imagesIDs;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slider_item,parent,false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        viewHolder.sliderImageView.setImageResource(imagesIDs.get(position));
    }

    @Override
    public int getCount() {
        return imagesIDs.size();
    }

    public static class SliderViewHolder extends SliderViewAdapter.ViewHolder {
        ImageView sliderImageView;
        public SliderViewHolder(View itemView) {
            super(itemView);
            sliderImageView = itemView.findViewById(R.id.slider_image_view);
        }
    }
}
