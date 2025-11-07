package app.sixthbca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etEmail;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnForgetPass = findViewById(R.id.btn_forgot);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
    }

    public void onloginClick(View view) {
        // ToDo: Logic here
        Toast.makeText(MainActivity.this,
                "Hello Toast ",
                Toast.LENGTH_LONG).show();

        String email = etEmail.getText().toString();
        String pass = etPassword.getText().toString();

//        Log.e("Email Tag",email);
//        Log.e("Password Tag",pass);
//        if(email.isEmpty()){
//            etEmail.setError("This field is mandtory");
//        }


    }
}