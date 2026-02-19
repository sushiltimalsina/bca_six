package app.sixthbca.labreport.LabEight;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import app.sixthbca.R;

public class LabEightActivity extends AppCompatActivity {

    private TextView tvResultDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_eight);

        tvResultDisplay = findViewById(R.id.tvResultDisplay);
        findViewById(R.id.btnOpenDialog).setOnClickListener(v -> showCustomDialog());
    }

    private void showCustomDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_student);
        dialog.getWindow().setLayout(-1, -2); // Match Parent Width, Wrap Content Height

        EditText etName = dialog.findViewById(R.id.etName);
        EditText etRoll = dialog.findViewById(R.id.etRoll);
        EditText etResult = dialog.findViewById(R.id.etResult);
        EditText etGrade = dialog.findViewById(R.id.etGrade);
        Button btnSave = dialog.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String details = "Name: " + etName.getText().toString() +
                    "\nRoll: " + etRoll.getText().toString() +
                    "\nResult: " + etResult.getText().toString() +
                    "\nGrade: " + etGrade.getText().toString();

            tvResultDisplay.setText(details);
            dialog.dismiss();
        });

        dialog.show();
    }
}