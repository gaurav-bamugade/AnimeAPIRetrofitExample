package com.example.animeapiretrofitexample.model;

import android.os.Parcelable;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;


import com.example.animeapiretrofitexample.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AnimeInfoModel extends BaseObservable implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("alternativeTitles")
    @Expose
    private List<String> alternativeTitles = new ArrayList<>();
    @SerializedName("ranking")
    @Expose
    private Integer ranking;
    @SerializedName("genres")
    @Expose
    private List<String> genres = new ArrayList<>();
    @SerializedName("episodes")
    @Expose
    private Integer episodes;
    @SerializedName("hasEpisode")
    @Expose
    private Boolean hasEpisode;
    @SerializedName("hasRanking")
    @Expose
    private Boolean hasRanking;
    @SerializedName("image")
    @Expose
    private String image;
    @BindingAdapter(("image"))
    public static void loadImage(ImageView view,String imageURI)
    {
        Glide.with(view.getContext())
                .load(imageURI)
                .thumbnail(Glide.with(view.getContext())
                        .load(R.drawable.loading_no_bg))
                .into(view);
    }



    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("synopsis")
    @Expose
    private String synopsis;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("type")
    @Expose
    private String type;
    public final static Creator<AnimeInfoModel> CREATOR = new Creator<AnimeInfoModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AnimeInfoModel createFromParcel(android.os.Parcel in) {
            return new AnimeInfoModel(in);
        }

        public AnimeInfoModel[] newArray(int size) {
            return (new AnimeInfoModel[size]);
        }

    }
            ;

    protected AnimeInfoModel(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.alternativeTitles, (java.lang.String.class.getClassLoader()));
        this.ranking = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.genres, (java.lang.String.class.getClassLoader()));
        this.episodes = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.hasEpisode = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.hasRanking = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.link = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.synopsis = ((String) in.readValue((String.class.getClassLoader())));
        this.thumb = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
    }

    public AnimeInfoModel() {
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public List<String> getAlternativeTitles() {
        return alternativeTitles;
    }

    public void setAlternativeTitles(List<String> alternativeTitles) {
        this.alternativeTitles = alternativeTitles;
        notifyPropertyChanged(BR.alternativeTitles);
    }

    @Bindable
    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
        notifyPropertyChanged(BR.ranking);
    }

    @Bindable
    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
        notifyPropertyChanged(BR.genres);
    }

    @Bindable
    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
        notifyPropertyChanged(BR.episodes);
    }

    @Bindable
    public Boolean getHasEpisode() {
        return hasEpisode;
    }

    public void setHasEpisode(Boolean hasEpisode) {
        this.hasEpisode = hasEpisode;
        notifyPropertyChanged(BR.hasEpisode);
    }

    @Bindable
    public Boolean getHasRanking() {
        return hasRanking;
    }

    public void setHasRanking(Boolean hasRanking) {
        this.hasRanking = hasRanking;
        notifyPropertyChanged(BR.hasRanking);
    }

    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        notifyPropertyChanged(BR.image);
    }

    @Bindable
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
        notifyPropertyChanged(BR.link);
    }

    @Bindable
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyPropertyChanged(BR.status);
    }

    @Bindable
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
        notifyPropertyChanged(BR.synopsis);
    }

    @Bindable
    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
        notifyPropertyChanged(BR.thumb);
    }

    @Bindable
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        notifyPropertyChanged(BR.type);
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeList(alternativeTitles);
        dest.writeValue(ranking);
        dest.writeList(genres);
        dest.writeValue(episodes);
        dest.writeValue(hasEpisode);
        dest.writeValue(hasRanking);
        dest.writeValue(image);
        dest.writeValue(link);
        dest.writeValue(status);
        dest.writeValue(synopsis);
        dest.writeValue(thumb);
        dest.writeValue(type);
    }

    public int describeContents() {
        return 0;
    }
    public static final DiffUtil.ItemCallback<AnimeInfoModel> CALLBACK=new DiffUtil.ItemCallback<AnimeInfoModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull AnimeInfoModel oldItem, @NonNull AnimeInfoModel newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull AnimeInfoModel oldItem, @NonNull AnimeInfoModel newItem) {
            return true;
        }
    };
}