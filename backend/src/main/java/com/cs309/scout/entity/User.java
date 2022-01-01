package com.cs309.scout.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for User Entity
 */
@Entity
public class User {

    /**
     * ID for User
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "ID for User", name = "id", required = true, value = "id")
    private int id;

    /**
     * Username of User
     */
    @ApiModelProperty(notes = "Username of User", name = "username", required = true, value = "username")
    private String username;

    /**
     * First Name of User
     */
    @ApiModelProperty(notes = "First Name of User", name = "first_name", required = true, value = "first_name")
    private String first_name;

    /**
     * Laste Name of User
     */
    @ApiModelProperty(notes = "Last Name of User", name = "last_name", required = true, value = "last_name")
    private String last_name;

    /**
     * Password of User
     */
    @ApiModelProperty(notes = "Password of User", name = "password", required = true, value = "password")
    private String password;

    /**
     * Email of User
     */
    @ApiModelProperty(notes = "Email of User", name = "email", required = true, value = "email")
    private String email;

    /**
     * Age of User
     */
    @ApiModelProperty(notes = "Age of User", name = "age", required = true, value = "age")
    private int age;

    /**
     * ZIP Code of User
     */
    @ApiModelProperty(notes = "ZIP Code of User", name = "zip", required = true, value = "zip")
    private int zip;

    /**
     * City of User
     */
    @ApiModelProperty(notes = "City of User", name = "city", required = true, value = "city")
    private String city;

    /**
     * State of User
     */
    @ApiModelProperty(notes = "State of User", name = "state", required = true, value = "state")
    private String state;

    /*
     * @OneToMany tells springboot that one instance of User can map to multiple instances of Phone OR one user row can map to multiple rows of the phone table
     */
    /**
     * User's Scheduled Events
     */
    @ApiModelProperty(notes = "User's Scheduled Events", name = "scheduledEvents", required = true, value = "scheduledEvents")
    @OneToMany
    private List<ScheduledEvent> scheduledEvents;

    /**
     * User's Boards
     */
    @ApiModelProperty(notes = "User's Boards", name = "boards", required = true, value = "boards")
    @OneToMany
    private List<Board> boards;

    /**
     * User's Attending Events
     */
    @ApiModelProperty(notes = "User's Attending Events", name = "attends", required = true, value = "attends")
    @OneToMany
    private List<Attend> attends;


    public User() {
        scheduledEvents = new ArrayList<>();
        boards = new ArrayList<>();
        attends = new ArrayList<>();
    }

    /**
     * Constructor for User
     * @param username
     * @param first_name
     * @param last_name
     * @param password
     * @param email
     * @param age
     * @param zip
     * @param city
     * @param state
     */
    public User(String username, String first_name, String last_name, String password, String email, int age, int zip, String city, String state) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.zip = zip;
        this.city = city;
        this.state = state;
        scheduledEvents = new ArrayList<>();
        boards = new ArrayList<>();
        attends = new ArrayList<>();
    }

    /**
     * Returns ID of User
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Changes ID of User
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns Username of User
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Changes Username of User
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns First Name of User
     * @return first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Changes First Name of User
     * @param first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Returns Last Name of User
     * @return last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Changes Last Name of User
     * @param last_name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Returns Password of User
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Changes Password of User
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns Email of User
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Changes Email of User
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns Age of User
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Changes Age of User
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns ZIP Code of User
     * @return zip
     */
    public int getZip() {
        return zip;
    }

    /**
     * Changes ZIP Code of User
     * @param zip
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * Returns City of User
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Changes City of User
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns State of User
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Changes State of User
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns User's Scheduled Events
     * @return scheduledEvents
     */
    public List<ScheduledEvent> getScheduledEvents() {
        return scheduledEvents;
    }

    /**
     * Changes User's Scheduled Events
     * @param scheduledEvents
     */
    public void setScheduledEvents(List<ScheduledEvent> scheduledEvents) {
        this.scheduledEvents = scheduledEvents;
    }

    /**
     * Adds new Scheduled Event Object to User's Events
     * @param scheduledEvent
     */
    public void addScheduledEvents(ScheduledEvent scheduledEvent){
        this.scheduledEvents.add(scheduledEvent);
    }

    /**
     * Returns User's Boards
     * @return boards
     */
    public List<Board> getBoards() {
        return boards;
    }

    /**
     * Changes User's Boards
     * @param boards
     */
    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    /**
     * Adds a new Board Object to User's Boards
     * @param board
     */
    public void addBoards(Board board){
        this.boards.add(board);
    }

    /**
     * Returns User's Attends
     * @return attends
     */
    public List<Attend> getAttends() {
        return attends;
    }

    /**
     * Changes User's attends
     * @param attends
     */
    public void setAttends(List<Attend> attends) {
        this.attends = attends;
    }

    /**
     * Adds a new Attend Object to User's Attends
     * @param attend
     */
    public void addAttends(Attend attend){
        this.attends.add(attend);
    }
}
