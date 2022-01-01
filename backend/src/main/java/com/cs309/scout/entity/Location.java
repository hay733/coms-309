package com.cs309.scout.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * Class for Location Entity
 */
@Entity
public class Location {

    /**
     * ID for Location
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "ID for Location", name = "id", required = true, value = "id")
    private int id;

    /**
     * Description of Location
     */
    @ApiModelProperty(notes = "Description of Location", name = "description", required = true, value = "description")
    private String description;

    /**
     * Latitude for Location
     */
    @ApiModelProperty(notes = "Latitude for Location", name = "latitude", required = true, value = "latitude")
    private double latitude;

    /**
     * Longitude for Location
     */
    @ApiModelProperty(notes = "Longitude for Location", name = "longitude", required = true, value = "longitude")
    private double longitude;

    /**
     * ZIP Code of Location
     */
    @ApiModelProperty(notes = "ZIP Code of Location", name = "zip", required = true, value = "zip")
    private int zip;

    /**
     * Name of Location
     */
    @ApiModelProperty(notes = "Name of Location", name = "name", required = true, value = "name")
    private String name;

    /**
     * Address of Location
     */
    @ApiModelProperty(notes = "Address of Location", name = "address", required = true, value = "address")
    private String address;

    /**
     * Filter Type of Location
     */
    @ApiModelProperty(notes = "Location Filter name", name = "filter", required = true, value = "filter")
    private String filter;

    /*
     * @OneToOne creates a relation between the current entity/table(Laptop) with the entity/table defined below it(User)
     * @JsonIgnore is to assure that there is no infinite loop while returning either user/laptop objects (laptop->user->laptop->...)
     */
    /**
     * Activity Object at said Location
     */
    @OneToOne
    @JsonIgnore
    @ApiModelProperty(notes = "Activity at said Location", name = "activity", required = true, value = "activity")
    private Activity activity;


    public Location() {}

    /**
     * Constructor for creating a new Location Object
     * @param id
     * @param name
     * @param address
     * @param description
     * @param latitude
     * @param longitude
     * @param zip
     * @param filter
     */
    public Location(int id, String name, String address, String description, double latitude, double longitude, int zip, String filter) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zip = zip;
        this.filter = filter;
    }

    /**
     * Returns the ID for current Location
     * @return ID
     */
    public int getId() { return id; }

    /**
     * Changes the ID of current Location
     * @param id
     */
    public void setId(int id) { this.id = id; }

    /**
     * Returns Description of current Location
     * @return description
     */
    public String getDescription() { return description; }

    /**
     * Changes the Description of current Location
     * @param description
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Returns the Latitude for current Location
     * @return latitude
     */
    public double getLatitude() { return latitude; }

    /**
     * Changes Latitude for current Location
     * @param latitude
     */
    public void setLatitude(int latitude) { this.latitude = latitude; }

    /**
     * Returns Longitude for current Location
     * @return longitude
     */
    public double getLongitude() { return longitude; }

    /**
     * Changes Longitude for current Location
     * @param longitude
     */
    public void setLongitude(int longitude) { this.longitude = longitude; }

    /**
     * Returns ZIP code for current Location
     * @return zip
     */
    public int getZip() { return zip; }

    /**
     * Changes ZIP code for current Location
     * @param zip
     */
    public void setZip(int zip) { this.zip = zip; }

    /**
     * Returns Name of current Location
     * @return name
     */
    public String getName() { return name; }

    /**
     * Changes Name of current Location
     * @param name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Returns Address of current Location
     * @return address
     */
    public String getAddress() { return address; }

    /**
     * Changes Address for current Location
     * @param address
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * Returns Filter name for current Location
     * @return filter
     */
    public String getFilter() { return filter; }

    /**
     * Changes Filter name for current Location
     * @param filter
     */
    public void setFilter(String filter) { this.filter = filter; }

    /**
     * Returns Activity Object linked to current Location
     * @return activity
     */
    public Activity getActivity() { return activity; }

    /**
     * Changes Activity Object linked to current Location
     * @param activity
     */
    public void setActivity(Activity activity) { this.activity = activity; }
}
