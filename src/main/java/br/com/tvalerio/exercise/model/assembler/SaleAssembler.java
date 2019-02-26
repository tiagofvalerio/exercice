package br.com.tvalerio.exercise.model.assembler;

import java.util.function.Function;

import org.springframework.data.domain.Page;

import br.com.tvalerio.exercise.api.dto.AlbumDTO;
import br.com.tvalerio.exercise.api.dto.SaleDTO;
import br.com.tvalerio.exercise.model.SaleEntity;

public class SaleAssembler {

    public SaleDTO fromSaleEntityToSaleDTO(SaleEntity saleEntity) {
        SaleDTO dto = new SaleDTO();

        dto.setId(saleEntity.getId());
        dto.setCreatedAt(saleEntity.getCreatedAt());
        dto.setAlbumQuantity(saleEntity.getAlbumQuantity());
        dto.setCashBackAmount(saleEntity.getCashBackAmount());
        dto.setTatalCashBackAmount(saleEntity.getTotalCashBackAmount());
        dto.setSaleAmount(saleEntity.getSaleAmount());
        dto.setAlbum(new AlbumDTO());
        dto.getAlbum().setId(saleEntity.getAlbum().getId());
        dto.getAlbum().setArtistName(saleEntity.getAlbum().getArtistName());
        dto.getAlbum().setGenre(saleEntity.getAlbum().getGenre().getName());
        dto.getAlbum().setName(saleEntity.getAlbum().getName());
        dto.getAlbum()
                .setNumberOfTracks(saleEntity.getAlbum().getNumberOfTracks());
        dto.getAlbum().setPrice(saleEntity.getAlbum().getPrice());

        return dto;
    }

    public Page<SaleDTO> fromSaleEntityPageToSaleDTOPage(
            Page<SaleEntity> saleEntityPage) {

        return saleEntityPage.map(new Function<SaleEntity, SaleDTO>() {
            @Override
            public SaleDTO apply(SaleEntity saleEntity) {
                return fromSaleEntityToSaleDTO(saleEntity);
            }
        });
    }

}
