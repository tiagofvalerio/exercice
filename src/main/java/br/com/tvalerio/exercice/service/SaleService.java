package br.com.tvalerio.exercice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import br.com.tvalerio.exercice.api.SaleFilter;
import br.com.tvalerio.exercice.api.request.SalePostRequest;
import br.com.tvalerio.exercice.model.AlbumEntity;
import br.com.tvalerio.exercice.model.SaleEntity;
import br.com.tvalerio.exercice.model.SalePercentageEntity;
import br.com.tvalerio.exercice.repository.SalePercentageRepository;
import br.com.tvalerio.exercice.repository.SaleRepository;
import br.com.tvalerio.exercice.utils.Utils;

@Component
public class SaleService {
    
    @Autowired
    private Utils utils;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private SalePercentageRepository salePercentageRepository;

    public Optional<SaleEntity> findById(Long id) {
        return saleRepository.findById(id);
    }

    public Optional<SaleEntity> registerSale(SalePostRequest salePostRequest) {

        Optional<SaleEntity> saleEntity = Optional.empty();

        Optional<AlbumEntity> album = albumService
                .findById(salePostRequest.getId());

        System.out.println("Utils.getDayOfWeek()######" + utils.getDayOfWeek());

        if (album.isPresent()) {
            Optional<SalePercentageEntity> salePercentage = salePercentageRepository
                    .findByGenreNameAndDayOfWeek(
                            album.get().getGenre().getName(),
                            utils.getDayOfWeek());

            if (salePercentage.isPresent()) {
                saleEntity = Optional.of(new SaleEntity());
                saleEntity.get().setAlbum(album.get());
                saleEntity.get()
                        .setAlbumQuantity(salePostRequest.getQuantity());
                saleEntity.get()
                        .setSaleAmount(album.get().getPrice()
                                .multiply(BigDecimal
                                        .valueOf(salePostRequest.getQuantity())
                                        .setScale(2, RoundingMode.HALF_UP))
                                .setScale(2, BigDecimal.ROUND_UP));
                saleEntity.get()
                        .setCashBackAmount(calculateBashBack(
                                salePercentage.get().getPercentage(),
                                saleEntity.get().getAlbum().getPrice()));
                saleEntity.get()
                        .setTotalCashBackAmount(calculateBashBack(
                                salePercentage.get().getPercentage(),
                                saleEntity.get().getSaleAmount()));
                saleEntity = Optional.of(saleRepository.save(saleEntity.get()));
            }
        }

        return saleEntity;
    }

    public Page<SaleEntity> findSalesPaginated(SaleFilter filter) {
        return saleRepository.findByCreatedAtBetween(filter.getStartDate(),
                filter.getEndDate(),
                PageRequest.of(filter.getPage(), filter.getSize(),
                        Direction.valueOf(filter.getDirection()),
                        filter.getOrder()));
    }

    private BigDecimal calculateBashBack(BigDecimal percentage,
            BigDecimal amount) {
        return percentage.multiply(amount).setScale(2, BigDecimal.ROUND_UP);
    }

}
