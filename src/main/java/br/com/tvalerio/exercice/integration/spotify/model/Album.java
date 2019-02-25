package br.com.tvalerio.exercice.integration.spotify.model;

import java.util.List;

public class Album {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Album [items=" + items + "]";
    }
}
