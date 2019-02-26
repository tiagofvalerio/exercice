package br.com.tvalerio.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tvalerio.exercise.model.GenreEntity;
import br.com.tvalerio.exercise.repository.GenreRepository;

@Component
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<GenreEntity> getAllGenres() {
        return genreRepository.findAll();
    }
}
