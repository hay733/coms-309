package com.cs309.scout.repository;

import com.cs309.scout.entity.Location;
import com.cs309.scout.entity.ScheduledEvent;
import com.cs309.scout.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(int id);

    @Transactional
    User deleteById(int id);

    @Query(value = "SELECT * FROM user u WHERE u.email = :email", nativeQuery = true)
    User findByEmail(@Param("email") String email);
}

