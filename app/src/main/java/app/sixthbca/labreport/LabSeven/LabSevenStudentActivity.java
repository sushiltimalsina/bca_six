package app.sixthbca.labreport.LabSeven;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import app.sixthbca.R;

public class LabSevenStudentActivity extends AppCompatActivity {

    private TextView tvDisplay;
    // Using a very stable public API
    private static final String API_URL = "https://jsonplaceholder.typicode.com/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_seven_student);

        tvDisplay = findViewById(R.id.tvDisplay);
        Button btnFetch = findViewById(R.id.btnFetch);

        btnFetch.setOnClickListener(v -> fetchData());
    }

    private void fetchData() {
        tvDisplay.setText("Connecting to Real API...");
        RequestQueue queue = Volley.newRequestQueue(this);

        // Fetching an array of users from the real internet API
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, API_URL, null,
                response -> {
                    try {
                        StringBuilder result = new StringBuilder();
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject student = response.getJSONObject(i);

                            // Mapping API fields to your requirements
                            int id = student.getInt("id");
                            String name = student.getString("name");
                            int age = 20 + i; // Simulated age
                            String faculty = "BCA"; // Simulated faculty

                            result.append("ID: ").append(id)
                                    .append("\nName: ").append(name)
                                    .append("\nAge: ").append(age)
                                    .append("\nFaculty: ").append(faculty)
                                    .append("\n--------------------\n");
                        }
                        tvDisplay.setText(result.toString());
                    } catch (JSONException e) {
                        tvDisplay.setText("Parse Error: " + e.getMessage());
                    }
                },
                error -> tvDisplay.setText("Network Error: Make sure your internet is working!\n\n" + error.toString())
        );

        queue.add(request);
    }
}