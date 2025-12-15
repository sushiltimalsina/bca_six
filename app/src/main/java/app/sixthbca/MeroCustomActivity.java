package app.sixthbca;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MeroCustomActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mero_custom);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        HamroCustomAdapter adapter = new HamroCustomAdapter(MeroCustomActivity.this);

    }
}

class HamroCustomAdapter extends BaseAdapter {
    String[] name = {"Abhash", "Anjali", "Bimal",};
    String[] Nickname = {"Hallkari", "Hasmati", "Silent"};
    int[] images = {R.drawable.photo,
            R.drawable.photo, R.drawable.photo,
            R.drawable.ic_launcher_background, R.drawable.photo};
    Context context;

    HamroCustomAdapter(Context c) {
        this.context = c;
    }

    @Override
    public int getCount() {
        return name.length;

    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.my_list_row, parent, false);
            ImageView myImage = view.findViewById(R.id.myImg);
            TextView myName = view.findViewById(R.id.mytitle);
            TextView myNickName = view.findViewById(R.id.mytitle1);

            myName.setText(name[position]);
            myNickName.setText(Nickname[position]);
            myImage.setImageResource(images[position]);

        }
        return null;
    }
}