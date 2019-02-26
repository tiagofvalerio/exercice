package br.com.tvalerio.exercise.model.assembler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import org.springframework.data.domain.Page;

import br.com.tvalerio.exercise.api.dto.AlbumDTO;
import br.com.tvalerio.exercise.integration.spotify.model.SpotifyAlbumResponse;
import br.com.tvalerio.exercise.model.AlbumEntity;
import br.com.tvalerio.exercise.model.GenreEntity;

public class AlbumAssembler {

    public List<AlbumEntity> fromSpotifyAlbumToAlbumEntity(
            SpotifyAlbumResponse spotifyAlbumResponse, GenreEntity genre) {

        List<AlbumEntity> albums = new ArrayList<>();

        spotifyAlbumResponse.getAlbum().getItems().forEach(item -> {
            AlbumEntity albumEntity = new AlbumEntity();
            albumEntity.setName(item.getName());
            albumEntity.setNumberOfTracks(item.getTotalTracks());
            albumEntity.setArtistName(item.getArtists().get(0).getName());
            albumEntity.setGenre(genre);
            albumEntity.setPrice(getRandomPrice());
            albums.add(albumEntity);
        });

        return albums;
    }

    public AlbumDTO fromAlbumEntityToAlbumDTO(AlbumEntity albumEntity) {
        AlbumDTO dto = new AlbumDTO();

        dto.setId(albumEntity.getId());
        dto.setArtistName(albumEntity.getArtistName());
        dto.setGenre(albumEntity.getGenre().getName());
        dto.setName(albumEntity.getName());
        dto.setNumberOfTracks(albumEntity.getNumberOfTracks());
        dto.setPrice(albumEntity.getPrice());

        return dto;
    }

    public Page<AlbumDTO> fromAlbumEntityPageToAlbumDTOPage(
            Page<AlbumEntity> albumEntityPage) {
        return albumEntityPage.map(new Function<AlbumEntity, AlbumDTO>() {
            @Override
            public AlbumDTO apply(AlbumEntity albumEntity) {
                return fromAlbumEntityToAlbumDTO(albumEntity);
            }
        });
    }

    private BigDecimal getRandomPrice() {
        return new BigDecimal(BigInteger.valueOf(new Random().nextInt(8000)),
                2);
    }
}
