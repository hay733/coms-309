package com.example.sumon.androidvolley;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.SearchView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

/**
 * Map class
 */
public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;
    SupportMapFragment mapFragment;
    SearchView searchView;

    /**
     * Creates the map view with a search bar
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        searchView = findViewById(R.id.svlocation);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.google_map);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            /**
             * Based on the "query"(inputted text) of the location a user entered,
             * As long as the location entered is not blank, the Geocoder will transform the
             * location inputted into a longitude and latitude of any common places.
             * Then, a marker is added to the longitude and latitude of the query
             * The map view will also zoom to the view of where the marker was placed
             * @param query
             * @return
             */
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location = searchView.getQuery().toString();
                List<Address> addressList = null;
                if(location != null || location.equals("")){
                    Geocoder geocoder = new Geocoder(MapActivity.this);
                    try{
                        addressList = geocoder.getFromLocationName(location, 1);
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                    Address address = addressList.get(0);
                    LatLng latLng = (new LatLng(address.getLatitude(), address.getLongitude()));
                    map.addMarker(new MarkerOptions().position(latLng).title(location));
                    map.animateCamera((CameraUpdateFactory.newLatLngZoom(latLng, 10)));
                }
                return false;
            }

            /**
             * Indicated when the Query Text changes
             * @param newText
             * @return
             */
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        mapFragment.getMapAsync(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.textView7)
            startActivity(new Intent(MapActivity.this,
                    Dashboard.class));
    }

    /**
     * Called when google map can be used. If users do not have google play services, the map
     * will not be able to run
     * @param googleMap
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
    }
}