package app.sixthbca.labreport.LabTwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import app.sixthbca.R;

public class HamroCustomAdapter extends BaseAdapter {
    String[] items;
    int[] icons;
    Context context;

    public HamroCustomAdapter(Context context, String[] items, int[] icons) {
        this.context = context;
        this.items = items;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.my_list_row, parent, false);
        }
        ImageView myImage = view.findViewById(R.id.myImg);
        TextView myName = view.findViewById(R.id.mytitle);

        myName.setText(items[position]);
        myImage.setImageResource(icons[position]);

        return view;
    }
}