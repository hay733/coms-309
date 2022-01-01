package com.cs309.scout.controller;

import com.cs309.scout.entity.Activity;
import com.cs309.scout.entity.Location;
import com.cs309.scout.repository.ActivityRepository;
import com.cs309.scout.repository.LocationRepository;
import com.cs309.scout.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "ActivityController", description = "APIs related to Activities the user can view")
@RestController
public class ActivityController {
    private String success = "{\"message\":\"success\"}";
    private String failure = "{\"message\":\"failure\"}";

    /** activity service for executing controller methods **/
    @Autowired
    ActivityService activityService;

    /** activity repository for executing controller methods **/
    @Autowired
    ActivityRepository activityRepository;

    /** location service for executing controller methods using location and activity **/
    @Autowired
    LocationRepository locationRepository;

    /** Get specific Activity from the db **/
    @ApiOperation(value = "Get specific Activity from the db", response = Activity.class)
    @GetMapping("/activity/{id}")
    Activity GetOneActivity(@PathVariable("id") int id){
        return activityService.findById(id);
    }

    /** Get all Activities from the db **/
    @ApiOperation(value = "Get all Activities from the db", response = Activity.class)
    @GetMapping("/activity/all")
    List<Activity> GetAllActivities(){
        return activityService.findAll();
    }

    /** Create a new Activity **/
    @ApiOperation(value = "Create a new Activity", response = Activity.class)
    @PostMapping("/activity/create")
    String createActivity(@RequestBody Activity ne){
        if (ne == null)
            return "Failed to create Activity.";

        activityService.save(ne);
        return "Activity created successfully.";
    }

    /** Update an Activity **/
    @ApiOperation(value = "Update an Activity", response = Activity.class)
    @PutMapping("/activity/update/{id}")
    Activity updateActivity(@PathVariable int id, @RequestBody Activity request){
        Activity event = activityService.findById(id);
        if(event == null)
            return null;

        activityService.save(request);
        return activityService.findById(id);
    }

    /** Map an Activity to a Location **/
    @ApiOperation(value = "Map an Activity to a Location", response = Activity.class)
    @PutMapping("/activity/{id}/location/{lid}")
    String assignLocationToActivity(@PathVariable int id,@PathVariable int lid){
        Activity activity = activityRepository.findById(id);
        Location location = locationRepository.findById(lid);
        if(activity == null || location == null)
            return failure;
        location.setActivity(activity);
        activity.setLocation(location);
        activityRepository.save(activity);
        return success;
    }

    /** Delete an Activity **/
    @ApiOperation(value = "Delete an Activity", response = Activity.class)
    @DeleteMapping("/activity/delete/{id}")
    String deleteActivity(@PathVariable int id){
        activityService.deleteById(id);
        return "Deleted successfully.";
    }

    /** Get all Activities that a User has done **/
    @ApiOperation(value = "Get all Activities that a User has done", response = Activity.class)
    //returns all activities that the user has done so far
    @GetMapping("/activity/done")
    List<Activity> allActivitiesDone(@RequestParam int userID) {
        /*User user = GetOneUser(userID);
        if (user == null)
            return null;*/

        return activityService.allActivitiesDone(userID);
    }

    /** Get all Activities in a specific Board **/
    @ApiOperation(value = "Get all Activities in a specific Board", response = Activity.class)
    @GetMapping("/activity/all_board_elements")
    public List<Activity> allBoardElements(@RequestParam int bid) {
        return activityRepository.allBoardElements(bid);
    }

}
