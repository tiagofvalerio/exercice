package br.com.tvalerio.exercice.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tvalerio.exercice.api.dto.AlbumDTO;
import br.com.tvalerio.exercice.model.AlbumEntity;
import br.com.tvalerio.exercice.model.assembler.AlbumAssembler;
import br.com.tvalerio.exercice.service.AlbumService;

@RestController
@RequestMapping("/albums")
public class AlbumApi {

    @Autowired
    private AlbumService albumService;

    @SuppressWarnings("rawtypes")
    @GetMapping(produces = "application/json")
    public ResponseEntity<Page> findAlbums(
            @RequestParam(name = "genre", required = true) String genre,
            @RequestParam(name = "order", defaultValue = "name") String order,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size,
            @RequestParam(name = "direction", defaultValue = "ASC") String direction) {
        try {
            AlbumFilter filter = AlbumFilter.builder()
                    .withGenre(genre.toUpperCase()).withOrder(order)
                    .withPage(page).withSize(size).withDirection(direction)
                    .build();

            Page<AlbumEntity> albums = albumService.findAlbumsPaginated(filter);

            return ResponseEntity.ok().body(new AlbumAssembler()
                    .fromAlbumEntityPageToAlbumDTOPage(albums));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<AlbumDTO> searchAlbumById(
            @PathVariable(value = "id") String id) {
        try {
            Optional<AlbumEntity> album = albumService
                    .findById(Long.valueOf(id));

            if (album.isPresent()) {
                return ResponseEntity.ok().body(new AlbumAssembler()
                        .fromAlbumEntityToAlbumDTO(album.get()));
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
