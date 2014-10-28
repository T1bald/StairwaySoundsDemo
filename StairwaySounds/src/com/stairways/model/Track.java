package com.stairways.model;

import java.io.Serializable;

/**
 * Created by matvey on 28.10.14.
 */
public class Track implements Serializable{

    private int idTrack;
    private String name;
    private String filePath;
    private Integer price;
    private String duration;
    private String description;
    private int author_id;
    private int album_id;


    public int getIdTrack() {
        return idTrack;
    }

    public void setIdTrack(int idTrack) {
        this.idTrack = idTrack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track that = (Track) o;

        if (idTrack != that.idTrack) return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null)
            return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTrack;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
