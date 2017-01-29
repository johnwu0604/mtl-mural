package com.example.johnwu.mtlmural;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.*;
import android.text.method.ScrollingMovementMethod;
import android.support.v7.app.*;
import android.support.v7.widget.*;



import com.google.gson.Gson;

import model.Mural;


public class MuralActivity extends AppCompatActivity{

//    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mural);

        String jsonMyObject = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            jsonMyObject = extras.getString("myMural");
        }
        Mural mural = new Gson().fromJson(jsonMyObject, Mural.class);
        new DownloadImageTask((ImageView) findViewById(R.id.imageMural))
                .execute(mural.getProperties().getImage());
        TextView muralDescription = (TextView) findViewById(R.id.muralDescription);
//        muralDescription.setText(mural.getProperties().toString());
        String muralText = "\nby " + mural.getProperties().getArtist() + " (" + mural.getProperties().getYear() + ")\nAddress: " + mural.getProperties().getAddress() + "\nProgram: " + mural.getProperties().getProgram();
        muralDescription.setText(muralText);
        muralDescription.setMovementMethod(new ScrollingMovementMethod());


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }




}
