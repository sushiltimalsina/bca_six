package app.sixthbca.labreport.LabFive;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import app.sixthbca.R;

public class LabFiveMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_five_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Coordinates for Kathmandu (example center)
        LatLng kathmandu = new LatLng(27.7172, 85.3240);
        
        // Two "nearest" places (example markers)
        LatLng place1 = new LatLng(27.7120, 85.3129); // Near Kathmandu
        LatLng place2 = new LatLng(27.7050, 85.3300); // Near Kathmandu

        mMap.addMarker(new MarkerOptions().position(place1).title("Nearest Place 1"));
        mMap.addMarker(new MarkerOptions().position(place2).title("Nearest Place 2"));
        
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kathmandu, 14f));
    }
}