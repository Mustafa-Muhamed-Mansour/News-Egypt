package com.news.adapter.tabslayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.news.health.HealthFragment;
import com.news.mix.MixFragment;
import com.news.sport.SportFragment;
import com.news.technology.TechnologyFragment;

public class TabsLayoutAdapter extends FragmentStateAdapter
{

    Fragment[] fragments = new Fragment[]
            {
                    new MixFragment(),
                    new SportFragment(),
                    new HealthFragment(),
                    new TechnologyFragment()
            };


    public TabsLayoutAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle)
    {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position)
    {
        return fragments.clone()[position];
    }


    @Override
    public int getItemCount()
    {
        return fragments.length;
    }
}
