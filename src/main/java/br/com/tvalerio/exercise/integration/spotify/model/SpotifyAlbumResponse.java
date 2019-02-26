package br.com.tvalerio.exercise.integration.spotify.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpotifyAlbumResponse {

    @JsonProperty("albums")
    private Album album;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "SpotifyAlbumResponse [album=" + album + "]";
    }
}
