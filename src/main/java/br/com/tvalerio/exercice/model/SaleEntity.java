package br.com.tvalerio.exercice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sale")
public class SaleEntity extends BaseEntity {

    private static final long serialVersionUID = -1344168321963276274L;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "album_id", nullable = false)
    private AlbumEntity album;

    @Column(name = "album_quantity")
    private Integer albumQuantity;

    @Column(name = "sale_amount")
    private BigDecimal saleAmount;

    @Column(name = "cash_back_amount")
    private BigDecimal cashBackAmount;

    @Column(name = "total_cash_back_amount")
    private BigDecimal totalCashBackAmount;

    public AlbumEntity getAlbum() {
        return album;
    }

    public void setAlbum(AlbumEntity album) {
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

    public BigDecimal getTotalCashBackAmount() {
        return totalCashBackAmount;
    }

    public void setTotalCashBackAmount(BigDecimal totalCashBackAmount) {
        this.totalCashBackAmount = totalCashBackAmount;
    }

    @Override
    public String toString() {
        return "SaleEntity [album=" + album + ", albumQuantity=" + albumQuantity
                + ", saleAmount=" + saleAmount + ", cashBackAmount="
                + cashBackAmount + ", totalCashBackAmount="
                + totalCashBackAmount + "]";
    }
}
