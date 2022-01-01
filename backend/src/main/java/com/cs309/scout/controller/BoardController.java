package com.cs309.scout.controller;

import com.cs309.scout.entity.Attend;
import com.cs309.scout.entity.Board;
import com.cs309.scout.entity.Location;
import com.cs309.scout.repository.BoardRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "BoardController", description = "APIs related to Boards that organize Activities")
@RestController
public class BoardController {

    /** board service for executing controller methods **/
    @Autowired
    BoardRepository boardRepository;

    /** Get specific Board **/
    @ApiOperation(value = "Get specific Board", response = Board.class)
    @GetMapping("/board/{id}")
    Board GetOneBoard(@PathVariable("id") int id){
        return boardRepository.findById(id);
    }

    /** Get all Boards **/
    @ApiOperation(value = "Get all Boards", response = Board.class)
    @GetMapping("/board/all")
    List<Board> GetAllBoards(){
        return boardRepository.findAll();
    }

    /** Create a new Board **/
    @ApiOperation(value = "Create a new Board", response = Board.class)
    @PostMapping("/board/create")
    String createBoard(@RequestBody Board loc){
        if (loc == null)
            return "Failed to create new Board.";

        boardRepository.save(loc);
        return "Board created successfully.";
    }

    /** Update a Board **/
    @ApiOperation(value = "Update a Board", response = Board.class)
    @PutMapping("/board/update/{id}")
    Board updateBoard(@PathVariable int id, @RequestBody Board request){
        Board loc = boardRepository.findById(id);
        if(loc == null)
            return null;

        boardRepository.save(request);
        return boardRepository.findById(id);
    }

    /** Delete a Board **/
    @ApiOperation(value = "Delete a Board", response = Board.class)
    @DeleteMapping("/board/delete/{id}")
    String deleteBoard(@PathVariable int id){
        boardRepository.deleteById(id);
        return "Deleted successfully.";
    }

}
