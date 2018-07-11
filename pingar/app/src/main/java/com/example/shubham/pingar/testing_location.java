package com.example.shubham.pingar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class testing_location extends AppCompatActivity {

    private Button button;
   // private TextView textView;
    private LocationManager locationManager;
    private LocationListener listener;
    double passLat;
    double passLng;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_location);

        //textView = (TextView) findViewById(R.id.textView3);
        button = (Button) findViewById(R.id.button2);



        locationManager =(LocationManager) getSystemService(LOCATION_SERVICE);

        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //textView.append("\n" + location.getLongitude() + "    " + location.getLatitude());

                passLat = location.getLatitude();
                passLng = location.getLongitude();
                if(flag==0) {flag=1;
                    Intent passLatLng = new Intent(testing_location.this, final_set_pickup.class);
                    passLatLng.putExtra("lat", Double.toString(passLat));
                    passLatLng.putExtra("lng", Double.toString(passLng));
                    startActivity(passLatLng);
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };

        configure_button();
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                configure_button();
                break;
            default:
                break;
        }
    }

    void configure_button() {
        // first check for permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}
                        , 10);
            }
            return;
        }
        // this code won'textView execute IF permissions are not allowed, because in the line above there is return statement.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //noinspection MissingPermission
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 8000,0, listener);//every 8000ms = 8sec location will be updated
                //change first parameter to LocationManager.NETWORK_PROVIDER to see faster results.

                Toast.makeText(getApplicationContext(),"please wait while we seek location...",Toast.LENGTH_SHORT).show();

                           }
        });
    }
}
