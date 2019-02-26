package br.com.tvalerio.exercise.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sale_percentage")
public class SalePercentageEntity extends BaseEntity {

    private static final long serialVersionUID = -4409700263826728043L;

    @Column(name = "percentage")
    private BigDecimal percentage;

    @Column(name = "day_of_week")
    private String dayOfWeek;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "genre_uuid", nullable = false)
    private GenreEntity genre;

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "SalePercentageEntity [percentage=" + percentage + ", dayOfWeek="
                + dayOfWeek + ", genre=" + genre + "]";
    }
}
