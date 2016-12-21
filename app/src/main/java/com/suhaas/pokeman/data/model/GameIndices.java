package com.suhaas.pokeman.data.model;

import com.google.gson.annotations.SerializedName;

public class GameIndices {
    @SerializedName("version")
    private Version version;
    @SerializedName("game_index")
    private int gameIndex;

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public int getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(int gameIndex) {
        this.gameIndex = gameIndex;
    }
}
