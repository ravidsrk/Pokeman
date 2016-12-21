package com.suhaas.pokeman.data.model;

import com.google.gson.annotations.SerializedName;

public class Types {
    @SerializedName("slot")
    private int slot;
    @SerializedName("type")
    private Type type;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
