package app.sixthbca.labreport;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import app.sixthbca.R;

public class labonecalculator extends AppCompatActivity {

    EditText num1, num2;
    TextView result;
    Button btnResult;
    RadioGroup radioGroupOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labonecalculator);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.txtResult);
        btnResult = findViewById(R.id.btnResult);
        radioGroupOperator = findViewById(R.id.radio_group_operator);

        btnResult.setOnClickListener(v -> calculate());
    }

    private void calculate() {
        if (num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()) {
            result.setText(R.string.calculator_error_enter_numbers);
            return;
        }

        double a = Double.parseDouble(num1.getText().toString());
        double b = Double.parseDouble(num2.getText().toString());
        double res = 0;

        int selectedId = radioGroupOperator.getCheckedRadioButtonId();

        if (selectedId == R.id.radio_add) {
            res = a + b;
        } else if (selectedId == R.id.radio_sub) {
            res = a - b;
        } else if (selectedId == R.id.radio_mul) {
            res = a * b;
        } else if (selectedId == R.id.radio_div) {
            if (b == 0) {
                result.setText(R.string.calculator_error_divide_by_zero);
                return;
            }
            res = a / b;
        }

        result.setText(getString(R.string.calculator_result, res));
    }
}