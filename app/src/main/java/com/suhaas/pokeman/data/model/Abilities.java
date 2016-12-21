package com.suhaas.pokeman.data.model;

import com.google.gson.annotations.SerializedName;

public class Abilities {
    @SerializedName("slot")
    private int slot;
    @SerializedName("is_hidden")
    private boolean isHidden;
    @SerializedName("ability")
    private Ability ability;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public boolean isIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
}
