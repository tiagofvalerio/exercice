package br.com.tvalerio.exercise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import br.com.tvalerio.exercise.api.AlbumFilter;
import br.com.tvalerio.exercise.model.AlbumEntity;
import br.com.tvalerio.exercise.repository.AlbumRepository;

@Component
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Optional<AlbumEntity> findById(Long id) {
        return albumRepository.findById(id);
    }

    public void saveAllAlbums(List<AlbumEntity> albums) {
        albumRepository.saveAll(albums);
    }

    public Page<AlbumEntity> findAlbumsPaginated(AlbumFilter filter) {
        return albumRepository.findByGenreName(filter.getGenre(),
                PageRequest.of(filter.getPage(), filter.getSize(),
                        Direction.valueOf(filter.getDirection()),
                        filter.getOrder()));
    }
}