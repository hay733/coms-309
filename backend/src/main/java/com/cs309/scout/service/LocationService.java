package com.cs309.scout.service;

import java.util.List;

import com.cs309.scout.entity.Location;
import com.cs309.scout.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repo;

    public Location findById(int id) { return repo.findById(id); }

    public Location deleteById(int id) {
        return repo.deleteById(id);
    }

    public List<Location> allLocationsVisited(int userID) { return repo.allLocationsVisited(userID); }

    public int countFilter(String filter) { return repo.countFilter(filter); }

    /**
     * returns all filters
     * @return
     */
    public List<String> findAllFilters() { return repo.findAllFilters(); }
}
