package com.cs309.scout.controller;

import com.cs309.scout.entity.Location;
import com.cs309.scout.repository.LocationRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * The Location Controller class for Location Entity
 */
@Api(value = "LocationController", description = "REST APIs related to the Location Entity")
@RestController
public class LocationController {

    @Autowired
    LocationRepository locationRepository;

    /**
     * Returns only one Location based on Location ID
     * @param id The ID of the Location wanted
     * @return Location Object with ID id
     */
    @ApiOperation(value = "Gets a Location Object", response = Location.class)
    @GetMapping("/location/{id}")
    Location GetOneLocation(@PathVariable("id") int id){
        return locationRepository.findById(id);
    }


    /**
     * Returns all Location Objects in a list
     * @return All Location Objects
     */
    @ApiOperation(value = "Get List of Locations", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping("/location/all")
    List<Location> GetAllLocations(){
        return locationRepository.findAll();
    }


    /**
     * Creates a new Location Object in the system
     * @param loc The details of new Location
     * @return A string that says if creation of Location Object was successful or not
     */
    @ApiOperation(value = "Creates a Location Object", response = Location.class)
    @PostMapping("/location/create")
    String createLocation(@RequestBody Location loc){
        if (loc == null)
            return "Failed to create new Location.";

        locationRepository.save(loc);
        return "Location created successfully.";
    }


    /**
     * Updates an individual Location Object based on its attributes
     * @param id Requested Location ID that user wants to update
     * @param request The new details of updated Location
     * @return Returns the newly updated Location Object
     */
    @ApiOperation(value = "Updates a Location Object", response = Location.class)
    @PutMapping("/location/update/{id}")
    Location updateLocation(@PathVariable int id, @RequestBody Location request){
        Location loc = locationRepository.findById(id);
        if(loc == null)
            return null;

        locationRepository.save(request);
        return locationRepository.findById(id);
    }


    /**
     * Deletes a specific Location Object from the system
     * @param id Location ID of Location Object wanting to delete
     * @return A string that says whether or not deletion of Location is successful
     */
    @ApiOperation(value = "Deletes a Location Object", response = Location.class)
    @DeleteMapping("/location/delete/{id}")
    String deleteLocation(@PathVariable int id){
        locationRepository.deleteById(id);
        return "Deleted successfully.";
    }


    /**
     * Returns a list of Locations that User with ID id has visited
     * @param userID The ID of specific User
     * @return A list of Locations that User has visited
     */
    @ApiOperation(value = "Gets all Locations a User has Visited", response = Iterable.class)
    @GetMapping("/location/visited")
    public List<Location> allLocationsVisited(@RequestParam int userID) {
        /*User user = GetOneUser(userID);
        if (user == null)
            return null;*/

        return locationRepository.allLocationsVisited(userID);
    }


    /**
     * Returns count of Locations for type Filter
     * @param filter The filter name
     * @return Count of Locations for type Filter
     */
    @ApiOperation(value = "Gets count for Location Filter Type", response = Location.class)
    @GetMapping("/location/count_filter")
    public int countFilter(@RequestParam String filter) {
        return locationRepository.countFilter(filter);
    }

    /**
     * returns n filters
     * @param n
     * @return
     */
    @GetMapping("/location/all_filters")
    public List<String> findAllFilters(@RequestParam int n) {
        List <String> list = locationRepository.findAllFilters();

        return list.subList(0, n);
    }
}
