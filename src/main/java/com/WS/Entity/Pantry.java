/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pantry")
public class Pantry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pantry_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "ffser_id")
    private Ffser ffser;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pantry")
    @JsonManagedReference
    private List<PantryItem> items = new ArrayList<>();

    public Pantry(int id, Ffser ffser) {
        this.id = id;
        this.ffser = ffser;
    }

    public Pantry() {
    }

    public Pantry(Ffser ffser, List<PantryItem> items) {
        this.ffser = ffser;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ffser getFfser() {
        return ffser;
    }

    public void setFfser(Ffser ffser) {
        this.ffser = ffser;
    }

    public List<PantryItem> getItems() {
        return items;
    }

    public void setItems(List<PantryItem> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pantry other = (Pantry) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.ffser, other.ffser)) {
            return false;
        }
        if (!Objects.equals(this.items, other.items)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Pantry{" +
                "id=" + id +
                ", ffser=" + ffser +
                ", items=" + items +
                '}';
    }
}
