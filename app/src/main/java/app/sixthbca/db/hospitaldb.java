    package app.sixthbca.db;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.sixthbca.R;

public class hospitaldb extends AppCompatActivity {
HospitalHelper hospitaldb;
    EditText nameEt, specEt, expEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hospitaldb);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        hospitaldb = new HospitalHelper(this);
        nameEt = findViewById(R.id.d_name);
        specEt = findViewById(R.id.d_specilaization);
        expEt = findViewById(R.id.d_experience);

        EditText Dname = findViewById(R.id.d_name);
        EditText Dspecilaization = findViewById(R.id.d_specilaization);
        EditText Dexperience = findViewById(R.id.d_experience);

        Button btd_add = findViewById(R.id.btd_add);
        Button btd_dispaly = findViewById(R.id.btd_dispaly);

        btd_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Dname.getText().toString();
                String specialization = Dspecilaization.getText().toString();
                String  experience = Dexperience.getText().toString();

                if(!name.isEmpty() && !specialization.isEmpty() && !experience.isEmpty()){
                    double experienceYears = Double.parseDouble(experience);
                    hospitaldb.insertDoctor(name, specialization, experienceYears);
                    Toast.makeText(hospitaldb.this, "Add success message", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(hospitaldb.this, "Fill the form all the way", Toast.LENGTH_SHORT).show();

                }
            }
        });

        //onclick listener for the view (calls the view page)
        btd_dispaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(hospitaldb.this, "View ko toast", Toast.LENGTH_SHORT).show();
                Cursor returnData = hospitaldb.getAllDoctor();

                while(returnData.moveToNext()){
                    int id = returnData.getInt(returnData.getColumnIndexOrThrow("id"));
                    String name = returnData.getString(returnData.getColumnIndexOrThrow("Doctor's Name"));
                    String specialization = returnData.getString(returnData.getColumnIndexOrThrow("Specilization"));
                    String experience = returnData.getString(returnData.getColumnIndexOrThrow("Experience"));

                    Log.d("Data Haru", id + " " + name + " " + specialization + " " + experience);

                }
            }
        });
    }
}