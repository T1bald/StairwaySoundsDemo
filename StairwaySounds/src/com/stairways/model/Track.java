package com.stairways.model;

import java.io.Serializable;

/**
 * Created by matvey on 14.10.14.
 */
public class Track implements Serializable{

    public Track () {

    }

    private int idTrack;
    private int duration;
    private String name;
    private double price;
    private String description;
    private int albumId;
    private int authorId;

    @Override
    public String toString() {
        return name;
    }

    public boolean equals(Track track) {
        return (name.equals(track.getName()) && duration == track.duration && authorId == track.authorId);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public int getIdTrack() {
        return idTrack;
    }

    public void setIdTrack(int idTrack) {
        this.idTrack = idTrack;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
