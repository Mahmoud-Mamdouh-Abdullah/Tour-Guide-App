package com.mahmoudkhalil.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlaceRecyclerAdapter extends RecyclerView.Adapter<PlaceRecyclerAdapter.PlaceViewHolder> {

    private List<PlaceModel> placeModelList;
    private onItemClickListener mListener;
    private Context mContext;

    public PlaceRecyclerAdapter(List<PlaceModel> placeModelList, Context context) {
        this.placeModelList = placeModelList;
        notifyDataSetChanged();
        mContext = context;
    }

    @NonNull
    @Override
    public PlaceRecyclerAdapter.PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new PlaceViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceRecyclerAdapter.PlaceViewHolder holder, int position) {
        int colorID = getViewColor(position);
        holder.view.setBackgroundColor(colorID);
        holder.placeImageView.setImageResource(placeModelList.get(position).getImageResID());
        holder.placeNameTextView.setText(placeModelList.get(position).getName());
        if(placeModelList.get(position).getPhone() == null) {
            holder.placeCityTextView.setText(placeModelList.get(position).getCity());
        } else {
            holder.placeCityTextView.setText(placeModelList.get(position).getPhone());
        }
    }

    private int getViewColor (int position) {
        switch (position % 4) {
            case 0:
                return mContext.getResources().getColor(R.color.color1);
            case 1:
                return mContext.getResources().getColor(R.color.color2);
            case 2:
                return mContext.getResources().getColor(R.color.color3);
            case 3:
                return mContext.getResources().getColor(R.color.color4);
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return placeModelList.size();
    }

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        this.mListener = listener;
    }

    public static class PlaceViewHolder extends RecyclerView.ViewHolder {
        ImageView placeImageView;
        TextView placeNameTextView, placeCityTextView;
        View view;
        public PlaceViewHolder(@NonNull View itemView, final onItemClickListener listener) {
            super(itemView);
            placeImageView = itemView.findViewById(R.id.place_imageView);
            placeNameTextView = itemView.findViewById(R.id.placeName_textView);
            placeCityTextView = itemView.findViewById(R.id.phoneOrCity_textView);
            view = itemView.findViewById(R.id.view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
