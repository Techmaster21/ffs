/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import javax.persistence.*;

@Entity
@Table(name = "food_des")
public class Food {

    @Id
    @Column(name = "NDB_No")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Long_Desc")
    private String name;

    public Food() {
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 97 * hash + this.id;
//        hash = 97 * hash + Objects.hashCode(this.name);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Food other = (Food) obj;
//        if (this.id != other.id) {
//            return false;
//        }
//        return true;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
