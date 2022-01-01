package com.cs309.scout.repository;

import com.cs309.scout.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    /** gets the activity based off of its id **/
    Activity findById(int id);

    /** deletes the activity based off of its id **/
    @Transactional
    Activity deleteById(int id);

    /** returns all activities that the user has attended **/
    @Query(value = "SELECT * FROM activity act JOIN attend at ON act.id = at.activityID WHERE at.userID = :userID", nativeQuery = true)
    List<Activity> allActivitiesDone(@Param("userID") int userID);

    /** returns all the activities in a specific board **/
    @Query(value = "SELECT * FROM board b, activity act WHERE act.bid = :bid AND b.id = act.bid", nativeQuery = true)
    List<Activity> allBoardElements(@Param("bid") int bid);

}

