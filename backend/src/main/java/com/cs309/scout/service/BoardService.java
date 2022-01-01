package com.cs309.scout.service;

import com.cs309.scout.entity.Board;
import com.cs309.scout.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    /** a repo object used for calling repository methods **/
    @Autowired
    BoardRepository repo;

    /** finds the board by id by calling the repository findById() method **/
    public Board findById(int id) {
        return repo.findById(id);
    }

    /** deletes the board by id by calling the repository deleteById() method **/
    public Board deleteById(int id) {
        return repo.deleteById(id);
    }
}
