package br.com.tvalerio.exercice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tvalerio.exercice.model.GenreEntity;
import br.com.tvalerio.exercice.repository.GenreRepository;

@Component
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<GenreEntity> getAllGenres() {
        return genreRepository.findAll();
    }
}
