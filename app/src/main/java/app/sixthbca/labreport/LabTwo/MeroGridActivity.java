package app.sixthbca.labreport.LabTwo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import app.sixthbca.R;

public class MeroGridActivity extends AppCompatActivity {

    GridView gridView;

    String[] items = {"FaceBook", "Google", "X"};
    int[] icons = {
            R.drawable.facebook,
            R.drawable.google,
            R.drawable.x
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mero_grid);

        gridView = findViewById(R.id.gridView);

        HamroCustomAdapter adapter = new HamroCustomAdapter(this, items, icons);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MeroGridActivity.this, "GridView: " + items[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}