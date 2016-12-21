package com.suhaas.pokeman.data.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemanResponse {

    @SerializedName("name")
    private String name;
    @SerializedName("weight")
    private int weight;
    @SerializedName("sprites")
    private Sprites sprites;
    @SerializedName("location_area_encounters")
    private String locationAreaEncounters;
    @SerializedName("height")
    private int height;
    @SerializedName("is_default")
    private boolean isDefault;
    @SerializedName("species")
    private Species species;
    @SerializedName("id")
    private int id;
    @SerializedName("order")
    private int order;
    @SerializedName("base_experience")
    private int baseExperience;
    @SerializedName("forms")
    private List<Forms> forms;
    @SerializedName("abilities")
    private List<Abilities> abilities;
    @SerializedName("stats")
    private List<Stats> stats;
    @SerializedName("moves")
    private List<Moves> moves;
    @SerializedName("held_items")
    private List<?> heldItems;
    @SerializedName("game_indices")
    private List<GameIndices> gameIndices;
    @SerializedName("types")
    private List<Types> types;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public List<Forms> getForms() {
        return forms;
    }

    public void setForms(List<Forms> forms) {
        this.forms = forms;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    public List<?> getHeldItems() {
        return heldItems;
    }

    public void setHeldItems(List<?> heldItems) {
        this.heldItems = heldItems;
    }

    public List<GameIndices> getGameIndices() {
        return gameIndices;
    }

    public void setGameIndices(List<GameIndices> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }
}
