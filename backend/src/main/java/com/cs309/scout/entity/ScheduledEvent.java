package com.cs309.scout.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Class for ScheduledEvent Entity
 */
@Entity
public class ScheduledEvent {

    /**
     * ID for ScheduledEvent
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Name of ScheduledEvent
     */
    private String event_name;

    /**
     * The time ScheduledEvent is supposed to start
     */
    private Date start_time;

    /**
     * The time ScheduledEvent is supposed to end
     */
    private Date end_time;

    /**
     * Whether or not ScheduledEvent is repeated
     */
    private boolean repeating;

    /*
     * @ManyToOne tells springboot that multiple instances of Phone can map to one instance of OR multiple rows of the phone table can map to one user row
     * @JoinColumn specifies the ownership of the key i.e. The Phone table will contain a foreign key from the User table and the column name will be user_id
     * @JsonIgnore is to assure that there is no infinite loop while returning either user/phone objects (phone->user->[phones]->...)
     */
    /**
     * The User that this ScheduledEvent is linked to
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    public ScheduledEvent(){}

    /**
     * Constructor for ScheduledEvent
     * @param event_name
     * @param start_time
     * @param end_time
     * @param repeating
     */
    public ScheduledEvent(String event_name, Date start_time, Date end_time, boolean repeating) {
        this.event_name = event_name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.repeating = repeating;
    }

    /**
     * Returns ID for current ScheduledEvent
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Changes ID for current ScheduledEvent
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns Name of current ScheduledEvent
     * @return event_name
     */
    public String getEvent_name() {
        return event_name;
    }

    /**
     * Changes Name of current ScheduledEvent
     * @param event_name
     */
    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    /**
     * Returns Date this ScheduledEvent is supposed to start
     * @return start_time
     */
    public Date getStart_time() {
        return start_time;
    }

    /**
     * Changes Date this ScheduledEvent is supposed to start
     * @param start_time
     */
    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    /**
     * Returns Date this ScheduledEvent is supposed to end
     * @return end_time
     */
    public Date getEnd_time() {
        return end_time;
    }

    /**
     * Changes Date this ScheduledEvent is supposed to end
     * @param end_time
     */
    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    /**
     * Returns whether current ScheduledEvent is repeating
     * @return repeating
     */
    public boolean isRepeating() {
        return repeating;
    }

    /**
     * Changes whether current ScheduledEvent is repeating
     * @param repeating
     */
    public void setRepeating(boolean repeating) {
        this.repeating = repeating;
    }

    /**
     * Returns User that this ScheduledEvent is linked to
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Changes User that this ScheduledEvent is linked to
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
