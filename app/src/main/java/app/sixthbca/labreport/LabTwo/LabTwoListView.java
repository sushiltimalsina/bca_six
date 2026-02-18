package app.sixthbca.labreport.LabTwo;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import app.sixthbca.R;

public class LabTwoListView extends AppCompatActivity {

    ListView listView;

    String[] items = {"FaceBook", "Google", "X"};
    int[] icons = {
            R.drawable.facebook,
            R.drawable.google,
            R.drawable.x
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_two_list_view);

        listView = findViewById(R.id.listView);

        HamroCustomAdapter adapter = new HamroCustomAdapter(this, items, icons);
        listView.setAdapter(adapter);
    }
}