package com.mahmoudkhalil.tourguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.gson.Gson;

public class PlaceDetailsActivity extends AppCompatActivity {

    private ImageView placeImageView;
    private TextView placeNameTextView, placeDescriptionTextView, placeCityTextView, placePhoneTextView, placeAddressTextView, placeRatingCountTextView;
    private LinearLayout phoneLinearLayout;
    private RatingBar placeRatingBar;
    private String placeType;
    private PlaceModel placeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        init();
        setViewsValues();

    }

    @Override
    public void onBackPressed() {
        sendToMain();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            sendToMain();
        }
        return super.onOptionsItemSelected(item);
    }

    private void sendToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("type", placeType);
        startActivity(intent);
        finish();
    }

    private void init() {
        Gson gson = new Gson();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Details");

        placeImageView = findViewById(R.id.place_imageView);
        placeNameTextView = findViewById(R.id.placeName_textView);
        placeDescriptionTextView = findViewById(R.id.placeDesc_textView);
        placeCityTextView = findViewById(R.id.placeCity_textView);
        placePhoneTextView = findViewById(R.id.placePhone_textView);
        placeAddressTextView = findViewById(R.id.placeAddress_textView);
        phoneLinearLayout = findViewById(R.id.phone_linearLayout);
        placeRatingBar = findViewById(R.id.place_RatingBar);
        placeRatingCountTextView = findViewById(R.id.ratingCount_textView);

        placeType = getIntent().getStringExtra("type");
        String placeAsString = getIntent().getStringExtra("placeObj");


        placeModel = gson.fromJson(placeAsString, PlaceModel.class);
    }

    private void setViewsValues() {
        if(placeType.equals("historical")) {
            phoneLinearLayout.setVisibility(View.GONE);
        } else {
            placePhoneTextView.setText(placeModel.getPhone());
        }

        placeImageView.setImageResource(placeModel.getImageResID());
        placeNameTextView.setText(placeModel.getName());
        placeDescriptionTextView.setText(placeModel.getDescription());
        placeCityTextView.setText(placeModel.getCity());
        placeAddressTextView.setText(placeModel.getAddress());
        placeRatingBar.setRating(placeModel.getRate());
        placeRatingCountTextView.setText(String.valueOf(placeModel.getRate()));
    }
}