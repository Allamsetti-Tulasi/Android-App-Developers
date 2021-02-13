package diet.edu.recyclerview_abr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    int images[]= {R.drawable.a,R.drawable.b,R.drawable.c,
    R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
    R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k};
    String names[]={"Asha","Blender","Cupcake","Donut",
    "Eclair","Froyo","Gingerbread","HoneyComb","IceCreamsandwich",
            "JellyBean","Kitkat"};
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler1);
        myAdapter = new MyAdapter(this,images,names);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}