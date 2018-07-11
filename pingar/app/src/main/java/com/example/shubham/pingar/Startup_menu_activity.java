package com.example.shubham.pingar;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Startup_menu_activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_menu_activity);
        Toast.makeText(getApplicationContext(),"if you dont have enough quantity of food it will be a wise choice not to request the NGO for collection. Instead use the second option to find needy people around you!!",Toast.LENGTH_LONG).show();

    }

    public void toSetMarker(View v){
        // go to startup menu
        Intent i = new Intent(Startup_menu_activity.this,testing_location.class);
        startActivity(i);
    }

    public void toNeedymap (View v){
        //go to needy_db map
        Intent i = new Intent(Startup_menu_activity.this,web_page.class);
        startActivity(i);
    }
}
