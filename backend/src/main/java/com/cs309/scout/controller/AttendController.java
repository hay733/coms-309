package com.cs309.scout.controller;

import com.cs309.scout.entity.Activity;
import com.cs309.scout.entity.Attend;
import com.cs309.scout.entity.Location;
import com.cs309.scout.repository.AttendRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "AttendController", description = "APIs related to the relationship of User Attends Activities")
@RestController
public class AttendController {

    /** attend service for executing controller methods **/
    @Autowired
    AttendRepository attendRepository;

    /** Get specific Attend relationship object **/
    @ApiOperation(value = "Get specific Attend relationship object", response = Attend.class)
    @GetMapping("/attend/{id}")
    Attend GetOneAttend(@PathVariable("id") int id){
        return attendRepository.findById(id);
    }

    /** Get all Attend relationship objects **/
    @ApiOperation(value = "Get all Attend relationship objects", response = Attend.class)
    @GetMapping("/attend/all")
    List<Attend> GetAllAttends(){
        return attendRepository.findAll();
    }

    /** Create a new Attend relationship object **/
    @ApiOperation(value = "Create a new Attend relationship object", response = Attend.class)
    @PostMapping("/attend/create")
    String createAttend(@RequestBody Attend ne){
        if (ne == null)
            return "Failed to create Attend_Event Object.";

        attendRepository.save(ne);
        return "Attending event created successfully.";
    }

    /** Edit an Attend relationship object **/
    @ApiOperation(value = "Edit an Attend relationship object", response = Attend.class)
    @PutMapping("/attend/update/{id}")
    Attend updateAttend(@PathVariable int id, @RequestBody Attend request){
        Attend attend = attendRepository.findById(id);
        if(attend == null)
            return null;

        attendRepository.save(request);
        return attendRepository.findById(id);
    }

    /** Delete an Attend relationship object **/
    @ApiOperation(value = "Delete an Attend relationship object", response = Attend.class)
    @DeleteMapping("/attend/delete/{id}")
    String deleteAttend(@PathVariable int id){
        attendRepository.deleteById(id);
        return "Deleted successfully.";
    }

    /**
     * Returns a list of Attends that User with ID id has favorited
     * @param userID The ID of specific User
     * @return A list of Attends that User has favorited
     */
    @ApiOperation(value = "Gets all Attends that User has favorited", response = Iterable.class)
    @GetMapping("/attend/favorites")
    public List<Attend> allFavorites(@RequestParam int userID) {
        return attendRepository.allFavorites(userID);
    }
}
