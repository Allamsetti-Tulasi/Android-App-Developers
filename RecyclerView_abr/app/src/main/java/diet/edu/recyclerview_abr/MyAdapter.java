package diet.edu.recyclerview_abr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewInfo> {
    Context context;
    int images[];
    String names[];

    public MyAdapter(Context context, int[] images, String[] names) {
        this.context = context;
        this.images = images;
        this.names = names;
    }

    @NonNull
    @Override
    public MyAdapter.ViewInfo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.row,parent,
                false);
        return new ViewInfo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewInfo holder, int position) {
     holder.imageView.setImageResource(images[position]);
     holder.textView.setText(names[position]);
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Toast.makeText(context, "position "+position, Toast.LENGTH_SHORT).show();
         }
     });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewInfo extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewInfo(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img1);
            textView = itemView.findViewById(R.id.text1);
        }
    }
}
