package app.sixthbca.labreport.LabSix;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import app.sixthbca.R;

public class LabSixFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_six_fragment);

        // --- Adding Fragment Dynamically ---
        // 1. Create an instance of the fragment
        DynamicFragment dynamicFragment = new DynamicFragment();

        // 2. Get FragmentManager and start a transaction
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // 3. Replace/Add the fragment into the container (FrameLayout)
        transaction.replace(R.id.dynamicFragmentContainer, dynamicFragment);

        // 4. Commit the transaction
        transaction.commit();
    }
}