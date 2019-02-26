package br.com.tvalerio.exercise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class GenreEntity extends BaseEntity {

    private static final long serialVersionUID = -8089719881855597603L;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GenreEntity [name=" + name + "]";
    }
}
