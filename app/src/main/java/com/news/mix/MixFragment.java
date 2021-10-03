package com.news.mix;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.R;
import com.news.adapter.mix.MixAdapter;
import com.news.databinding.MixFragmentBinding;
import com.news.model.ArticlesModel;
import com.news.model.NewsModel;

import java.util.ArrayList;

public class MixFragment extends Fragment
{

    private MixFragmentBinding binding;
    private MixViewModel mixViewModel;
    private MixAdapter mixAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        binding = MixFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        mixViewModel = new ViewModelProvider(requireActivity()).get(MixViewModel.class);

        binding.progressBarMix.setVisibility(View.VISIBLE);

        mixViewModel.getNews().observe(getViewLifecycleOwner(), new Observer<ArrayList<ArticlesModel>>()
        {
            @Override
            public void onChanged(ArrayList<ArticlesModel> articlesModels)
            {
                binding.progressBarMix.setVisibility(View.INVISIBLE);
                mixAdapter = new MixAdapter(articlesModels);
                binding.rVMix.setAdapter(mixAdapter);
                binding.rVMix.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                binding.rVMix.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
            }
        });
    }
}