package com.suhaas.pokeman.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Moves {
    @SerializedName("move")
    private Move move;
    @SerializedName("version_group_details")
    private List<VersionGroupDetails> versionGroupDetails;

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public List<VersionGroupDetails> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    public void setVersionGroupDetails(List<VersionGroupDetails> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
    }
}
