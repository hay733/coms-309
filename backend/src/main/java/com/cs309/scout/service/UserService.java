package com.cs309.scout.service;

import java.util.List;
import com.cs309.scout.entity.Location;
import com.cs309.scout.entity.ScheduledEvent;
import com.cs309.scout.entity.User;
import com.cs309.scout.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public List<User> findAll() { return repo.findAll(); }

    public User findById(int id) {
        return repo.findById(id);
    }

    public User deleteById(int id) {
        return repo.deleteById(id);
    }

    public User findByEmail(String email) { return repo.findByEmail(email); }

    /*public List<Location> locationsVisited(int userID) { return repo.locationsVisited(userID); }*/
}
