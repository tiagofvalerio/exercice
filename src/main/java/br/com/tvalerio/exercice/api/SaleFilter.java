package br.com.tvalerio.exercice.api;

import java.time.LocalDateTime;

public class SaleFilter {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String order;

    private Integer page;

    private Integer size;

    private String direction;

    public SaleFilter(Builder builder) {
        this.setStartDate(builder.startDate);
        this.setEndDate(builder.endDate);
        this.setOrder(builder.order);
        this.setDirection(builder.direction);
        this.setPage(builder.page);
        this.setSize(builder.size);
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private String order;
        private Integer page;
        private Integer size;
        private String direction;

        private Builder() {
        }

        public Builder withStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder withOrder(String order) {
            this.order = order;
            return this;
        }

        public Builder withPage(Integer page) {
            this.page = page;
            return this;
        }

        public Builder withSize(Integer size) {
            this.size = size;
            return this;
        }

        public Builder withDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public SaleFilter build() {
            return new SaleFilter(this);
        }
    }
}
