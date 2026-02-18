package app.sixthbca.labreport.LabThree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import app.sixthbca.R;

public class LabThreeAdapter extends RecyclerView.Adapter<LabThreeAdapter.ViewHolder> {

    private final Context context;
    private final String[] items;
    private final int[] icons;

    public LabThreeAdapter(Context context, String[] items, int[] icons) {
        this.context = context;
        this.items = items;
        this.icons = icons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lab_three_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemText.setText(items[position]);
        holder.itemIcon.setImageResource(icons[position]);

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Clicked: " + items[position], Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemIcon;
        TextView itemText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemIcon = itemView.findViewById(R.id.itemIcon);
            itemText = itemView.findViewById(R.id.itemText);
        }
    }
}