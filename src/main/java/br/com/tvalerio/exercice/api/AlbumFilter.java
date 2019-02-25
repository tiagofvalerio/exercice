package br.com.tvalerio.exercice.api;

public class AlbumFilter {

    private String genre;

    private String order;

    private Integer page;

    private Integer size;

    private String direction;

    public AlbumFilter(Builder builder) {
        this.setGenre(builder.genre);
        this.setOrder(builder.order);
        this.setDirection(builder.direction);
        this.setPage(builder.page);
        this.setSize(builder.size);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
        private String genre;
        private String order;
        private Integer page;
        private Integer size;
        private String direction;

        private Builder() {
        }

        public Builder withGenre(String genre) {
            this.genre = genre;
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

        public AlbumFilter build() {
            return new AlbumFilter(this);
        }
    }

}
