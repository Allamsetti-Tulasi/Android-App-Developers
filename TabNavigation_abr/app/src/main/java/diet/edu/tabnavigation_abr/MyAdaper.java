package diet.edu.tabnavigation_abr;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyAdaper extends FragmentPagerAdapter {
    ArrayList<String> strings = new ArrayList<>();


    public MyAdaper(FragmentManager supportFragmentManager) {
        super(supportFragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString("ID",strings.get(position));
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Override
    public int getCount() {
        return strings.size();
    }
    public void  add(){
        strings.add("Chat");
        strings.add("Status");
        strings.add("Calls");

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
