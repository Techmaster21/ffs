package com.WS.Entity;

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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Friendship that = (Friendship) o;

		if (id != that.id) return false;
		if (request != that.request) return false;
		if (user != null ? !user.equals(that.user) : that.user != null) return false;
		return friend != null ? friend.equals(that.friend) : that.friend == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (user != null ? user.hashCode() : 0);
		result = 31 * result + (friend != null ? friend.hashCode() : 0);
		result = 31 * result + (request ? 1 : 0);
		return result;
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
