package br.com.tvalerio.exercise.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class AlbumEntity extends BaseEntity {

    private static final long serialVersionUID = 6031797743204986084L;

    @Column(name = "number_of_tracks")
    private Integer numberOfTracks;

    @Column(name = "name")
    private String name;

    @Column(name = "artist_name")
    private String artistName;

    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "genre_id", nullable = false)
    private GenreEntity genre;

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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "AlbumEntity [numberOfTracks=" + numberOfTracks + ", name="
                + name + ", artistName=" + artistName + ", price=" + price
                + ", genre=" + genre + "]";
    }

}
