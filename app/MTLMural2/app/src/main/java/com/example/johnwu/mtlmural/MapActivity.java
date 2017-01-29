package com.example.johnwu.mtlmural;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.Manifest;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import controller.MuralDataController;
import model.Mural;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    final List<Mural>[] muralList = new List[]{null}; // List of murals

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            } else {
                // Permission was denied. Display an error message.
            }
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Google map
        mMap = googleMap;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(MapActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        }

        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(45.5033,-73.576) , 11.5f) );

        // Populate the list
        populateList();

        // Populate map using the list
        for ( Mural mural : muralList[0]) {
            LatLng position = new LatLng( mural.getProperties().getLatitude(), mural.getProperties().getLongitude() );
            Marker m = mMap.addMarker(new MarkerOptions().position(position).title(mural.getProperties().getAddress() + "\n" + mural.getProperties().getArtist()));
            m.setTag(mural);
        }

        // Set a listener for marker tap
        mMap.setOnMarkerClickListener(this);

    }

    /* Populates the murals list by spawning a new thread */
    public void populateList(){
        // Thread that gets mural data
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try  {
                    try {
                        MuralDataController muralData = new MuralDataController();
                        muralList[0] = muralData.getMuralData();
                    } catch (Exception e) {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Start thread
        try {
            thread.start();
            thread.join();
        } catch (Exception e) {}
    }

    @Override
    public boolean onMarkerClick(final Marker marker){
        // Retrieve the data from the marker.
        Mural muralClicked = (Mural) marker.getTag();



        // Check if a click count was set, then display the click count.
        if (muralClicked != null) {
            Intent activity = new Intent(MapActivity.this, MuralActivity.class);
            activity.putExtra("myMural", new Gson().toJson(muralClicked));
            startActivity(activity);
        }

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }
}
