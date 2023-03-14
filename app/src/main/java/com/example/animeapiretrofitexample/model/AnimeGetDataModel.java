package com.example.animeapiretrofitexample.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AnimeGetDataModel implements Parcelable
{

    @SerializedName("data")
    @Expose
    private List<AnimeInfoModel> data = new ArrayList<>();
    @SerializedName("meta")
    @Expose
    private AnimeMetaModel meta;
    public final static Creator<AnimeGetDataModel> CREATOR = new Creator<AnimeGetDataModel>() {
        @SuppressWarnings({"unchecked"})
        public AnimeGetDataModel createFromParcel(android.os.Parcel in) {
            return new AnimeGetDataModel(in);
        }
        public AnimeGetDataModel[] newArray(int size) {
            return (new AnimeGetDataModel[size]);
        }

    };

    protected AnimeGetDataModel(android.os.Parcel in) {
        in.readList(this.data, (AnimeInfoModel.class.getClassLoader()));
        this.meta = ((AnimeMetaModel) in.readValue((AnimeMetaModel.class.getClassLoader())));
    }

    public AnimeGetDataModel() {
    }

    public List<AnimeInfoModel> getData() {
        return data;
    }

    public void setData(List<AnimeInfoModel> data) {
        this.data = data;
    }

    public AnimeMetaModel getMeta() {
        return meta;
    }

    public void setMeta(AnimeMetaModel meta) {
        this.meta = meta;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(data);
        dest.writeValue(meta);
    }

    public int describeContents() {
        return 0;
    }

}
