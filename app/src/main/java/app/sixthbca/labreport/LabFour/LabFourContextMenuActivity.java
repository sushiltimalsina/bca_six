package app.sixthbca.labreport.LabFour;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import app.sixthbca.R;

public class LabFourContextMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_four_context_menu);

        TextView trigger = findViewById(R.id.contextMenuTrigger);
        registerForContextMenu(trigger);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Context Options");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.ctx_edit) {
            Toast.makeText(this, "Editing...", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.ctx_delete) {
            Toast.makeText(this, "Deleting...", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}