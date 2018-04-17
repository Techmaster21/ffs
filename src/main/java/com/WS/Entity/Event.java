package com.WS.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * This entity is not yet finished so no javadoc comments will be provided
 *
 * @author Samuel
 */
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int id;

    @Column(name = "starttime", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "endtime", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @OneToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @OneToOne
    @JoinColumn(name = "ffser_id")
    private User user;

    public Event() {

    }

    public Event(Date startTime, Date endTime, Recipe recipe, User user) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.recipe = recipe;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id != other.id)
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}



}
