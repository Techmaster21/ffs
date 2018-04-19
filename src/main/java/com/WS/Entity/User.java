/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Class representing a User object in the database with proper links to it.
 * @author YT_6
 *
 */
@Entity
@Table(name = "ffsers")
public class User implements UserDetails {
	
	/**
	 * Id of this User object
	 */
	@Id
    @Column(name = "ffser_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Username of this User
     */
    @Column(name = "username")
    private String username;

    /**
     * Password of this User object
     */
    @Column(name = "password")
    private String password;

    // not sure what this does exactly - might be key to more than one authority per user
    /**
     * Authority under this User object
     */
    @ManyToOne
    @JoinColumn(name = "authority_id", nullable = false)
    private Authority authority;

    // needed because hibernate infers authorities instance variable from getAuthorities method, and we need to not
    // send that to the user or put it in the database.
    /**
     * Set of Authorities under this User object
     */
    @Transient
    @JsonIgnore
    private Set<Authority> authorities;

    /**
     * Representation of a User object in database.
     */
    public User() {
    }

    /**
     * Representation of a User object in database given a username, password, and authority.
     * @param username Username of the User object
     * @param password Password of the User object
     * @param authority Authority of the User object
     */
    public User(String username, String password, Authority authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    /**
     * Gets the id of this User.
     * @return Id of this User
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id for this User object.
     * @param id Id for this User.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the authority of this User.
     * @return Authority of this User
     */
    public Authority getAuthority() {
        return authority;
    }

    /**
     * Sets the Authority for this User object.
     * @param authority Authority for this User.
     */
    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    /**
     * Gets the username of this User.
     * @return Username of this User
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for this User object.
     * @param username Username for this User.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of this User.
     * @return Password of this User
     */
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for this User object.
     * @param password Password for this User.
     */
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a collection of the Authorities that exist under this User.
     * @return Authorities of this User
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(() -> authority.getAuthority());
    }

    /**
     * Returns whether this User object credentials are not expired or not.
     * @return True if User account's credentials are not expired, false if they are.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Returns whether this User object is not expired or not.
     * @return True if User account is not expired, false if it is.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Returns whether this User object is not locked or not.
     * @return True if User account is not locked, false if it is.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    /**
     * Returns whether this User object is enabled or not.
     * @return True if User account is enabled, false if not.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Returns a string representation of this User object.
     * @return String representation of this User object. 
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authority=" + authority.getAuthority() +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this User object.
     * @param o object being tested for equality with this User.
     * @return return true if obj and this User are equivalent.  False if not. 
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        return authority != null ? !authority.equals(user.authority) : user.authority != null;
    }

    /**
     * Returns a hash code value for this User object.
     * @return integer that is the hash code for this User object
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        result = 31 * result + (authorities != null ? authorities.hashCode() : 0);
        return result;
    }
}
