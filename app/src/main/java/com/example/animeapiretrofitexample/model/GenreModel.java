package com.example.animeapiretrofitexample.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenreModel implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    public final static Parcelable.Creator<GenreModel> CREATOR = new Creator<GenreModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GenreModel createFromParcel(android.os.Parcel in) {
            return new GenreModel(in);
        }

        public GenreModel[] newArray(int size) {
            return (new GenreModel[size]);
        }

    }
            ;

    protected GenreModel(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GenreModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
    }

    public int describeContents() {
        return 0;
    }

}
