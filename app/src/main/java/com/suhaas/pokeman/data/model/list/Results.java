package com.suhaas.pokeman.data.model.list;

import com.google.gson.annotations.SerializedName;

public class Results {
    int _id;
    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
