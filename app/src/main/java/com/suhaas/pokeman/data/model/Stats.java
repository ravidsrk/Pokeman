package com.suhaas.pokeman.data.model;

import com.google.gson.annotations.SerializedName;

public class Stats {
    @SerializedName("stat")
    private Stat stat;
    @SerializedName("effort")
    private int effort;
    @SerializedName("base_stat")
    private int baseStat;

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public int getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }
}
