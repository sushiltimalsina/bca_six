//package app.sixthbca;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class MyAdapter extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_my_adapter);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        String[] days ={"Sunday", "Monday", "Tuesday","Wednesday", "Thrusday", "Friday", "Saturday"};
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
//                this, android.R.layout.simple_list_item_1,days);
//        adapter1.setDropDownViewResource(R.layout.row_spin);
//        Spinner comboBox1 = findViewById(R.id.spin);
//        comboBox1.setAdaptor(adapter1);
//        comboBox1.setOnItemSelected(new AdapterView.OnItemSelectedListener(){
//            @Override
//        public void onItemSelected(AdapterView<?> adapterView, View view, int position), long id{
//                String value = days.item
//            }})
//
//        Spinner comboBox = findViewById(R.id.spin);
//        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,
//                R.array.days,
//                android.R.layout.simple_list_item_1);
//        adapter.setDropDownViewResource(R.layout.row_spin);
//        comboBox.setAdapter(adapter);
//        comboBox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            int selectdPosition = position;
//                Toast.makeText(MyAdapter.this, "I am at postion", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                System.out.println("Hello World Test Git Hub");
//
//            }
//        });
//    }
//}