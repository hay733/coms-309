package com.cs309.scout.repository;

import com.cs309.scout.entity.Location;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    Location findById(int id);

    @Transactional
    Location deleteById(int id);

    @Query(value = "SELECT * FROM location l JOIN activity act ON l.id = act.lid " +
            "JOIN attend at ON act.id = at.activityID WHERE at.userID = :id", nativeQuery = true)
    List<Location> allLocationsVisited(@Param("id") int userID);

    @Query(value = "SELECT count(*) FROM location WHERE location.filter = :filter", nativeQuery = true)
    int countFilter(@Param("filter") String filter);

    @Query(value = "SELECT location.filter FROM location WHERE NOT location.filter = 'null'", nativeQuery = true)
    List<String> findAllFilters();
}

