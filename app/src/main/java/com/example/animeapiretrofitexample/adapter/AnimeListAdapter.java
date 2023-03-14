package com.example.animeapiretrofitexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.pdf.PdfDocument;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.example.animeapiretrofitexample.R;
import com.example.animeapiretrofitexample.databinding.AnimeListItemBinding;
import com.example.animeapiretrofitexample.model.AnimeInfoModel;
import com.example.animeapiretrofitexample.view.AnimeDetailsActivity;

import java.util.ArrayList;
//with paging adapter
public class AnimeListAdapter  extends PagedListAdapter<AnimeInfoModel,AnimeListAdapter.ViewHolder> {
    Context context;
    ArrayList<AnimeInfoModel> animeInfoModels;

    public AnimeListAdapter(Context context) {
        super(AnimeInfoModel.CALLBACK);
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      /*  View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.anime_list_item,parent,false);
        return new ViewHolder(v);*/

        AnimeListItemBinding animeListItemBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.anime_list_item,parent,false);
        return new ViewHolder(animeListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //AnimationDrawable animPlaceholder = (AnimationDrawable) ContextCompat.getDrawable(context, R.drawable.loading_no_bg);
        //  holder.AnimeRankingTx.setText("Ranking :"+animeInfoModels.get(position).getRanking());
        //  holder.AnimeTitleTx.setText(animeInfoModels.get(position).getTitle());
     /*   Glide.with(context)
                .load(animeInfoModels.get(position).getImage())
                .thumbnail(Glide.with(context)
                        .load(R.drawable.loading_no_bg))
                .into(holder.AnimeImage);*/
        //.placeholder(R.drawable.loading_no_bg)
        //.crossFade()
        AnimeInfoModel animeInfoModel=getItem(position);
        String image=animeInfoModel.getImage();
        animeInfoModel.setImage(image);
        holder.animeListItemBinding.setAnimeInfo(animeInfoModel);



    }

  /*  @Override
    public int getItemCount() {
        return animeInfoModels.size();
    }*/

    public class ViewHolder extends RecyclerView.ViewHolder {
        /* ImageView AnimeImage;
         TextView AnimeTitleTx,AnimeRankingTx;
         LinearLayout AnimeCard;*/
        AnimeListItemBinding animeListItemBinding;
        public ViewHolder(@NonNull AnimeListItemBinding animeListItemBinding) {
            super(animeListItemBinding.getRoot());
            this.animeListItemBinding=animeListItemBinding;
            /*AnimeImage=itemView.findViewById(R.id.anime_image);
            AnimeTitleTx=itemView.findViewById(R.id.anime_title);
            AnimeRankingTx=itemView.findViewById(R.id.anime_ranking);
            AnimeCard=itemView.findViewById(R.id.anime_card);*/

            animeListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION)
                    {
                        AnimeInfoModel animeInfoModel=getItem(position);
                        Intent intent=new Intent(context, AnimeDetailsActivity.class);
                        intent.putExtra("anime",animeInfoModel);
                        context.startActivity(intent);
                    }

                }
            });
        }

    }
}

///old recycler
/*public class AnimeListAdapter  extends RecyclerView.Adapter<AnimeListAdapter.ViewHolder> {
    Context context;
    ArrayList<AnimeInfoModel> animeInfoModels;

    public AnimeListAdapter(Context context, ArrayList<AnimeInfoModel> animeInfoModels) {
        this.context = context;
        this.animeInfoModels = animeInfoModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      *//*  View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.anime_list_item,parent,false);
        return new ViewHolder(v);*//*

        AnimeListItemBinding animeListItemBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.anime_list_item,parent,false);
        return new ViewHolder(animeListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //AnimationDrawable animPlaceholder = (AnimationDrawable) ContextCompat.getDrawable(context, R.drawable.loading_no_bg);
      //  holder.AnimeRankingTx.setText("Ranking :"+animeInfoModels.get(position).getRanking());
      //  holder.AnimeTitleTx.setText(animeInfoModels.get(position).getTitle());
     *//*   Glide.with(context)
                .load(animeInfoModels.get(position).getImage())
                .thumbnail(Glide.with(context)
                        .load(R.drawable.loading_no_bg))
                .into(holder.AnimeImage);*//*
        //.placeholder(R.drawable.loading_no_bg)
        //.crossFade()
        AnimeInfoModel animeInfoModel=animeInfoModels.get(position);
        String image=animeInfoModel.getImage();
        animeInfoModel.setImage(image);
        holder.animeListItemBinding.setAnimeInfo(animeInfoModel);



    }

    @Override
    public int getItemCount() {
        return animeInfoModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       *//* ImageView AnimeImage;
        TextView AnimeTitleTx,AnimeRankingTx;
        LinearLayout AnimeCard;*//*
        AnimeListItemBinding animeListItemBinding;
        public ViewHolder(@NonNull AnimeListItemBinding animeListItemBinding) {
            super(animeListItemBinding.getRoot());
            this.animeListItemBinding=animeListItemBinding;
            *//*AnimeImage=itemView.findViewById(R.id.anime_image);
            AnimeTitleTx=itemView.findViewById(R.id.anime_title);
            AnimeRankingTx=itemView.findViewById(R.id.anime_ranking);
            AnimeCard=itemView.findViewById(R.id.anime_card);*//*

            animeListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION)
                    {
                        AnimeInfoModel animeInfoModel=animeInfoModels.get(position);
                        Intent intent=new Intent(context, AnimeDetailsActivity.class);
                        intent.putExtra("anime",animeInfoModel);
                        context.startActivity(intent);
                    }

                }
            });
        }

    }
}*/
