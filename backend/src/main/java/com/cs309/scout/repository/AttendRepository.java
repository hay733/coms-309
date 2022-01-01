package com.cs309.scout.repository;

import com.cs309.scout.entity.Attend;
import com.cs309.scout.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AttendRepository extends JpaRepository<Attend, Long> {
    /** gets the attend object based off of its id **/
    Attend findById(int id);

    /** deletes the attend object based off of its id **/
    @Transactional
    Attend deleteById(int id);

    @Query(value = "SELECT * FROM attend WHERE favorite = 1 AND userID = :uid", nativeQuery = true)
    List<Attend> allFavorites(@Param("uid") int userID);
}

