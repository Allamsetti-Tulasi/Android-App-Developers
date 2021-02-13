package diet.edu.tabnavigation_abr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    MyAdaper myAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab1);
        viewPager = findViewById(R.id.viewpager1);
        myAdaper =new MyAdaper(getSupportFragmentManager());
        myAdaper.add();
        viewPager.setAdapter(myAdaper);
        tabLayout.setupWithViewPager(viewPager);
    }
}