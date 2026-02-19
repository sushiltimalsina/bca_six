package app.sixthbca.labreport.LabNine;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import app.sixthbca.R;

public class LabNineActivity extends AppCompatActivity {
    EditText etId, etName, etAge;
    TextView tvDisplay;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_nine);

        etId = findViewById(R.id.etID); etName = findViewById(R.id.etName); etAge = findViewById(R.id.etAge);
        tvDisplay = findViewById(R.id.tvDisplay);
        db = new DBHelper(this);

        findViewById(R.id.btnInsert).setOnClickListener(v -> {
            if (db.insert(etName.getText().toString(), etAge.getText().toString())) Toast.makeText(this, "Success", 0).show();
        });

        findViewById(R.id.btnRead).setOnClickListener(v -> {
            Cursor res = db.getAll();
            StringBuilder buffer = new StringBuilder();
            while (res.moveToNext()) {
                buffer.append("ID: ").append(res.getString(0)).append(", Name: ").append(res.getString(1)).append(", Age: ").append(res.getString(2)).append("\n");
            }
            tvDisplay.setText(buffer.toString());
        });

        findViewById(R.id.btnUpdate).setOnClickListener(v -> {
            if (db.update(etId.getText().toString(), etName.getText().toString(), etAge.getText().toString())) Toast.makeText(this, "Updated", 0).show();
        });

        findViewById(R.id.btnDelete).setOnClickListener(v -> {
            if (db.delete(etId.getText().toString())) Toast.makeText(this, "Deleted", 0).show();
        });
    }
}