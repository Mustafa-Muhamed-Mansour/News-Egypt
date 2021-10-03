package com.news.adapter.mix;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.news.databinding.ItemMixBinding;
import com.news.model.ArticlesModel;
import com.news.model.NewsModel;

import java.util.ArrayList;

public class MixAdapter extends RecyclerView.Adapter<MixAdapter.MixViewHolder>
{

    private ArrayList<ArticlesModel> articlesModels;

    public MixAdapter(ArrayList<ArticlesModel> articlesModels)
    {
        this.articlesModels = articlesModels;
    }

    @NonNull
    @Override
    public MixViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new MixViewHolder(ItemMixBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MixViewHolder holder, int position)
    {
        ArticlesModel model = articlesModels.get(position);
        holder.binding.itemTxtTitle.setText(model.getTitle());
        holder.binding.itemTxtDescription.setText(model.getDescription());
        Glide
                .with(holder.itemView.getContext())
                .load(model.getUrlToImage())
                .into(holder.binding.itemImgMix);
    }

    @Override
    public int getItemCount()
    {
        return articlesModels.size();
    }

    public class MixViewHolder extends RecyclerView.ViewHolder
    {
        private ItemMixBinding binding;

        public MixViewHolder(@NonNull ItemMixBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
