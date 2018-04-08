/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Class representing an Authority object in the database with proper links to it.
 * @author YT_6
 *
 */
@Entity
@Table(name = "authorities")
public class Authority {

	/**
	 * Database id for Authority object.
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "authority_id")
    private int id;

    // not sure what this is for
    /**
     * Name of Username
     */
    @Column(name = "username")
    private String username;

    /**
     * Name of Authority
     */
    @Column(name = "name")
    private String authority;


    // not sure what this does exactly - might be key to more than one authority per user
    /**
     * Name of Usernames
     */
    @OneToMany(mappedBy = "authority")
    @JsonIgnore
    private Set<User> users;

    /**
     * Representation of an Authority object. 
     */
    public Authority() {
    }

    /**
     * Representation of an Authority object in database with given name and username. 
     * @param username String used to make Authority's username. 
     * @param authority String used to name Authority. 
     */
    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }
    
    /**
     * Gets the single username of this Authority
     * @return String name of Authority's Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets a single username for this Authority
     * @param username Username for the Authority
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the nmae for this Authority.
     * @return this Authority's String name.
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * Sets the name of the Authority
     * @param authority String name for the Authority
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * Gets the set of Users for the current Authority. 
     * @return Set of Users of current Authority
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Sets the Users for the Authority object
     * @param users Set of Users to be under this Authority
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    /**
     * Gets the id for this Authority.
     * @return this Authority's id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id for this Authority object.
     * @param id int to be used for this Authority's id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns a string representation of this Authority object.
     * @return String representation of this Authority object. 
     */
    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", authority='" + authority + '\'' +
                ", users=" + users +
                '}';
    }

}
