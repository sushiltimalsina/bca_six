package app.sixthbca.labreport.LabThree;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.sixthbca.R;

public class LabThreeRecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String[] items = {"Apple", "Banana", "Cherry", "Grapes", "Mango"};
    int[] icons = {
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.cherry,
            R.drawable.grapes,
            R.drawable.mango
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_three_recycler);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LabThreeAdapter adapter = new LabThreeAdapter(this, items, icons);
        recyclerView.setAdapter(adapter);
    }
}