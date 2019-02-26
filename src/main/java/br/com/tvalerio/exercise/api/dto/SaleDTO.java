package br.com.tvalerio.exercise.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SaleDTO {

    private Long id;

    private LocalDateTime createdAt;

    private AlbumDTO album;

    private Integer albumQuantity;

    private BigDecimal saleAmount;

    private BigDecimal cashBackAmount;

    private BigDecimal tatalCashBackAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public AlbumDTO getAlbum() {
        return album;
    }

    public void setAlbum(AlbumDTO album) {
        this.album = album;
    }

    public Integer getAlbumQuantity() {
        return albumQuantity;
    }

    public void setAlbumQuantity(Integer albumQuantity) {
        this.albumQuantity = albumQuantity;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public BigDecimal getCashBackAmount() {
        return cashBackAmount;
    }

    public void setCashBackAmount(BigDecimal cashBackAmount) {
        this.cashBackAmount = cashBackAmount;
    }

    public BigDecimal getTatalCashBackAmount() {
        return tatalCashBackAmount;
    }

    public void setTatalCashBackAmount(BigDecimal tatalCashBackAmount) {
        this.tatalCashBackAmount = tatalCashBackAmount;
    }
}
