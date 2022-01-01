package com.cs309.scout.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /** the board id **/
    @ApiModelProperty(notes = "Board object id",name="id",required=true,value="id")
    private int id;

    /** the board name **/
    @ApiModelProperty(notes = "Board name",name="name",required=true,value="name")
    private String name;

    /** the number of Activities stored in a board **/
    @ApiModelProperty(notes = "Number of Activities stored in a board",name="num_elements",required=true,value="num_elements")
    private int num_elements;

    /** A number to help keep track of where the board is on the page **/
    @ApiModelProperty(notes = "A number to help keep track of where the board is on the page",name="order_num",required=true,value="order_num")
    private int order_num;

    /*
     * @ManyToOne tells springboot that multiple instances of Phone can map to one instance of OR multiple rows of the phone table can map to one user row
     * @JoinColumn specifies the ownership of the key i.e. The Phone table will contain a foreign key from the User table and the column name will be user_id
     * @JsonIgnore is to assure that there is no infinite loop while returning either user/phone objects (phone->user->[phones]->...)
     */
    /** the User the board is assigned to **/
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    /** the List of activities in the board **/
    @OneToMany
    private List<Activity> activities;

    /** creates a new empty Board **/
    public Board() {
        activities = new ArrayList<>();
    }

    /** creates a new Board **/
    public Board(int id, String name, int num_elements, int order_num) {
        this.id = id;
        this.name = name;
        this.num_elements = num_elements;
        this.order_num = order_num;
        activities = new ArrayList<>();
    }

    /** gets the board id **/
    public int getId() {
        return id;
    }

    /** sets the board id **/
    public void setId(int id) {
        this.id = id;
    }

    /** gets the board name **/
    public String getName() {
        return name;
    }

    /** sets the board name **/
    public void setName(String name) {
        this.name = name;
    }

    /** gets the board num of activities **/
    public int getNum_elements() {
        return num_elements;
    }

    /** sets the board num of activities **/
    public void setNum_elements(int num_elements) {
        this.num_elements = num_elements;
    }

    /** gets the board order num **/
    public int getOrder_num() {
        return order_num;
    }

    /** sets the board order num **/
    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    /** gets the board's User **/
    public User getUser() {
        return user;
    }

    /** sets the board's User **/
    public void setUser(User user) {
        this.user = user;
    }

    /** gets the activities in the board **/
    public List<Activity> getActivities() {
        return activities;
    }

    /** sets the activities in the board **/
    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    /** adds activities to the board **/
    public void addActivities(Activity activity){
        this.activities.add(activity);
    }

}
