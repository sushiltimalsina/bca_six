package app.sixthbca.labreport.LabFour;

import android.os.Bundle;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.sixthbca.R;

public class LabFourPopupMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_four_popup_menu);

        TextView trigger = findViewById(R.id.popupMenuTrigger);
        trigger.setOnClickListener(this::showPopupMenu);
    }

    private void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
        
        popup.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.popup_share) {
                Toast.makeText(this, "Sharing...", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == R.id.popup_settings) {
                Toast.makeText(this, "Opening Settings...", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
        popup.show();
    }
}