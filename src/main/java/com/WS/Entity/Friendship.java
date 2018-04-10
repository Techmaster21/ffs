package com.WS.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

@Entity
@Table(name = "friendships")
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friendship_id")
    private int id;
    
    @OneToOne
    @JoinColumn(name = "friend1")
    private User user;
	
    @OneToOne
    @JoinColumn(name = "friend2")
    private User friend;
    
    @Column(name = "flagrequest")
    private boolean request;
    
    public Friendship(){
    	
    }
    
    public Friendship(User user, User friend, boolean request){
    	this.user = user;
    	this.friend = friend;
    	this.request = request;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getFriend() {
		return friend;
	}

	public void setFriend(User friend) {
		this.friend = friend;
	}

	public boolean isRequest() {
		return request;
	}

	public void setRequest(boolean request) {
		this.request = request;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Friendship other = (Friendship) obj;
		if (friend == null) {
			if (other.friend != null)
				return false;
		} else if (!friend.equals(other.friend))
			return false;
		if (id != other.id)
			return false;
		if (request != other.request)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Friendship{" +
                "id=" + id +
                ", user=" + user +
                ", friend=" + friend +
                ", request=" + request +
                '}';
    }
}
