package br.com.tvalerio.exercise.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tvalerio.exercise.model.SalePercentageEntity;

public interface SalePercentageRepository
        extends JpaRepository<SalePercentageEntity, Long> {

    Optional<SalePercentageEntity> findByGenreNameAndDayOfWeek(String genre,
            String dayOfWeek);
}
