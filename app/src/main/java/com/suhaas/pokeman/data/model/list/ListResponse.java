package com.suhaas.pokeman.data.model.list;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListResponse {
    @SerializedName("count")
    private int count;
    @SerializedName("previous")
    private Object previous;
    @SerializedName("next")
    private String next;
    @SerializedName("results")
    private List<Results> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
