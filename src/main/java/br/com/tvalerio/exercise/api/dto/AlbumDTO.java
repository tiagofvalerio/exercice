package br.com.tvalerio.exercise.api.dto;

import java.math.BigDecimal;

public class AlbumDTO {

    private Long id;

    private Integer numberOfTracks;

    private String name;

    private String artistName;

    private BigDecimal price;

    private String genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(Integer numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
