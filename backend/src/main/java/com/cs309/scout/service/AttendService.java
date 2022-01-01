package com.cs309.scout.service;

import com.cs309.scout.entity.Attend;
import com.cs309.scout.entity.Location;
import com.cs309.scout.repository.AttendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendService {
    /** a repo object used for calling repository methods **/
    @Autowired
    AttendRepository repo;

    /** finds the attend by id by calling the repository findById() method **/
    public Attend findById(int id) {
        return repo.findById(id);
    }

    /** deletes the attend by id by calling the repository deleteById() method **/
    public Attend deleteById(int id) {
        return repo.deleteById(id);
    }

    /**
     * returns a List of all Attend events that have been favorited by a User
     * @param userID
     * @return
     */
    public List<Attend> allFavorites(int userID) { return repo.allFavorites(userID); }
}