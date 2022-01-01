package com.cs309.scout.repository;

import com.cs309.scout.entity.ScheduledEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ScheduledEventRepository extends JpaRepository<ScheduledEvent, Long> {

    ScheduledEvent findById(int id);

    @Transactional
    ScheduledEvent deleteById(int id);

    @Query(value = "SELECT * FROM scheduled_event se WHERE se.uid = :id", nativeQuery = true)
    List<ScheduledEvent> allEventsScheduled(@Param("id") int userID);
}

