package com.cs309.scout.controller;

import com.cs309.scout.entity.ScheduledEvent;
import com.cs309.scout.repository.ScheduledEventRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * The ScheduledEvent Controller class for ScheduledEvent Entity
 */
@Api(value = "ScheduledEventController", description = "REST APIs related to the ScheduledEvent Entity")
@RestController
public class ScheduledEventController {

    @Autowired
    ScheduledEventRepository scheduledEventRepository;

    /**
     * Returns only one ScheduledEvent based on ScheduledEvent ID
     * @param id The ID of the ScheduledEvent wanted
     * @return ScheduledEvent Object with ID id
     */
    @ApiOperation(value = "Gets a ScheduledEvent Object", response = ScheduledEvent.class)
    @GetMapping("/schedule/{id}")
    ScheduledEvent GetOneScheduled(@PathVariable("id") int id){ return scheduledEventRepository.findById(id); }


    /**
     * Returns all ScheduledEvent Objects in a list
     * @return All ScheduledEvent Objects
     */
    @ApiOperation(value = "Get List of ScheduledEvent", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping("/schedule/all")
    List<ScheduledEvent> GetAllScheduled(){ return scheduledEventRepository.findAll(); }


    /**
     * Creates a new ScheduledEvent Object in the system
     * @param scheduledEvent The details of new ScheduledEvent
     * @return A string that says if creation of ScheduledEvent Object was successful or not
     */
    @ApiOperation(value = "Creates a ScheduledEvent Object", response = ScheduledEvent.class)
    @PostMapping("/schedule/create")
    String createScheduledEvent(@RequestBody ScheduledEvent scheduledEvent){
        if (scheduledEvent == null)
            return "Failed to create Event.";

        scheduledEventRepository.save(scheduledEvent);
        return "Event created successfully.";
    }


    /**
     * Updates an individual ScheduledEvent Object based on its attributes
     * @param id Requested ScheduledEvent ID that user wants to update
     * @param request The new details of updated ScheduledEvent
     * @return Returns the newly updated ScheduledEvent Object
     */
    @ApiOperation(value = "Updates a ScheduledEvent Object", response = ScheduledEvent.class)
    @PutMapping("/schedule/update/{id}")
    ScheduledEvent updateScheduledEvent(@PathVariable int id, @RequestBody ScheduledEvent request){
        ScheduledEvent event = scheduledEventRepository.findById(id);
        if(event == null)
            return null;

        scheduledEventRepository.save(request);
        return scheduledEventRepository.findById(id);
    }


    /**
     * Deletes a specific ScheduledEvent Object from the system
     * @param id ScheduledEvent ID of ScheduledEvent Object wanting to delete
     * @return A string that says whether or not deletion of ScheduledEvent is successful
     */
    @ApiOperation(value = "Deletes a ScheduledEvent Object", response = ScheduledEvent.class)
    @DeleteMapping("/schedule/delete/{id}")
    String deleteScheduledEvent(@PathVariable int id){
        scheduledEventRepository.deleteById(id);
        return "Deleted successfully.";
    }


    /**
     * Returns a list of ScheduledEvent that User with ID id has scheduled
     * @param userID The ID of specific User
     * @return A list of ScheduledEvent that User has scheduled
     */
    @ApiOperation(value = "Gets all ScheduledEvents a User has scheduled", response = Iterable.class)
    @GetMapping("/schedule/allEvents")
    List<ScheduledEvent> allEventsScheduled(@RequestParam int userID) {
        //User user = findByID(userID);
        //if (user == null)
        //    return null;

        return scheduledEventRepository.allEventsScheduled(userID);
    }

    /**
     * Returns the start_time of a ScheduledEvent given the id
     * @param id The ID of specific ScheduledEvent
     * @return A Date of start_time
     */
    @ApiOperation(value = "Returns the start_time of a ScheduledEvent given the id", response = Iterable.class)
    @GetMapping("/schedule/start_time")
    Date scheduledEventStart(@RequestParam int id) {
        return scheduledEventRepository.findById(id).getStart_time();
    }

    /**
     * Returns the end_time of a ScheduledEvent given the id
     * @param id The ID of specific ScheduledEvent
     * @return A Date of end_time
     */
    @ApiOperation(value = "Returns the end_time of a ScheduledEvent given the id", response = Iterable.class)
    @GetMapping("/schedule/end_time")
    Date scheduledEventEnd(@RequestParam int id) {
        return scheduledEventRepository.findById(id).getEnd_time();
    }

    /**
     * Returns whether a Scheduled Event is repeating or not
     * @param id The ID of specific ScheduledEvent
     * @return A Date of end_time
     */
    @ApiOperation(value = "Returns whether a Scheduled Event is repeating or not", response = Iterable.class)
    @GetMapping("/schedule/repeating")
    Boolean scheduledEventRepeating(@RequestParam int id) {
        return scheduledEventRepository.findById(id).isRepeating();
    }

//    /**
//     * Returns all of the scheduled events on a specific date
//     * @param id The ID of specific ScheduledEvent
//     * @return A Date of end_time
//     */
//    @ApiOperation(value = "Returns all the scheduled events on a specific date", response = Iterable.class)
//    @GetMapping("/schedule/all_events/{day}")
//    List<ScheduledEvent> scheduledEventAllEventsDay(@RequestParam int id, @PathVariable int day) {
//        return scheduledEventRepository.scheduledEventAllEventsDay(id, day);
//    }
}
