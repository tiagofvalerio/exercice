package br.com.tvalerio.exercise.integration.spotify.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    private String name;

    @JsonProperty("total_tracks")
    private Integer totalTracks;

    private List<Artist> artists;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(Integer totalTracks) {
        this.totalTracks = totalTracks;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", totalTracks=" + totalTracks
                + ", artists=" + artists + "]";
    }
}
