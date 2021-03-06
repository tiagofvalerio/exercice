package br.com.tvalerio.exercise.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.tvalerio.exercise.model.SaleEntity;

public interface SaleRepository
        extends PagingAndSortingRepository<SaleEntity, Long> {

    Page<SaleEntity> findByCreatedAtBetween(LocalDateTime startDate,
            LocalDateTime endDate, Pageable pageable);
}
