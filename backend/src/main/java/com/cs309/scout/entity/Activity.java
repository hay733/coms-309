package com.cs309.scout.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /** the activity id **/
    @ApiModelProperty(notes = "Activity id",name="id",required=true,value="id")
    private int id;

    /** the activity name **/
    @ApiModelProperty(notes = "Activity name",name="name",required=true,value="name")
    private String name;

    /** the activity start time **/
    @ApiModelProperty(notes = "Activity start time",name="start_time",required=true,value="start_time")
    private Date start_time;

    /** the activity end time **/
    @ApiModelProperty(notes = "Activity end time",name="end_time",required=true,value="end_time")
    private Date end_time;

    /** the activity filter type **/
    @ApiModelProperty(notes = "The filter type the Activity falls under",name="filter",required=true,value="filter")
    private String filter;

    /*
     * @OneToOne creates a relation between the current entity/table(Laptop) with the entity/table defined below it(User)
     * cascade is responsible propagating all changes, even to children of the class Eg: changes made to laptop within a user object will be reflected
     * in the database (more info : https://www.baeldung.com/jpa-cascade-types)
     * @JoinColumn defines the ownership of the foreign key i.e. the user table will have a field called laptop_id
     */
    /** The location of the activity **/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lid") // THIS SHOULD MEAN THAT WE DONT NEED LID ANYMORE, GONNA COMMENT OUT
    private Location location;

    /** The board the Activity is in **/
    @ManyToOne
    @JoinColumn(name = "board_id")
    @JsonIgnore
    private Board board;

    /** The list of Attends used to keep track of all Users who attend an Activity **/
    @OneToMany
    private List<Attend> attends;

    /** Creates a new empty Activity **/
    public Activity() {
        attends = new ArrayList<>();
    }

    /** Creates a new Activity **/
    public Activity(String name, Date start_time, Date end_time, String filter) {

        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.filter = filter;
        attends = new ArrayList<>();
    }

    /** gets the id for Activity **/
    public int getId() {
        return id;
    }

    /** sets the id for Activity **/
    public void setId(int id) {
        this.id = id;
    }

    /** gets the name for Activity **/
    public String getName() {
        return name;
    }

    /** sets the name for Activity **/
    public void setName(String name) {
        this.name = name;
    }

    /** gets the start_time for Activity **/
    public Date getStart_time() {
        return start_time;
    }

    /** sets the start_time for Activity **/
    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    /** gets the end_time for Activity **/
    public Date getEnd_time() {
        return end_time;
    }

    /** sets the end_time for Activity **/
    public void setEnd_time(Date end_time) { this.end_time = end_time; }

    /** gets the filter for Activity **/
    public String getFilter() {
        return filter;
    }

    /** sets the filter for Activity **/
    public void setFilter(String filter) {
        this.filter = filter;
    }

    /** gets the Location for Activity **/
    public Location getLocation() {
        return location;
    }

    /** sets the Location for Activity **/
    public void setLocation(Location location) {
        this.location = location;
    }

    /** gets the Board for Activity **/
    public Board getBoard() {
        return board;
    }

    /** sets the Board for Activity **/
    public void setBoard(Board board) {
        this.board = board;
    }

    /** sets the list of Attends for Activity **/
    public List<Attend> getAttends() {
        return attends;
    }

    /** gets the list of Attends for Activity **/
    public void setAttends(List<Attend> attends) {
        this.attends = attends;
    }

    /** adds to the list of Attends for Activity **/
    public void addAttends(Attend attend){
        this.attends.add(attend);
    }

}
