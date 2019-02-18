package net.myprojects.guardappv2;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class RoundActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final LatLng P1 = new LatLng(32.459785, -116.825426);
    private static final LatLng P2 = new LatLng(32.460850, -116.824323);
    private static final LatLng P3 = new LatLng(32.461173, -116.825266);
    private static final LatLng P4 = new LatLng(32.460258, -116.825968);
    private static final LatLng P5 = new LatLng(32.459552, -116.826155);
    private static final LatLng P6 = new LatLng(32.459785, -116.825426);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Round");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        MarkerOptions p1 = new MarkerOptions();

        p1.position(P1);

        p1.title("my position");

        mMap.addMarker(p1);

        MarkerOptions p2 = new MarkerOptions();

        p2.position(P2);

        p2.title("my position");

        mMap.addMarker(p2);

        MarkerOptions p3 = new MarkerOptions();

        p3.position(P3);

        p3.title("my position");

        mMap.addMarker(p3);

        MarkerOptions p4 = new MarkerOptions();

        p4.position(P4);

        p4.title("my position");

        mMap.addMarker(p4);

        MarkerOptions p5 = new MarkerOptions();

        p5.position(P5);

        p5.title("my position");

        mMap.addMarker(p5);

        MarkerOptions p6 = new MarkerOptions();

        p6.position(P6);

        p6.title("my position");

        mMap.addMarker(p6);

        PolylineOptions options = new PolylineOptions()
                .add(P1)
                .add(P2)
                .add(P3)
                .add(P4)
                .add(P5)
                .add(P6)
                .width(5)
                .color(Color.BLUE)
                .geodesic(true);
        mMap.addPolyline(options);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(P1,18));
    }
}
