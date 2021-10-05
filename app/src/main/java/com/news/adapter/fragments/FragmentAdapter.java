package com.news.adapter.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.news.databinding.ItemNewsBinding;
import com.news.model.ArticlesModel;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{

    private Context context;
    private ArrayList<ArticlesModel> articlesModels;

    public Adapter(Context context, ArrayList<ArticlesModel> articlesModels)
    {
        this.context = context;
        this.articlesModels = articlesModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        ArticlesModel model = articlesModels.get(position);
        holder.binding.itemTxtTitle.setText(model.getTitle());
        holder.binding.itemTxtSourceName.setText(model.getSourceResponse().getName());
        holder.binding.itemTxtPublished.setText(model.getPublishedAt());
        holder.binding.itemTxtDescription.setText(model.getDescription());
        Glide
                .with(holder.itemView.getContext())
                .load(model.getUrlToImage())
                .into(holder.binding.itemImgMix);

        holder.binding.itemBtnRead.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW);
                intentWebsite.setData(Uri.parse(model.getUrl()));
                context.startActivity(intentWebsite);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return articlesModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private ItemNewsBinding binding;

        public ViewHolder(@NonNull ItemNewsBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
