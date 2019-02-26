package br.com.tvalerio.exercise.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tvalerio.exercise.model.GenreEntity;

@Repository
public interface GenreRepository extends CrudRepository<GenreEntity, Long> {

    @Override
    public List<GenreEntity> findAll();

}
