package com.news.ui.splash;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.R;
import com.news.adapter.mix.MixAdapter;
import com.news.databinding.FragmentSplashBinding;
import com.news.mix.MixViewModel;
import com.news.model.ArticlesModel;

import java.util.ArrayList;

public class SplashFragment extends Fragment
{

    private FragmentSplashBinding binding;
    private NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentSplashBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                navController.navigate(R.id.action_splashFragment_to_homeFragment);
            }
        }, 3000);
    }
}