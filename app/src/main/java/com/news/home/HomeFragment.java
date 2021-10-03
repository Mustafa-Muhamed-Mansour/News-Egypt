package com.news.home;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.news.R;
import com.news.adapter.tabslayout.TabsLayoutAdapter;
import com.news.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment
{

    private FragmentHomeBinding binding;
    private TabsLayoutAdapter tabsLayoutAdapter;
    private FragmentManager fragmentManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        fragmentManager = getActivity().getSupportFragmentManager();
        tabsLayoutAdapter = new TabsLayoutAdapter(fragmentManager, getLifecycle());
        binding.viewPager.setAdapter(tabsLayoutAdapter);
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Mix").setIcon(R.drawable.ic_mix));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Sport").setIcon(R.drawable.ic_sport));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Health").setIcon(R.drawable.ic_health));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Technology").setIcon(R.drawable.ic_technology));

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {
            }
        });

        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback()
        {
            @Override
            public void onPageSelected(int position)
            {
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position));
            }
        });
    }
}