package com.news.mix;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.news.adapter.mix.MixAdapter;
import com.news.databinding.MixFragmentBinding;
import com.news.model.ArticlesModel;

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


    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);


        mixViewModel = new ViewModelProvider(requireActivity()).get(MixViewModel.class);

        mixViewModel.getNews().observe(getViewLifecycleOwner(), new Observer<ArrayList<ArticlesModel>>()
        {
            @Override
            public void onChanged(ArrayList<ArticlesModel> articlesModels)
            {
                mixAdapter = new MixAdapter(articlesModels);
                binding.rVMix.setAdapter(mixAdapter);
                binding.rVMix.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                binding.rVMix.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
                mixAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();

        mixViewModel.getNews().removeObservers(getViewLifecycleOwner());
    }
}