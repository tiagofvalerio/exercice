package br.com.tvalerio.exercise.api;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tvalerio.exercise.api.dto.AlbumDTO;
import br.com.tvalerio.exercise.model.AlbumEntity;
import br.com.tvalerio.exercise.model.assembler.AlbumAssembler;
import br.com.tvalerio.exercise.service.AlbumService;

@RestController
@RequestMapping("/albums")
public class AlbumApi {

    Logger logger = LoggerFactory.getLogger(AlbumApi.class);

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
            logger.info("Error searching albums...");
            logger.debug(e.getStackTrace().toString());
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
            logger.info("Error searching album...");
            logger.debug(e.getStackTrace().toString());
            return ResponseEntity.badRequest().build();
        }
    }
}
