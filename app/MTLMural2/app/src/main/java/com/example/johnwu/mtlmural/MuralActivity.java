package com.example.johnwu.mtlmural;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MuralActivity extends FragmentActivity {

//    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mural);
        new DownloadImageTask((ImageView) findViewById(R.id.imageMural))
                .execute("http://s.orzzzz.com/news/a0/b7//552f49e59cedd.jpg");



    }


    //write a method to get all the data from the backend

}
