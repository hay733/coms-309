package com.cs309.scout.service;

import com.cs309.scout.controller.ActivityController;
import com.cs309.scout.entity.Activity;
import com.cs309.scout.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    /** a repo object used for calling repository methods **/
    @Autowired
    ActivityRepository repo;

    /** finds the activity by id by calling the repository findById() method **/
    public Activity findById(int id) { return repo.findById(id); }

    /** deletes the activity by id by calling the repository deleteById() method **/
    public Activity deleteById(int id) { return repo.deleteById(id); }

    /** returns all Activities attended by calling the repository allActivitiesDone method **/
    public List<Activity> allActivitiesDone(int userID) { return repo.allActivitiesDone(userID); }

    /** returns all Activities attended by calling the repository allActivitiesDone method **/
    public List<Activity> findAll() { return repo.findAll(); }

    /** saves all activities by calling the repository save method **/
    public void save(Activity ne) { repo.save(ne); }

    /** returns all Activities in a board by calling the repository allBoardElements method **/
    public List<Activity> allBoardElements(int bid) { return repo.allBoardElements(bid); }
}
