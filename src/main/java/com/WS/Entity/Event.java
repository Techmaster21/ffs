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
    public int hashCode() {
        int result = id;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (recipe != null ? recipe.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (startTime != null ? !startTime.equals(event.startTime) : event.startTime != null) return false;
        if (endTime != null ? !endTime.equals(event.endTime) : event.endTime != null) return false;
        if (recipe != null ? !recipe.equals(event.recipe) : event.recipe != null) return false;
        return user != null ? user.equals(event.user) : event.user == null;
    }
}
