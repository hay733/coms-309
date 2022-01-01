package com.cs309.scout.repository;

import com.cs309.scout.entity.Activity;
import com.cs309.scout.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    /** gets the board based off of its id **/
    Board findById(int id);

    /** deletes the board based off of its id **/
    @Transactional
    Board deleteById(int id);
}
