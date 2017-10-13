package azure.com.mytestapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class showActivity extends AppCompatActivity {

    private LocationManager locationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);




        Intent intent = getIntent();

        String text = intent.getStringExtra(TestMainActivity.EXTRA_MESSAGE);



        TextView showView = (TextView)findViewById(R.id.showView);
        showView.setTextSize(TypedValue.COMPLEX_UNIT_PX,getResources().getDimension(R.dimen.text_size));
        showView.setText(text);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    @Override
    protected void onResume() {
        super.onResume();
        LocationListener locationListener = new LocationTracker();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);

    }

    private class LocationTracker implements LocationListener{

        @Override
        public void onLocationChanged(Location location) {
            double longitude = location.getLongitude();
            double laititude = location.getLatitude();

            Log.v("Longitude",""+longitude);
            Log.v("laititude",""+laititude);

            Toast.makeText(getBaseContext(), "经度:"+longitude + " /n纬度:" + laititude,Toast.LENGTH_SHORT);


        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }



    public void showGps(View view){
        Log.v("showGps:","show gps start");




        boolean b2 = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED;
        Log.v("not use2",b2+"");

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        int i = 1;

        if(location == null){
            location =locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            i = 2;
        }



            double longitude = location.getLongitude();
            double laititude = location.getLatitude();

            Log.v("longitude:", ""+longitude);
            Log.v("laititude:",""+laititude);


            Toast toast = Toast.makeText(getBaseContext(),"longitude"+i+": "+longitude+"/n"+" laititude"+i+":"+laititude,Toast.LENGTH_SHORT);
            toast.show();




    }


}



