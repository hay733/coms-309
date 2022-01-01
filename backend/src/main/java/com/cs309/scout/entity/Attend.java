package com.cs309.scout.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Attend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /** the attend id **/
    @ApiModelProperty(notes = "Attend object id",name="id",required=true,value="id")
    private int id;

    /** the activity attended favorite status **/
    @ApiModelProperty(notes = "Whether or not the user is interested or saved this certain activity",name="favorite",required=true,value="favorite")
    private int favorite;

    /** the Activity attended **/
    @ManyToOne
    @JoinColumn(name = "activity_id")
    @JsonIgnore
    private Activity activity;

    /** the User attending **/
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    /** creates an empty Attend **/
    public Attend() {}

    /** creates an Attend **/
    public Attend(int favorite) {
        this.favorite = favorite;
    }

    /** gets the attend id **/
    public int getId() {
        return id;
    }

    /** sets the attend id **/
    public void setId(int id) {
        this.id = id;
    }

    /** gets whether the attend activity is favorited **/
    public int getFavorite() { return favorite; }

    /** sets whether the attend activity is favorited **/
    public void setFavorite(int favorite) { this.favorite = favorite; }

    /** gets the attended Activity **/
    public Activity getActivity() {
        return activity;
    }

    /** sets the attended Activity **/
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /** gets the attending User **/
    public User getUser() {
        return user;
    }

    /** sets the attending User **/
    public void setUser(User user) {
        this.user = user;
    }
}
