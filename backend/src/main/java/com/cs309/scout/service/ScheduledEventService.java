package com.cs309.scout.service;

import java.util.List;

import com.cs309.scout.entity.ScheduledEvent;
import com.cs309.scout.repository.ScheduledEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduledEventService {

    @Autowired
    private ScheduledEventRepository repo;

    public ScheduledEvent findById(int id) {
        return repo.findById(id);
    }

    public ScheduledEvent deleteById(int id) {
        return repo.deleteById(id);
    }

    public List<ScheduledEvent> allEventsScheduled(int userID) { return repo.allEventsScheduled(userID); }
}
