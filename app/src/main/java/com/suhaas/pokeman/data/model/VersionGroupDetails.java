package com.suhaas.pokeman.data.model;

import com.google.gson.annotations.SerializedName;
public class VersionGroupDetails {
    @SerializedName("move_learn_method")
    private MoveLearnMethod moveLearnMethod;
    @SerializedName("level_learned_at")
    private int levelLearnedAt;
    @SerializedName("version_group")
    private VersionGroup versionGroup;

    public MoveLearnMethod getMoveLearnMethod() {
        return moveLearnMethod;
    }

    public void setMoveLearnMethod(MoveLearnMethod moveLearnMethod) {
        this.moveLearnMethod = moveLearnMethod;
    }

    public int getLevelLearnedAt() {
        return levelLearnedAt;
    }

    public void setLevelLearnedAt(int levelLearnedAt) {
        this.levelLearnedAt = levelLearnedAt;
    }

    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }
}
