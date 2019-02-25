package br.com.tvalerio.exercice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.tvalerio.exercice.model.AlbumEntity;

@Repository
public interface AlbumRepository
        extends PagingAndSortingRepository<AlbumEntity, Long> {

    @Override
    public List<AlbumEntity> findAll();

    public Page<AlbumEntity> findByGenreName(String genre, Pageable pageable);
}
