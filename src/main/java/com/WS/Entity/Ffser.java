/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Eric
 */
@Entity
@Table(name = "ffsers")
public class Ffser {
    
    @Id
    @Column(name = "ffser_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ffser;
    
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    

    public int getFfser() {
        return ffser;
    }

    public void setFfser(int ffser) {
        this.ffser = ffser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.ffser;
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
        final Ffser other = (Ffser) obj;
        if (this.ffser != other.ffser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ffser{" + "ffser=" + ffser + ", username=" + username + '}';
    }
    
}
