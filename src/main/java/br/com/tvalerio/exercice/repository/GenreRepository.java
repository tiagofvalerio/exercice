package br.com.tvalerio.exercice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tvalerio.exercice.model.GenreEntity;

@Repository
public interface GenreRepository extends CrudRepository<GenreEntity, Long> {

    @Override
    public List<GenreEntity> findAll();

}
