package com.example.pathfinder.models.bindingModels;

import com.example.pathfinder.models.entityModels.Category;
import com.example.pathfinder.models.entityModels.Picture;
import com.example.pathfinder.models.entityModels.User;
import com.example.pathfinder.models.entityModels.enums.LevelEnum;

import java.util.Set;

public class RouteBindingModel {

    private Long id;
    private String gpxCoordinates;
    private LevelEnum level;
    private String name;
    private User author;
    private String description;
    private String videoUrl;
    private Set<Category> categories;
    private Set<Picture> pictures;

    public RouteBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public RouteBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteBindingModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteBindingModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public RouteBindingModel setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public RouteBindingModel setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public RouteBindingModel setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
